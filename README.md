# MVC CRUD + Login (Spring Boot, Thymeleaf, Security, H2)

Proyecto listo para **IntelliJ IDEA** con **Maven**.

## Requisitos
- Java 17
- Maven
- IntelliJ IDEA

## Cómo ejecutar
```bash
mvn spring-boot:run
```

- Abre: `http://localhost:8080/login`
- Usuario demo: **admin**
- Password demo: **admin123**
- La sección protegida es `/books` (no entra sin login).
- Consola H2: `http://localhost:8080/h2` (JDBC URL: `jdbc:h2:mem:demo`)



## Estructura
- `model/` entidades `User`, `Book`
- `repository/` JPA repos
- `controller/` `AuthController`, `BookController`
- `security/` `SecurityConfig`, `CustomUserDetailsService`
- `config/` `DataLoader` con usuario y libros demo
- `templates/` Thymeleaf (`login.html`, `books/list.html`, `books/form.html`)


