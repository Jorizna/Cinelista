package com.example.cinelista.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadisticasController {

    @GetMapping(value = "/api/estadisticas", produces = "application/json")
    public String estadisticas() {
        return """
        {
          "data": [
            { "titulo": "Oldboy", "genero": "Acción", "taquilla": 585, "valoracion": 4 },
            { "titulo": "Persona", "genero": "Surrealismo", "taquilla": 2264, "valoracion": 5 },
            { "titulo": "Martin (Hache)", "genero": "Drama", "taquilla": 2923, "valoracion": 4 },
            { "titulo": "Tesis", "genero": "Thriller", "taquilla": 968, "valoracion": 4 },
            { "titulo": "REC", "genero": "Terror", "taquilla": 1074, "valoracion": 3 }
          ]
        }
        """;
    }
}
