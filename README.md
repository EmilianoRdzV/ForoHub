# ForoHub - Creación y manipulación de tópicos

ForoHub es una plataforma diseñada para crear, gestionar y participar en foros de temas educativos. El proyecto implementa el registro de usuarios, tópicos y respuestas, así como la manipulación de dichos datos. La información se almacena en una base de datos MySQL y se puede acceder a ella mediante plataformas como Postman.

---

## **Contenido**
1. [Capacidades](#capacidades)
2. [Estructura del Sistema](#estructura)
3. [Tecnologías](#tecnologías)
4. [Configuración e Instalación](#configuración-e-instalación)
5. [Endpoints](#endpoints-principales)
6. [Dependencias](#dependencias)
7. [Autor](#autor)

---

## **Capacidades**
- **Gestión de Usuarios**: Autenticación y autorización con JWT.
- **Gestión de Foros**: Creación y visualización de temas y respuestas.
- **Gestión de Cursos**: Asociación de cursos con tópicos y categorías.
- **Documentación de la API**: Generada con Swagger.
- **Seguridad**: Implementación de roles y permisos con Spring Security.

---

## **Estructura**
El proyecto está diseñado con una arquitectura por capas:
- **Capa API**: Contiene los controladores REST y configuraciones de seguridad.
- **Capa de Dominio**: Define las entidades, repositorios y DTOs.
- **Capa de Infraestructura**: Incluye configuración de base de datos, manejo de errores y documentación de API.

---

## **Tecnologías**
- **Lenguaje**: Java 17
- **Framework Principal**: Spring Boot
- **Seguridad**: Spring Security, JWT
- **Acceso a Datos**: Spring Data JPA, Hibernate
- **Base de Datos**: MySQL
- **Documentación**: SpringDoc OpenAPI (Swagger)

---

## **Configuración e Instalación**

### **Prerrequisitos**
- JDK 17
- Maven 3.8+
- MySQL Workbench 8.0+

### **Pasos**
1. Clonar el repositorio:
   ```bash
    https://github.com/EmilianoRdzV/ForoHub.git
   cd ForoHub
   
| Método | Endpoint         | Descripción                        |
|--------|------------------|------------------------------------|
| POST   | `/login`          | Loguear un usuario.                |
| GET    | `/usuarios`       | Obtener lista de usuarios.         |
| GET    | `/topicos`        | Listar todos los tópicos.           |
| POST   | `/topicos`        | Crear un nuevo tópico.              |
| GET    | `/cursos`         | Listar todos los cursos.            |
| POST   | `/respuestas`     | Publicar una respuesta en un tópico.|
| DELETE | `/usuarios`       | Desactiva a un usuario.             |
| PUT    | `/respuestas/id`  | Actualiza una respuesta.            |

