# AREP-LAB5-CRUD

Sistema CRUD para la gestión de propiedades inmobiliarias. Permite crear, leer, actualizar y eliminar propiedades desde un frontend sencillo conectado a un backend Spring Boot, persistiendo datos en una base de datos MySQL en AWS RDS.

---

## Getting Started

Estas instrucciones te permitirán ejecutar una copia del proyecto para desarrollo y pruebas en tu máquina local o en servidores en AWS.

### Prerequisites

* Java 17
* Maven
* Docker
* MySQL (o acceso a AWS RDS)
* Navegador moderno (para el frontend HTML/JS)
* `curl` (opcional, para pruebas desde terminal)

---

### Installing

1. Clonar el repositorio:

```bash
git clone https://github.com/AlejandroPrieto82/AREP-LAB5-CRUD.git
cd AREP-LAB5-CRUD
````

2. Configurar la conexión a la base de datos en `src/main/resources/application.properties`:

```properties
spring.application.name=crud

spring.datasource.url=jdbc:mysql://arep-database-crud.cdq8y8kyck6j.us-east-1.rds.amazonaws.com:3306/propertiesdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=admin
spring.datasource.password=*****
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

3. Construir la imagen Docker del backend:

```bash
sudo docker build -t myapp:latest .
```

4. Ejecutar la aplicación en Docker:

```bash
sudo docker run --name myapp -p 8080:8080 myapp:latest
```

5. Descargar el frontend del repositorio y abrir `index.html` en un navegador para interactuar con la aplicación. Alternativamente, se pueden hacer pruebas con `curl`:

```bash
curl http://54.167.109.69:8080/api/properties
```

---

## Running the tests

Se pueden realizar pruebas manuales usando el frontend o `curl`. Por ejemplo:

**Crear una propiedad:**

```bash
curl -X POST http://54.167.109.69:8080/api/properties \
-H "Content-Type: application/json" \
-d '{"address":"Calle 123", "price":250000, "size":120, "description":"Casa de prueba"}'
```

**Obtener todas las propiedades:**

```bash
curl http://54.167.109.69:8080/api/properties
```

**Actualizar propiedad:**

```bash
curl -X PUT http://54.167.109.69:8080/api/properties/1 \
-H "Content-Type: application/json" \
-d '{"address":"Calle 123", "price":300000, "size":120, "description":"Casa actualizada"}'
```

**Eliminar propiedad:**

```bash
curl -X DELETE http://54.167.109.69:8080/api/properties/1
```

---

## Deployment

1. Subir backend a una instancia EC2 y exponer puerto 8080.
2. Asegurarse que el security group permita conexiones al puerto 8080 desde tu IP o desde cualquier origen (para pruebas).
3. Base de datos desplegada en AWS RDS (ya configurada en `application.properties`).
4. Frontend puede descargarse desde el repositorio y ejecutarse localmente en un navegador.

---

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Backend REST API
* [Hibernate / JPA](https://hibernate.org/) - Persistencia de datos
* [MySQL](https://www.mysql.com/) - Base de datos
* Docker - Contenerización del backend
* HTML + JavaScript - Frontend sencillo

---

## Evidence / Screenshots

![Base de datos creada](/img/image.png)
**Base de datos y tabla creada**

![Prueba crear propiedad](/img/image-1.png)
**Crear propiedad**

![Prueba ver propiedades](/img/image-2.png)
**Lista de propiedades**

![Ver propiedad por ID](/img/image-4.png)
**Detalle de propiedad**

![Actualizar propiedad](/img/image-3.png)
**Actualizar propiedad**

![Eliminar propiedad](/img/image-5.png)
**Eliminar propiedad**

![Formulario FrontEnd](/img/image-6.png)
**Formulario frontend**

![Conexión a RDS AWS](/img/image-7.png)
**Conexión a RDS**

![Imagen del backend en EC2](/img/image-8.png)
**Docker backend en EC2**

![Imagen ya corriendo en la instancia](/img/image-9.png)
**Aplicación corriendo**

![Servidor responde](/img/image-10.png)
**Endpoint responde correctamente**

[IP para ver propiedades](http://54.167.109.69:8080/api/properties)

---

## Authors

* **Alejandro Prieto** - *Initial work* - [AlejandroPrieto82](https://github.com/AlejandroPrieto82)

---

## License

Este proyecto está bajo la licencia MIT - ver el archivo [LICENSE.md](LICENSE.md)

---

## Video de demostración

[Ver video de funcionamiento](LINK_DEL_VIDEO_AQUI)

