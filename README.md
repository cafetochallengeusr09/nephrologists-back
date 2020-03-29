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
* Encrypted password
* Nephrologist [Id, Name, Nephrologist Type, Email, Active]
  A Nephrologist may be assigned to more than one base clinic
* Nephrologist Type [Id, Description]
* Clinic [Id, Name, Administrator, Email, Director, City, Capacity, Clinic Type]
* Nephrologist Base Clinic [Id, Nephrologist, Clinic, Salary, Dedication Hours]
* Clinic Type [Id, Description]
* City [Id, Description, Zone]
* Zone [Id, Description]
