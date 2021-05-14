
# Spring injected beans are null using Lombok and Constructor Injection

When I was migrating a maven project implemented with Spring to Spring Boot 1.5.20.RELEASE.
I realized of this issue related with a ``final public`` method inside a non ``final`` class annotated
with ``@Transactional``, causing injected beans within class became ``null`.

In order to resolve the issue I could reproduce it in this small project.
For more information visit [stackoverflow](https://stackoverflow.com/questions/56483269/spring-injected-beans-are-null-using-lombock-and-constructor-injection)

## Which technologies are being used

The project uses the following technologies:

- Spring Boot v1.5.20.RELEASE
- Spring Data JPA
- Hibernate
- H2 embedded database
- Lombock

## Prerequisites and getting started

In order to run the application you must have JDK 8 installed on your local machine. The solution has been tested on JDK 8 update 172.

During the start process the solution will execute two sql scripts to create the database shema (schema.sql) and import test data (data.sql)

When you have JDK 8 installed you need to perform the following steps:

1. Execute the following command on the command line ``./mvnw clean install``
2. The implemented unit test should fail for the ``update`` operation because of the bug.
3. Go to ``UserServiceImpl.java`` file and remove de ``final`` keyword in line 19.
4. Save changes and perform step 1, once again. The unit test should not fail during its execution
