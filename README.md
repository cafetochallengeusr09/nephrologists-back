# Nephrologists
![](https://img.shields.io/badge/version-1.0-<COLOR>)
![](https://img.shields.io/badge/languaje-Java-<COLOR>)
![](https://img.shields.io/badge/Framework-Spring-<COLOR>)
![](https://img.shields.io/badge/DB-Postgresql-<COLOR>)

## Description

The Frontend Developer needs the necessary services to implement the Catalog Management UI for the
payment of the Nephrologists who work for the Clinics network. For now, In this first phase only the
administration of the catalogs is required, the generation of the payroll will be part of a following phase.
The list of catalogs and their properties are expanded in the following Slide.
Each catalog is required to be able to perform the following tasks: create, edit, delete, list the items in the
catalog.

## Entities Detail
* User [Login, Password, Name, Email]
> Encrypted password
* Nephrologist [Id, Name, Nephrologist Type, Email, Active]
> A Nephrologist may be assigned to more than one base clinic
* Nephrologist Type [Id, Description]
* Clinic [Id, Name, Administrator, Email, Director, City, Capacity, Clinic Type]
* Nephrologist Base Clinic [Id, Nephrologist, Clinic, Salary, Dedication Hours]
* Clinic Type [Id, Description]
* City [Id, Description, Zone]
* Zone [Id, Description]

## Data Base Design
![](https://github.com/cafetochallengeusr09/nephrologists-back/blob/master/docs/img/1.png)

## Database Connection

### Dev Environment
* Please open file **application.integration.properties** locate in **/src/main/resources**
* Edit the next values:
```batch
spring.datasource.url=jdbc:postgresql://192.168.2.12:5432/postgres?currentSchema=cafeto_challenge_janez
spring.datasource.username=postgres
spring.datasource.password=Usrdev2020*-
```

### Live Environment
* Please open file **application.properties** locate in **/src/main/resources**
* Edit the next values:
```batch
spring.datasource.url=jdbc:postgresql://192.168.2.12:5432/postgres?currentSchema=cafeto_challenge_janez
spring.datasource.username=postgres
spring.datasource.password=Usrdev2020*-
```

## Run
### Pre-Conditions
* Run script locate in **sql/CREATE TABLES.sql**

### Run Server
```batch
mvn spring-boot:run
```

## Unit Test
![](https://github.com/cafetochallengeusr09/nephrologists-back/blob/master/docs/img/2.png)

## Logs
```shell
2020-03-29 19:08:58.945  INFO 7370 --- [nio-8080-exec-9] c.c.c.a.s.JwtRequestFilter : INTERCEPT URL /api/v1/s1/clinic-type/listAll
2020-03-29 19:08:59.079  INFO 7370 --- [nio-8080-exec-9] c.c.c.a.c.ControllerBase   : GET ALL FROM -> com.cafeto.challenge.clinicType.service.ClinicTypeServiceHandler
Hibernate: 
    select
        clinictype0_.id as id1_2_,
        clinictype0_.description as descript2_2_ 
    from
        clinic_type clinictype0_
2020-03-29 19:11:25.905  INFO 7370 --- [nio-8080-exec-2] c.c.c.a.s.JwtRequestFilter : INTERCEPT URL /api/v1/s1/clinic-type/386
2020-03-29 19:11:26.069  INFO 7370 --- [nio-8080-exec-2] c.c.c.a.c.ControllerBase   : GET ONE FROM -> com.cafeto.challenge.clinicType.service.ClinicTypeServiceHandler WITH ID=386
Hibernate: 
    select
        clinictype0_.id as id1_2_0_,
        clinictype0_.description as descript2_2_0_ 
    from
        clinic_type clinictype0_ 
    where
        clinictype0_.id=?
2020-03-29 19:13:18.952  INFO 7370 --- [nio-8080-exec-4] c.c.c.a.s.JwtRequestFilter : INTERCEPT URL /api/v1/s1/clinic-type/update
2020-03-29 19:13:19.121  INFO 7370 --- [nio-8080-exec-4] c.c.c.a.c.ControllerBase   : PUT ClinicType(id=386, description=ENFERMEDADES SISTÉMICAS Y AUTOINMUNES)
Hibernate: 
    select
        clinictype0_.id as id1_2_0_,
        clinictype0_.description as descript2_2_0_ 
    from
        clinic_type clinictype0_ 
    where
        clinictype0_.id=?

```
## Project Folder Structure
```shell
├── docs
│   └── img
│       ├── 1.png
│       └── 2.png
├── HELP.md
├── LICENSE
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── sql
│   └── CREATE TABLES.sql
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── cafeto
│   │   │           └── challenge
│   │   │               ├── api
│   │   │               │   ├── commons
│   │   │               │   │   ├── Constants.java
│   │   │               │   │   ├── ControllerBase.java
│   │   │               │   │   ├── ResponseBase.java
│   │   │               │   │   └── ServiceBase.java
│   │   │               │   └── security
│   │   │               │       ├── controller
│   │   │               │       │   └── AuthController.java
│   │   │               │       ├── helper
│   │   │               │       │   ├── AESCipher.java
│   │   │               │       │   ├── DefaultAESCipher.java
│   │   │               │       │   ├── DefaultSecretKeyProvider.java
│   │   │               │       │   └── SecretKeyProvider.java
│   │   │               │       ├── JwtAuthenticationEntryPoint.java
│   │   │               │       ├── JwtRequestFilter.java
│   │   │               │       ├── model
│   │   │               │       │   └── JwtResponse.java
│   │   │               │       ├── service
│   │   │               │       │   ├── CipherService.java
│   │   │               │       │   ├── JwtTokenHelper.java
│   │   │               │       │   └── JwtUserDetailsService.java
│   │   │               │       └── WebSecurityConfig.java
│   │   │               ├── CafetoChallengeApplication.java
│   │   │               ├── city
│   │   │               │   ├── controller
│   │   │               │   │   └── CityController.java
│   │   │               │   ├── model
│   │   │               │   │   └── City.java
│   │   │               │   ├── repository
│   │   │               │   │   └── CityRepository.java
│   │   │               │   └── service
│   │   │               │       ├── CityServiceHandler.java
│   │   │               │       └── CityService.java
│   │   │               ├── clinic
│   │   │               │   ├── controller
│   │   │               │   │   └── ClinicController.java
│   │   │               │   ├── model
│   │   │               │   │   └── Clinic.java
│   │   │               │   ├── repository
│   │   │               │   │   └── ClinicRepository.java
│   │   │               │   └── service
│   │   │               │       ├── ClinicServiceHandler.java
│   │   │               │       └── ClinicService.java
│   │   │               ├── clinicType
│   │   │               │   ├── controller
│   │   │               │   │   └── ClinicTypeController.java
│   │   │               │   ├── model
│   │   │               │   │   └── ClinicType.java
│   │   │               │   ├── repository
│   │   │               │   │   └── ClinicTypeRepository.java
│   │   │               │   └── service
│   │   │               │       ├── ClinicTypeServiceHandler.java
│   │   │               │       └── ClinicTypeService.java
│   │   │               ├── nephrologist
│   │   │               │   ├── controller
│   │   │               │   │   └── NephrologistController.java
│   │   │               │   ├── model
│   │   │               │   │   └── Nephrologist.java
│   │   │               │   ├── repository
│   │   │               │   │   └── NephrologistRepository.java
│   │   │               │   └── service
│   │   │               │       ├── NephrologistServiceHandler.java
│   │   │               │       └── NephrologistService.java
│   │   │               ├── nephrologistBaseClinic
│   │   │               │   ├── controller
│   │   │               │   │   └── NephrologistBaseClinicController.java
│   │   │               │   ├── model
│   │   │               │   │   └── NephrologistBaseClinic.java
│   │   │               │   ├── repository
│   │   │               │   │   └── NephrologistBaseClinicRepository.java
│   │   │               │   └── service
│   │   │               │       ├── NephrologistBaseClinicServiceHandler.java
│   │   │               │       └── NephrologistBaseClinicService.java
│   │   │               ├── nephrologistType
│   │   │               │   ├── controller
│   │   │               │   │   └── NephrologistTypeController.java
│   │   │               │   ├── model
│   │   │               │   │   └── NephrologistType.java
│   │   │               │   ├── repository
│   │   │               │   │   └── NephrologistTypeRepository.java
│   │   │               │   └── service
│   │   │               │       ├── NephrologistTypeServiceHandler.java
│   │   │               │       └── NephrologistTypeService.java
│   │   │               ├── user
│   │   │               │   ├── controller
│   │   │               │   │   └── UserController.java
│   │   │               │   ├── model
│   │   │               │   │   └── User.java
│   │   │               │   ├── repository
│   │   │               │   │   └── UserRepository.java
│   │   │               │   └── service
│   │   │               │       ├── UserServiceHandler.java
│   │   │               │       └── UserService.java
│   │   │               └── zone
│   │   │                   ├── controller
│   │   │                   │   └── ZoneController.java
│   │   │                   ├── model
│   │   │                   │   └── Zone.java
│   │   │                   ├── repository
│   │   │                   │   └── ZoneRepository.java
│   │   │                   └── service
│   │   │                       ├── ZoneServiceHandler.java
│   │   │                       └── ZoneService.java
│   │   └── resources
│   │       ├── application.integration.properties
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── cafeto
│                   └── challenge
│                       ├── GlobalTest.java
│                       ├── helper
│                       │   ├── CafetoMockBase.java
│                       │   ├── CleanUpTest.java
│                       │   ├── HttpMockMvcComponent.java
│                       │   └── PerformMockMvcComponent.java
│                       └── modularTest
│                           ├── CityTest.java
│                           ├── ClinicTest.java
│                           ├── ClinicTypeTest.java
│                           ├── NephrologistBaseClinicTest.java
│                           ├── NephrologistTest.java
│                           ├── NephrologistTypeTest.java
│                           ├── UserTest.java
│                           └── ZoneTest.java
└── st-market.iml
```

## Services URL
See all services URI in [SWAGGER](http://localhost:8080/api-docs/swagger-ui/index.html?configUrl=/api-docs/swagger-config#/)

## Sample of API Resquest
See all samples of API Resquest in [POSTMAN RESTFUL API](https://cafetochallengejanezmejias.postman.co/collections/9842273-4179836b-0b12-4e5d-bdd6-4e4534461af6?version=latest&workspace=9104109b-e29c-4017-8fd1-be9156b1e1aa#40e4a4b5-28a3-42e8-899e-252dbbb5acf4)

