# Nephrologists

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

## Unit Test
![](https://github.com/cafetochallengeusr09/nephrologists-back/blob/master/docs/img/2.png)

## Logs
```
2020-03-29 19:08:58.945  INFO 7370 --- [nio-8080-exec-9] c.c.c.a.s.JwtRequestFilter               : INTERCEPT URL /api/v1/s1/clinic-type/listAll
2020-03-29 19:08:59.079  INFO 7370 --- [nio-8080-exec-9] c.c.c.a.c.ControllerBase                 : GET ALL FROM -> com.cafeto.challenge.clinicType.service.ClinicTypeServiceHandler
Hibernate: 
    select
        clinictype0_.id as id1_2_,
        clinictype0_.description as descript2_2_ 
    from
        clinic_type clinictype0_
2020-03-29 19:11:25.905  INFO 7370 --- [nio-8080-exec-2] c.c.c.a.s.JwtRequestFilter               : INTERCEPT URL /api/v1/s1/clinic-type/386
2020-03-29 19:11:26.069  INFO 7370 --- [nio-8080-exec-2] c.c.c.a.c.ControllerBase                 : GET ONE FROM -> com.cafeto.challenge.clinicType.service.ClinicTypeServiceHandler WITH ID=386
Hibernate: 
    select
        clinictype0_.id as id1_2_0_,
        clinictype0_.description as descript2_2_0_ 
    from
        clinic_type clinictype0_ 
    where
        clinictype0_.id=?
2020-03-29 19:12:55.083  INFO 7370 --- [nio-8080-exec-3] c.c.c.a.s.JwtRequestFilter               : INTERCEPT URL /api/v1/s1/clinic-type/386
2020-03-29 19:12:55.264  INFO 7370 --- [nio-8080-exec-3] c.c.c.a.c.ControllerBase                 : GET ONE FROM -> com.cafeto.challenge.clinicType.service.ClinicTypeServiceHandler WITH ID=386
Hibernate: 
    select
        clinictype0_.id as id1_2_0_,
        clinictype0_.description as descript2_2_0_ 
    from
        clinic_type clinictype0_ 
    where
        clinictype0_.id=?
2020-03-29 19:13:18.952  INFO 7370 --- [nio-8080-exec-4] c.c.c.a.s.JwtRequestFilter               : INTERCEPT URL /api/v1/s1/clinic-type/update
2020-03-29 19:13:19.121  INFO 7370 --- [nio-8080-exec-4] c.c.c.a.c.ControllerBase                 : PUT ClinicType(id=386, description=ENFERMEDADES SISTÉMICAS Y AUTOINMUNES)
Hibernate: 
    select
        clinictype0_.id as id1_2_0_,
        clinictype0_.description as descript2_2_0_ 
    from
        clinic_type clinictype0_ 
    where
        clinictype0_.id=?
2020-03-29 19:15:04.313  INFO 7370 --- [nio-8080-exec-6] c.c.c.a.s.JwtRequestFilter               : INTERCEPT URL /api/v1/s1/clinic-type/386
2020-03-29 19:15:04.432  INFO 7370 --- [nio-8080-exec-6] c.c.c.a.c.ControllerBase                 : GET ONE FROM -> com.cafeto.challenge.clinicType.service.ClinicTypeServiceHandler WITH ID=386

```
