# Spring Patterns Client Manager

Project made with the Dio course of Java, design patterns in a REST API.

The project carried out is a Spring Boot application that involves controlling clients (Client) and their addresses (Address). Additionally, the application uses the ViaCEP API to obtain address details based on zip code.

The following technologies were used:

- Spring Boot
- Spring Data JPA
- Spring MVC
- OpenFeign
- ViaCEP API

We also have some implementations and references to design patterns, such as:

- Strategy Pattern
- Singleton Pattern:
- Dependency Injection
- Factory Pattern (Possibly): The consultCep method in the ViaCepService interface could be considered a form of Factory Method, as it represents a method for creating Address instances based on external data.
