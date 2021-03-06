package com.ssafy.checksource.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ssafy.checksource.model.entity.*;
import com.ssafy.checksource.model.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.checksource.config.security.JwtTokenProvider;
import com.ssafy.checksource.model.dto.AnalyLicenseListDTO;
import com.ssafy.checksource.model.dto.AnalyMappedOpensouceListDTO;
import com.ssafy.checksource.model.dto.AnalyProjectListByDepartDTO;
import com.ssafy.checksource.model.dto.AnalyProjectSummaryDTO;
import com.ssafy.checksource.model.dto.AnalyUnmappedOpensouceListDTO;
import com.ssafy.checksource.model.dto.OpensourceDTO;
import com.ssafy.checksource.model.dto.ProjectInfoDTO;
import com.ssafy.checksource.model.dto.ProjectLiceseListDTO;
import com.ssafy.checksource.model.dto.ProjectListByDepartDTO;
import com.ssafy.checksource.model.dto.UnmappendOpensourceDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {

	private final JwtTokenProvider jwtTokenProvider;
	private final ModelMapper modelMapper = new ModelMapper();
	private final UserRepository userRepository;
	private final ProjectRepository projectRepository;
	private final DepartRepository departRepository;
	private final LicenseOpensourceRepository licenseOpensourceRepository;
	private final LicenseRepository licenseRepository;
	private final OpensourceProjectRepository opensourceProjectRepository;
	private final UnmappedOpensourceRepository unmappedOpensourceRepository;
	private final GitHubRepository gitHubRepository;

	//summary
	public AnalyProjectSummaryDTO getSummaryByProject(String gitProjectId, Long gitType) {
		Project project = projectRepository.findByGitProjectIdAndGitType(gitProjectId, gitType);
		Long projectId = project.getProjectId();
		AnalyProjectSummaryDTO analySummaryDto = new AnalyProjectSummaryDTO();
		int unmappingOpensourceCnt = unmappedOpensourceRepository.findAllByProject(project).size();
		int mappingOpensourceCnt = opensourceProjectRepository.findAllByProject(project).size();
		int analyOpensourceCnt = unmappingOpensourceCnt + mappingOpensourceCnt;
		List<License> licenseList = licenseRepository.findCountByProjectId(projectId);
		int analyLicenseCnt = licenseList.size();
		int requireCheckingLicenseCnt = 0;
		for (License license : licenseList) {
			if(license.getSourceopen().length() > 0) //???????????? ???????????? ?????? null??? ????????????, ????????? ????????? ????????????
				requireCheckingLicenseCnt++;
		}
		analySummaryDto.setUnmappingOpensourceCnt(unmappingOpensourceCnt); //????????? ???????????? ???
		analySummaryDto.setAnalyOpensourceCnt(analyOpensourceCnt); //????????? ???????????? ??? (??????+?????????)
		analySummaryDto.setAnalyLicenseCnt(analyLicenseCnt); //????????? ???????????? ???
		analySummaryDto.setRequireCheckingLicenseCnt(requireCheckingLicenseCnt); //????????? ????????? ????????????

		return analySummaryDto;
	}



	//???????????? ??????
	public ProjectInfoDTO getProjectName(String gitProjectId, Long gitType) {
		ProjectInfoDTO projectInfoDto = new ProjectInfoDTO();
		Project project = projectRepository.findByGitProjectIdAndGitType(gitProjectId, gitType);
		projectInfoDto = modelMapper.map(project, ProjectInfoDTO.class);
		return projectInfoDto;
	}

	// ????????? ????????? ???????????? ??????
	public AnalyProjectListByDepartDTO  getProjectListByDepart(Long departId, int currentPage, int size, String time, String keyword) {
		AnalyProjectListByDepartDTO analyProjectByDepartDto = new AnalyProjectListByDepartDTO();

		List<ProjectListByDepartDTO> projectListDto = new ArrayList<ProjectListByDepartDTO>();
		PageRequest pageRequest = PageRequest.of(currentPage - 1, size);
		Page<Project> projectList = null;

		//?????? ????????? ?????????
		if(keyword.equals(".") || keyword.equals("")) {
			projectList = projectRepository.findByDepart(departId, pageRequest, time);
		}else {//????????? ?????? ??????
			projectList = projectRepository.findByDepartAndKeyword(departId, pageRequest, time, "%"+keyword+"%");
		}

		for (Project project : projectList.getContent()) {
			ProjectListByDepartDTO projectDto = new ProjectListByDepartDTO();
			projectDto = modelMapper.map(project, ProjectListByDepartDTO.class);
			//???????????? id??? ????????? ??? ???????????? ??????
			int unmappingOpensourceCnt = unmappedOpensourceRepository.findAllByProject(project).size();
			int mappingOpensourceCnt = opensourceProjectRepository.findAllByProject(project).size();
			int analyOpensourceCnt = unmappingOpensourceCnt + mappingOpensourceCnt;
			projectDto.setOpensourceCnt(analyOpensourceCnt);
			//???????????? id??? ????????? ???????????? ??????
			List<LicenseOpensource> licenseOpensourceList = new ArrayList<LicenseOpensource>();
			licenseOpensourceList = licenseOpensourceRepository.findAllByProjectId(project.getProjectId());
			List<ProjectLiceseListDTO> licenseList = licenseOpensourceList.stream().map(ProjectLiceseListDTO::new).distinct().collect(Collectors.toList());
			projectDto.setLicenseCnt(licenseList.size());
			//??????
			projectDto.setUserId(project.getUser().getUserId());
			projectDto.setUsername(project.getUser().getName());

			Optional<GithubUser> githubUser = Optional.ofNullable(gitHubRepository.findByUser(project.getUser()));
			if(githubUser.isPresent()){
			    projectDto.setGithubId(githubUser.get().getGithubId());
			    projectDto.setGithubUsername(githubUser.get().getUsername());
            }
			projectListDto.add(projectDto);

		}

		analyProjectByDepartDto.setProjectList(projectListDto);
		analyProjectByDepartDto.setTotalPages(projectList.getTotalPages());

		return analyProjectByDepartDto;
	}

	// ????????? ??????????????? ????????? ???????????? ??????
	public AnalyMappedOpensouceListDTO getMappedOpensourceListByProject (String gitProjectId, Long gitType, int size, int currentPage) {
		Project project = projectRepository.findByGitProjectIdAndGitType(gitProjectId, gitType);
		Long projectId = project.getProjectId();
		PageRequest pageRequest = PageRequest.of(currentPage - 1, size);
		Page<OpensourceProject> opensourceList = opensourceProjectRepository.findByProject(project, pageRequest);
		List<OpensourceDTO> mappedopensourceListDto = new ArrayList<OpensourceDTO>();
		mappedopensourceListDto = opensourceList.getContent().stream().map(OpensourceDTO::new).collect(Collectors.toList());
		AnalyMappedOpensouceListDTO mappedList = new AnalyMappedOpensouceListDTO();
		mappedList.setTotalPages(opensourceList.getTotalPages());
		mappedList.setMappedList(mappedopensourceListDto);
		return mappedList;
	}

	// ????????? ??????????????? ???????????? ???????????? ??????
	public AnalyUnmappedOpensouceListDTO getUnmappedOpensourceListByProject(String gitProjectId, Long gitType, int size, int currentPage) {
		Project project = projectRepository.findByGitProjectIdAndGitType(gitProjectId, gitType);
		Long projectId = project.getProjectId();
		PageRequest pageRequest = PageRequest.of(currentPage - 1, size);
		Page<UnmappedOpensource> unMappedOpensouce = unmappedOpensourceRepository.findByProject(project, pageRequest);
		List <UnmappendOpensourceDTO> unmappedListDto = new ArrayList<UnmappendOpensourceDTO>();
		unmappedListDto = unMappedOpensouce.getContent().stream().map(UnmappendOpensourceDTO::new).collect(Collectors.toList());
		AnalyUnmappedOpensouceListDTO analyUnmappedList = new AnalyUnmappedOpensouceListDTO();
		analyUnmappedList.setTotalPages(unMappedOpensouce.getTotalPages());
		analyUnmappedList.setUnmappedList(unmappedListDto);
		return analyUnmappedList;
	}


	// ????????? ??????????????? ???????????? ??????
	public AnalyLicenseListDTO getLicenseListByProject(String gitProjectId, Long gitType, int size, int currentPage) {
		Project project = projectRepository.findByGitProjectIdAndGitType(gitProjectId, gitType);
		Long projectId = project.getProjectId();
		PageRequest pageRequest = PageRequest.of(currentPage - 1, size);
		Page<License> projectLicense = licenseRepository.findAllByProjectId(projectId, pageRequest);
		List<ProjectLiceseListDTO> licenseList = new ArrayList<ProjectLiceseListDTO>();
		licenseList = projectLicense.getContent().stream().map(ProjectLiceseListDTO::new).collect(Collectors.toList());
		AnalyLicenseListDTO analyLicenseList = new AnalyLicenseListDTO();
		analyLicenseList.setTotalPages(projectLicense.getTotalPages());
		analyLicenseList.setLicenseList(licenseList);
		return analyLicenseList;
	}
}
