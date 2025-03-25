# Cliente API

## Descripción

Esta es una API REST Spring Boot para gestionar los datos de los clientes.

## Tecnología utilizada

* Spring Boot
* Spring Data JPA
* MySQL
* Maven

## Prerrequisitos

* Java 17 or higher
* Maven
* MySQL database

## Setup

1.  Clona el repositorio:

    ```bash
    git clone <la_url_de_tu_repositorio>
    ```

2.  Navega al directorio donde está el proyecto (antes crea la carpeta):

    ```bash
    cd cliente-api
    ```

3.  Configura la conección a la base de datos en `application.properties`.

4.  Construye el proyecto:

    ```bash
    ./mvnw clean install
    ```

5.  Corre la aplicación:

    ```bash
    ./mvnw spring-boot:run
    ```

## Endpoints

* `GET /clientes`: Obtener todos los clients.
* `GET /clientes/{id}`: Obtener un cliente por su ID.
* `POST /clientes`: Crear un cliente nuevo.
* `PUT /clientes/{id}`: Actualizar un cliente existente.
* `DELETE /clientes/{id}`: Borrar un client.

## Setup de la base de datos

1. Si aún no tienes intalado MySQL instalalo [desde este enlace](https://dev.mysql.com/downloads/)
2. Una vez intalado, ingresa a MySQL con tu contraseña y tu usuario desde la terminal usando el siguiente comando:

    ```bash
    mysql -u root -p
    ```

3. Usando la terminal crea la base de datos;

    ```bash
    CREATE DATABASE cliente_db;
    ```

3. Configura las environment variables, crea el archivo .env en la tu directorio raiz con la siguiente información:

     ```bash
    DB_URL=jdbc:mysql://localhost:3306/cliente_db
    DB_USER=root
    DB_PASS=tu_contraseña
    ```

Reemplaza "tu_contraseña" con la contraseña real de tu usuario en MySQL y si tu usuario es diferente a "root" entonces actualizalo

4. Carga las environmet variables usando el siguiente comando:

    ```bash
    export $(grep -v '^#' .env | xargs)
    ```

5. Verifica la conección con la base de datos
    
    ```bash
    ./mvnw spring-boot:run
    ```

## Running Tests

* Explain how to run the unit and integration tests.

Corre las pruebas para verificar que todo estña bien. Solo usa el siguiente comando en tu terminal.

    ```bash
    ./mvnw test
    ```