## Prerequisite for running project
-JDK must be işnstalled.\
-PostgreSQL must be installed than u should create a database named `deneme6`. \
-username and password for database is `postgres`. You can change it from `src.main.resources.application.properties` 

## To run the project 
-First you can run project via an IDE.\
-Or you can bootstrap project from terminal inside project directory by typing `./gradlew build` and after build finished type `java -jar ./build/libs/employee-management-0.0.1-SNAPSHOT.jar`

## API Information
-This is a backend project without frontend.\
-You can use endpoints from postman.\
-Project uses 2 different model.

## Employees endpoint
`-Get request(getAll): ` http://localhost:8082/api/employees/ \
`-Get request(getById): ` http://localhost:8082/api/employees/{id} \
`-Post request: ` http://localhost:8082/api/employees \
`-Put request: ` http://localhost:8082/api/employees/{id} \
`Note------` To make put and post request you must provide `departmentId` instead of `department`.\

`Example for put and post`(you don't need to provide `id` in post request):  \     

{\
        "id":10, \
        "name": "Furkan",\
        "surname": "Ören",\
        "email": "frknorn67@gmail.com",\
        "departmentId": 2,\
        "age": 24\
}

## Departments endpoint
`-Get request(getAll): ` http://localhost:8082/api/departments/ \
`-Get request(getById): ` http://localhost:8082/api/departments/{id} \
`-Post request: ` http://localhost:8082/api/departments \
`-Put request: ` http://localhost:8082/api/departments/{id} \

`Example for put and post`(you don't need to provide `id` in post request): \  

{\
        "id":10, \
        "name": "Arge",\
        "manager": "Furkan \
}

