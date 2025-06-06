# Job Management System (Gestão de Vagas)

The **Job Management System** is a backend application built with Java and Spring Boot, designed to manage job postings and candidate applications in a streamlined and scalable way.

## 🚀 Technologies Used

* Java 17
* Spring Boot
* Maven
* Docker
* PostgreSQL
* GitHub Actions (CI/CD)
* OpenAPI (Swagger) for API documentation

## 📁 Project Structure

```
.
├── src/                   # Application source code
├── Dockerfile             # Docker image configuration
├── docker-compose.yml     # (optional) Local development setup
├── pom.xml                # Maven build configuration
└── .github/workflows/     # GitHub Actions CI/CD pipeline
```

## ⚙️ How to Run

### Prerequisites

* Java 17
* Docker and Docker Compose
* A running PostgreSQL instance

### Build and Run Locally

1. **Clone the repository**:

   ```bash
   git clone https://github.com/icaro-milet/gestao_vagas.git
   cd gestao_vagas
   ```

2. **Build the project with Maven**:

   ```bash
   ./mvnw clean install
   ```

3. **Run using Docker**:

   ```bash
   docker run -d -p 8080:8080 \
     -e DATABASE_URL=jdbc:postgresql://<host>:5432/<db>?user=<user>&password=<pass> \
     --name gestao-vagas \
     icaromilet/gestao_vagas
   ```

4. Access the application at:

   ```
   http://localhost:8080
   ```

## 📘 API Documentation (Swagger / OpenAPI)

Once the application is running, the OpenAPI documentation is available at:

```
http://localhost:8080/swagger-ui/index.html
```

This interface provides:

* A full list of available endpoints
* Input/output schemas
* Example requests and responses
* Ability to test endpoints directly from the browser

> The Swagger UI is generated using [springdoc-openapi](https://springdoc.org/).

## 🧪 Running Tests

To run tests:

```bash
./mvnw test
```

## 🚀 CI/CD Pipeline

This project uses **GitHub Actions** for:

* Compiling and testing with Maven
* Building and publishing Docker images
* Deploying to an EC2 instance using a self-hosted runner

## 📄 License

This project is licensed under \[add your license here].

## 👨‍💻 Author

Developed by [Ícaro Milet](https://github.com/icaro-milet)