# Tema 1 - Arquitectura desacoplada cliente-servidor con REST

## Objetivo

Este proyecto implementa una base de aplicación Java con arquitectura desacoplada orientada a servicios RESTful. La idea principal es separar claramente la capa de presentación, la lógica de negocio y la persistencia para permitir que distintos clientes puedan consumir la misma API sin depender entre sí.

## Arquitectura propuesta

La solución sigue un esquema cliente-servidor desacoplado en capas:

- Controller: gestiona las peticiones HTTP y responde con JSON.
- Business: encapsula la lógica de negocio y las reglas de la aplicación.
- Data: almacena y recupera los datos del sistema.

La comunicación se realiza mediante HTTP y JSON, evitando que el cliente conozca los detalles internos del backend.

## Justificación del desacoplamiento

El desacoplamiento de capas permite que cada componente evolucione de forma independiente:

- La capa Controller se encarga de recibir y responder a las peticiones HTTP.
- La capa Business encapsula la lógica de negocio.
- La capa Data gestiona el almacenamiento y acceso a la información.

Esto mejora la mantenibilidad, reutilización y escalabilidad del sistema. Un cambio en la lógica de negocio no obliga a reescribir toda la interfaz de usuario, y viceversa.

La API REST actúa como columna vertebral del sistema porque proporciona una interfaz común para múltiples tipos de clientes, como:

- una SPA Web desarrollada con React, Angular o Vue;
- una aplicación móvil nativa o híbrida;
- otros servicios internos o integraciones externas.

Todos ellos pueden consumir los mismos endpoints, reutilizando la misma lógica y garantizando coherencia entre experiencias digitales.

## Estructura del proyecto

```text
src/
├── main/
│   ├── java/
│   │   └── com/example/tema1/
│   │       ├── Tema1Application.java
│   │       ├── controller/
│   │       │   └── UserController.java
│   │       ├── business/
│   │       │   ├── UserBusinessService.java
│   │       │   └── UserBusinessServiceImpl.java
│   │       └── data/
│   │           ├── User.java
│   │           ├── UserDataRepository.java
│   │           └── InMemoryUserDataRepository.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
```

## Endpoints principales

- GET /api/users
- GET /api/users/{id}
- POST /api/users

## Cómo arrancar la aplicación

```bash
mvn spring-boot:run
```

## Beneficios del enfoque

- Separación de responsabilidades.
- Reutilización de la misma API por varios clientes.
- Facilita futuras evoluciones de frontend y móvil.
- Reduce acoplamiento entre tecnologías y equipos.
- Mejora la escalabilidad y la prueba del sistema.

## Conclusión

La API REST es la capa central que conecta los clientes con la lógica del negocio. Gracias a su diseño desacoplado, el backend puede servir tanto a una interfaz Web como a una aplicación móvil sin duplicar reglas ni depender de una tecnología concreta del cliente.
