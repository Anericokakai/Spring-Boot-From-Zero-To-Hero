# Validation of Inputs in Spring boot
The controller should not be responsible for handling errors or validating inputs, this breaks the Single Responsibility Principle
[SOLID principles](https://blogs.oracle.com/javamagazine/post/curly-braces-java-solid-design) by Eric J. Bruno. A class should have single responsibility only .The cotroller 
should only be a handler for the request and response .

To validate inputs in springboot we will use a dependency called ``Spring--boot-stater-validation``, this dependency has most of the checks performed internally
we only need to annotate our inputs with the in-built validators

### Adding the Validation Dependency
Navigate to the ``pom.xml`` and inside the dependencies add this dependency
```xml

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>

```
reload the maven for the changes to apply , 
When you go to your ``Dto`` folder you need to add annotations just above the fields you want to validate


# craeting custom error Handlers
## @RestControllerAdvice
Spring handle all ``RestController``  errors using the ``@RestControllerAdvice`` including the validation error ``MethodArgumentNotValidException``
by default spring returns a 400 status when validation fails but with nothing useful