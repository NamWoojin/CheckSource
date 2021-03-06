# <strong>Check Source</strong>

<br/>

## π νλ‘μ νΈ κ°μ


<img height="400" src="document/main.png" />

- **κ°λ° κΈ°κ°** : 21.04.12 ~ 21.05.21 (6μ£Ό)
- **κ°λ° νκ²½** : Vue.js, Spring Boot, Maria DB, GitLab, JIRA
- **νλ‘μ νΈ μ΄λ¦** : CheckSource
- **νλ‘μ νΈ μ€λͺ :** μ€νμμ€ μ μκΆ κ²μ¦ νλ«νΌ κ°λ°
- **μ¬μ΄νΈ λ§ν¬**
    - **frontend** - [http://checksource.io](http://checksource.io/)
    - **backend** - [http://checksource.io:8080/swagger-ui.html#/](http://52.79.151.0:8080/swagger-ui.html#/)
    - **κΉλ© 1** - [http://gitlab.checksource.io:8081/](http://gitlab.checksource.io:8081/)
    - **κΉλ© 2** - [http://gitlab.checksource.io:8082/](http://gitlab.checksource.io:8081/)

<br/>

## π© Team λμμ μν

![document/team.png](document/team.png)

- <strong>ν©λ€ν¬</strong>
    - [ekgml3765@naver.com](mailto:ekgml3765@naver.com)
    - [https://github.com/ekgml3765](https://github.com/ekgml3765)
    - μ­ν  - backend
- <strong>λ¨μ°μ§</strong>
    - [nam990304@gmail.com](mailto:nam990304@gmail.com)
    - [https://github.com/NamWoojin](https://github.com/NamWoojin)
    - μ­ν  - frontend
- <strong>λ°μμ</strong>
    - [pesu1027@gmail.com](mailto:pesu1027@gmail.com)
    - [https://github.com/eunsu27](https://github.com/eunsu27)
    - μ­ν  - frontend
- <strong>μ€μΉν</strong>
    - [developeryunsh@gmail.com](mailto:developeryunsh@gmail.com)
    - [https://github.com/lovelyunsh](https://github.com/lovelyunsh)
    - μ­ν  - backend
- <strong>λ°νκ· </strong>
    - [phk2246@gmail.com](mailto:phk2246@gmail.com)
    - μ­ν  - backend
- <strong>κ³ μ μ°½</strong>
    - [koyc95@gmail.com](mailto:koyc95@gmail.com)
    - [https://github.com/go95305](https://github.com/go95305)
    - μ­ν  - frontend

<br/>

## π οΈ μ€ν νκ²½ μ€μ  - λ‘μ»¬ νκ²½ μ€ν μ

## π₯οΈ FrontEnd νκ²½ μ€μ 

### 1. Backend μλ² μ κ·Ό μ€μ  λ³κ²½

```
// .\exec\frontend\src\api\http.js

// κΈ°μ‘΄ backend μλ² μ κ·Όμμ
const instance = axios.create({
	baseURL: "http://checksource.io:8080",
});

//μλμ κ°μ΄ λ³κ²½
const instance = axios.create({
	baseURL: "http://localhost:8080",
});
```

### 2. GitLab μ λ³΄ λ³κ²½

```
// .\exec\frontend\src\api\git.js

// κΈ°μ‘΄ λ°°ν¬μ© GitLab μ λ³΄μμ
const baseUrl = [
  "http://gitlab.checksource.io:8081",
  "http://gitlab.checksource.io:8082",
];

//μλμ κ°μ΄ λ³κ²½
const baseUrl = [
  "μ€μΉν κΉλ©1 url",
  "μ€μΉν κΉλ©2 url",
];
```

### 3. Vue.js μ€ν

```
cd .\exec\frontend  //frontend ν΄λ μ κ·Ό
npm install         //νλ‘μ νΈμ μκ΅¬λλ ν¨ν€μ§ μ€μΉ
npm run serve       //νλ‘μ νΈ μ€ν
```

<br/>

## πΎ BackEnd νκ²½ μ€μ 

### 1. Data Base μΈν

- Maria DB μ€μΉ
- port : 3306

### 2. Spring Boot μΈν

```
#IDE μΈν
Workspace .\exec\backend      //workspace μ€μ 
ν΄λΉ IDEμμ checksource νλ‘μ νΈ import
stsμμ μ€νν  κ²½μ°, μμ²΄μ μΌλ‘ lombok μ€μΉ ν import μν¬ κ²
```

```
#dbμλ² λ³κ²½μ
.\exec\backend\checksource\src\main\resources\application.yml
spring:
	datasource:
		url: μ°κ²°ν  DB url
		(ex. jdbc:mariadb://localhost:3306/checksource?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul)
		username: μ€μ νμμ μμ 
		password: μ€μ νμμ μμ 

// dbλ₯Ό μ€μΉν μλ²μ IP:port μ κ±°λ λ‘μ»¬μμ νμ€νΈν  κ²½μ° localhost
```

### 3. Spring Boot μ€ν

```
#Spring boot μλ² μ€ν
// gradle update
// μ€ν
// JPA μ€ννλ©΄ DB μ€ν€λ§ λ° μν°ν° μλ μΈν
```

### 4. DataBase dumpνμΌ μ€ν

```
# λ°μ΄ν°λ² μ΄μ€ μ΄κΈ° λ°μ΄ν° insert
exec\database\dump.sql 
// ν΄λΉ μμΉμ DB dump νμΌμ μ€νμμΌ insert 
```

### 5. GitLab μλ² μμ²΄ κ΅¬μΆ

### backend

1. Gitlab server κ΅¬μΆ
    - Gitlab server μ€μΉ
    - reference: [https://about.gitlab.com/install/](https://about.gitlab.com/install/)

2. κ΅¬μΆν Gitlab serverμ root κ³μ  λ‘κ·ΈμΈ β root Token λ°κΈ

    ![document/gitlab1.png](document/gitlab1.png)

    - root Token λ°κΈ: User Settings > Access Tokens

    ![document/gitlab2.png](document/gitlab2.png)
    
    - ν ν° λ°κΈμ μ ν¨κΈ°κ° μ€μ νμ§ λ§ κ²
3. Database gitlab νμ΄λΈ λ³κ²½

    ![document/gitlab3.png](document/gitlab3.png)
    
    - gitlab μλ²λ μ΅λ 2κ°κΉμ§λ§ κ°λ₯ν©λλ€.
    - λ°μ΄ν° λ² μ΄μ€ λ΄μ gitlab base_urlκ³Ό root_access_tokenμ updateλ¬Έμ ν΅ν΄ μ§μ  μμ 

    ```
    # SQLλ¬Έ

    select * from gitlab;

    #κΉλ©1 μ λ³΄ μμ 
    update gitlab set base_url = "κΉλ©1 url" where gitlab_id = 1;
    update gitlab set root_access_token = "λ£¨νΈ ν ν°" where gitlab_id = 1;

    #κΉλ©2 μ λ³΄ μμ 
    update gitlab set base_url = "κΉλ©2 url" where gitlab_id = 2;
    update gitlab set root_access_token = "λ£¨νΈ ν ν°" where gitlab_id = 2;
    ```

<br/>

## π οΈ μ€ν νκ²½ μ€μ  - λ°°ν¬ νκ²½ μ€ν μ

## π₯οΈ FrontEnd νκ²½ μ€μ 

### 1. Backend μλ² μ κ·Ό μ€μ  λ³κ²½

```
// .\exec\frontend\api\http.js

// κΈ°μ‘΄ backend μλ² μ κ·Όμμ
const instance = axios.create({
	baseURL: "http://checksource.io:8080",
});

//μλμ κ°μ΄ λ³κ²½
const instance = axios.create({
	baseURL: "http://{backend λ°°ν¬ URL or IP:ν¬νΈ}",
});
```

### 2. GitLab μ λ³΄ λ³κ²½

```
// .\exec\frontend\src\api\git.js

// κΈ°μ‘΄ λ°°ν¬μ© GitLab μ λ³΄μμ
const baseUrl = [
  "http://gitlab.checksource.io:8081",
  "http://gitlab.checksource.io:8082",
];

//μλμ κ°μ΄ λ³κ²½
const baseUrl = [
  "μ€μΉν κΉλ©1 url",
  "μ€μΉν κΉλ©2 url",
];
```

<br/>

## πΎ BackEnd νκ²½ μ€μ 

### 1. μλ² Data Base μΈν

- Maria DB μ€μΉ
- port : 3306

### 2. GitLab μλ² μμ²΄ κ΅¬μΆ

- Local μΈνμ μ ν λ΄μ©κ³Ό λμΌ

### 3. Spring Boot μΈν

```
#application.yml νμΌ μμ 
.\exec\backend\checksource\src\main\resources\application.yml
spring:
	datasource:
		url: μ°κ²°ν  DB url
		(ex. jdbc:mariadb://{DBλ₯Ό μ€μΉν IP λλ λλ©μΈ}:3306/checksource?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul)
		username: μ€μ νμμ μμ 
		password: μ€μ νμμ μμ 
```

### 4. DataBase dump νμΌ μ€ν

```
# λ°μ΄ν°λ² μ΄μ€ μ΄κΈ° λ°μ΄ν° insert
exec\database\dump.sql
// ν΄λΉ μμΉμ DB dump νμΌμ μ€νμμΌ insert 
```

### 5. λ°°ν¬

- μλ²μ Jenkins μ€μΉ ν
    - λ§€κ°λ³μ μΈν
        - CREDENTIALIS_ID, GIT_URL
    - jenkins pipeline μ€μ 
        - exec\Jenkinsfile.groovy

<br/>

## **πκΈ°μ μ€ν**

### **OS**

- Ubuntu : 20.04

### **Frontend**

- Vue.js : 2.6.11

### **Backend**

- Spring Boot: 2.4.5

### **DB**

- MariaDB: 10.2

### **CI/CD**

- Jenkins : 2.290
- docker : 20.10.6

<br/>

## π μ£ΌμκΈ°λ₯

### λΆμ / κ²μ¦

- κ²μ¦ν  νλ‘μ νΈ μ ν
    - GitLab, GitHub λ± ν΄λΉ μ°λλ κ³μ μ repository λͺ©λ‘μ λΆλ¬μ κ²μ¦νκ³  μΆμ νλ‘μ νΈ μ ν
- κ²μ¦ν νλ‘μ νΈ λͺ©λ‘/κ²μ
    - λΆμλ³ κ²μ¦ν νλ‘μ νΈμ μ μ²΄λͺ©λ‘ μ‘°ν λ° κ²μ
- κ²μ¦ν νλ‘μ νΈ λ³΄κ³ μ
    - λΆμκ²°κ³Ό ν­
        - κ²μ¦ν νλ‘μ νΈμ κ²μ¦λ μ€νμμ€ μ, μ°κ²°μ΄ νμν μ€νμμ€ μ, κ²μ¦λ λΌμ΄μ μ€ μ,  μ£Όμκ° νμν λΌμ΄μ μ€ μ μμ½μ λ³΄ νμΈ
    - μ€νμμ€ ν­
        - κ²μ¦ν νλ‘μ νΈμ μ°λλ μ€νμμ€, μ°λλμ§ μμ μ€νμμ€ λͺ©λ‘ νμΈ
        - μ°λλμ§ μμ μ€νμμ€ μΆκ°
    - λΌμ΄μ μ€ ν­
        - κ²μ¦ν νλ‘μ νΈμ κ²μ¦λ λΌμ΄μ μ€ λͺ©λ‘ νμΈ

### λμλ³΄λ

- λΆμλ³ μ λ³΄
    - μ μ²΄ λΆμμ κ²μ¦ν νλ‘μ νΈ μ, κ²μ¦ν μ€νμμ€ μ’λ₯ κ°μ, κ²μ¦ν λΌμ΄μ μ€ μ’λ₯ κ°μ, κ²μ¦ν νλ‘μ νΈμ warning κ°μ μ‘°ν
- μ€νμμ€ TOP5
    - μ μ²΄ λΆμμ κ²μ¦ν νλ‘μ νΈ μ€, κ°μ₯ λ§μ΄ μ¬μ©ν μ€νμμ€ TOP 5 μ‘°ν
- λΌμ΄μ μ€ μλ¬΄ Warning
    - μ μ²΄ λΆμμ κ²μ¦ν νλ‘μ νΈ μ€, λΆμλ³ νλ‘μ νΈμ κ²½κ³  λΌμ΄μ μ€ μμ ν¨κ» μ£Όμν΄μΌν  νλ‘μ νΈ λͺ©λ‘ μ‘°ν

### λ΄ λΆμ ν΅κ³

- ν΅κ³ μ λ³΄
    - λ΄ λΆμμ κ²μ¦ν νλ‘μ νΈ μ, κ²μ¦ν μ€νμμ€ μ’λ₯ κ°μ, κ²μ¦ν λΌμ΄μ μ€ μ’λ₯ κ°μ, κ²μ¦ν νλ‘μ νΈμ warning κ°μ μ‘°ν
- μ€νμμ€ TOP5
    - λ΄ λΆμμ κ²μ¦ν νλ‘μ νΈ μ€, κ°μ₯ λ§μ΄ μ¬μ©ν μ€νμμ€ TOP 5 μ‘°ν
- λΌμ΄μ μ€ μλ¬΄ Warning
    - λ΄ λΆμμ κ²μ¦ν νλ‘μ νΈ μ€, λΆμλ³ νλ‘μ νΈμ κ²½κ³  λΌμ΄μ μ€ μμ ν¨κ» μ£Όμν΄μΌν  νλ‘μ νΈ λͺ©λ‘ μ‘°ν

### μ€νμμ€

- μ€νμμ€ λͺ©λ‘/κ²μ
    - λ°μ΄ν°λ² μ΄μ€μ μμ§λμ΄ μλ μ€νμμ€ μ λ³΄ μ‘°ν
    - λΌμ΄μ μ€μ μ€νμμ€ λͺμΌλ‘ κ²μ
- μ€νμμ€ μμΈμ λ³΄
    - λͺ©λ‘μμ μ νν μ€νμμ€μ μ€νμμ€λͺ, λΌμ΄μ μ€, Copyright, urlμ£Όμ, Dependency μ λ³΄ μ‘°ν

### λΌμ΄μ μ€

- λΌμ΄μ μ€ λͺ©λ‘/κ²μ
    - λ°μ΄ν°λ² μ΄μ€μ μμ§λμ΄ μλ λΌμ΄μ μ€ μ λ³΄ μ‘°ν
    - λΌμ΄μ μ€λͺκ³Ό μλ³μλͺμΌλ‘ κ²μ
- λΌμ΄μ μ€ μμΈλ³΄κΈ°
    - λͺ©λ‘μμ μ νν λΌμ΄μ μ€μ λΌμ΄μ μ€λͺ, μλ³μ, μ½λκ³΅κ°μ¬λΆ, urlμ£Όμ, λΌμ΄μ μ€ μ λ¬Έ, μλ¬΄μ¬ν­ μ λ¦¬ν μ‘°ν

### λ§μ΄νμ΄μ§

- νλ‘ν
    - κΈ°λ³Έμ λ³΄ μμ 
        - μ΄λ¦, λΆμ, μ§κΈ, νλ‘ν μμ΄μ½ μμ  κ°λ₯
- νμκ΄λ¦¬
    - κ²μ¦μ μ¬μ©λ  GitLab, GitHub κ³μ  μ°λ, ν΄μ 

<br/>

## π νλ‘μ νΈ μ°μΆλ¬Ό

- [Check Source λ¬Έμμ λ¦¬](https://www.notion.so/f60d090cba784f32a66ecdbf289f65f9)
- [Backend κΈ°λ₯λͺμΈμ](https://docs.google.com/spreadsheets/d/11KNxKlUoQtLbTplsuT1WPCbLQ96ZR96KuIsGtDj7Ilw/edit?usp=sharing)
- [ERD](https://drive.google.com/file/d/1C0tlvul8g19nobMH9tSm2jotK9yx_CBa/view?usp=sharing)
- [Frontend κΈ°λ₯λͺμΈμ](https://docs.google.com/spreadsheets/d/1gch-bEHKeZvm0v83CO2WlWjSOU7FjEwFJtDxWLeF6Oc/edit#gid=1830621374)
- [μμ΄μ΄νλ μ](https://drive.google.com/file/d/1wuUlLT1yP3oWWK94v7109wLCLmOcXR_Q/view)
- [UCC](https://www.youtube.com/watch?v=pTuPUViS3sU)
- [μ΅μ’λ°ν PPT](https://drive.google.com/file/d/1UeYpgywgYOsJW2UWtvU53h2vwDtWUaYr/view?usp=sharing)
- [νμ΄μ§ μκ°](https://www.notion.so/6b942c0956a34cb286d2da537b15eb53)