# Catálogo Papelería

Aplicación web CRUD para administrar los productos de un catálogo de papelería. Proyecto Integrador (PIF) — Politécnico Grancolombiano.

## Integrantes

| Nombre | Correo |
|---|---|
| Angela Estupiñan Sanchez | aestupinansanchez@poligran.edu.co |
| David Robeiro Alvarez Cruz | droalvarez@poligran.edu.co |
| Julian Larrarte Leguizamo | jlarrarte@poligran.edu.co |

## Tecnologías

- Java 21, Spring Boot 3, Maven
- Spring Data JPA / Hibernate (ORM) + MySQL 8.4
- Thymeleaf (interfaz web)
- Swagger UI (springdoc-openapi)
- Docker / Docker Compose
- Postman (pruebas de la API)
- SonarQube (calidad del código)
- GitHub (control de versiones)

## Arquitectura en capas

```
Navegador / Swagger / Postman
        │  HTTP/JSON
        ▼
controlador  →  servicio  →  repositorio  →  MySQL
(presentación)  (negocio)    (acceso a datos, JPA)
                    │
                  modelo (entidad Producto)
```

| Paquete | Capa | Responsabilidad |
|---|---|---|
| `controlador` | Presentación | Recibe las solicitudes HTTP y expone la API REST |
| `servicio` | Negocio | Aplica las reglas de negocio y coordina las operaciones CRUD |
| `repositorio` | Acceso a datos | Persistencia con Spring Data JPA |
| `modelo` | Dominio | Entidad `Producto` |
| `excepcion` | Transversal | Manejo de errores y respuestas HTTP |

Los diagramas de clases y de arquitectura están en [`docs/diagramas`](docs/diagramas).

## Estructura del proyecto

```
catalogo-papeleria/
├── compose.yaml
├── .env.example
├── pom.xml
├── docs/
│   ├── diagramas/
│   └── postman/
└── src/
    ├── main/java/co/edu/poli/papeleria/
    │   ├── CatalogoPapeleriaApplication.java
    │   ├── controlador/
    │   ├── servicio/
    │   ├── repositorio/
    │   ├── modelo/
    │   └── excepcion/
    ├── main/resources/
    │   ├── application.properties
    │   ├── templates/
    │   └── static/
    └── test/
```

## Cómo ejecutar

1. Copiar `.env.example` como `.env` y definir las contraseñas.
2. Levantar MySQL:

   ```bash
   docker compose up -d
   ```

3. Definir la variable `MYSQL_PASSWORD` (la misma del `.env`) y ejecutar la aplicación:

   ```bash
   mvn spring-boot:run
   ```

4. Abrir Swagger UI: http://localhost:8080/swagger-ui/index.html

## Endpoints

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/productos` | Listar productos |
| GET | `/api/productos/{id}` | Consultar un producto |
| POST | `/api/productos` | Registrar un producto |
| PUT | `/api/productos/{id}` | Actualizar un producto |
| DELETE | `/api/productos/{id}` | Eliminar un producto |

## SonarQube

```bash
docker compose --profile calidad up -d sonarqube
```

```bash
mvn clean verify sonar:sonar -Dsonar.projectKey=catalogo-papeleria -Dsonar.host.url=http://localhost:9000 -Dsonar.token=TU_TOKEN
```
