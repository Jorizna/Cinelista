# CineLista

Aplicacion Spring Boot + Thymeleaf + Bootstrap para gestionar un catalogo personal de peliculas.

## Funcionalidades
* **Mi lista** (`/mi-lista`): tabla con titulo, genero, plataforma, estado, valoracion y boton Eliminar por pelicula.
* **Anadir titulo** (`/anadir-titulo`): formulario que guarda la pelicula y vuelve a Mi lista.
* **Eliminar** (`POST /mi-lista/eliminar/{id}`): borra la pelicula correspondiente.

Los datos se guardan en memoria (se pierden al reiniciar).

## Arrancar
```
./mvnw spring-boot:run
```
Abrir http://localhost:8080/ (redirige a `/mi-lista`).

## Estructura
```
src/main/java/com/example/cinelista/
├── CinelistaApplication.java
├── config/ServletInitializer.java
├── model/Pelicula.java
├── repository/PeliculaRepository.java
└── controller/PeliculaController.java

src/main/resources/
├── templates/ (mi-lista.html, anadir-titulo.html, fragments/nav.html, fragments/cabecera.html)
└── static/css/estilo.css
```
