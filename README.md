## Angular 12 Frontend with SpringBoot (Java) Backend
- Java 11
- Maven 3.3.9+
- Node 10+,  
- Angular-cli 12

## In Memory DB (H2)

### Run Frontend
```bash
# Navigate to frontend (should contain package.json )
npm install
# run the project
ng server --open
```

### Run Spring Boot using Maven
```bash
# Navigate to backend
mvn spring-boot:run
```

### GET BY SIGLAS BACKEND
http://localhost:8080/agente/sigla/{sigla}
