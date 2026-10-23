package com.example.cinelista.controller;

import com.example.cinelista.repository.PeliculaRepository;
import com.example.cinelista.model.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PeliculaController {

    private final PeliculaRepository peliculaRepository;

    public PeliculaController(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/mi-lista";
    }

    @GetMapping("/mi-lista")
    public String miLista(Model model) {
        model.addAttribute("peliculas", peliculaRepository.findAll());
        model.addAttribute("activa", "mi-lista");
        return "mi-lista";
    }

    @GetMapping("/anadir-titulo")
    public String formularioAnadir(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("activa", "anadir-titulo");
        return "anadir-titulo";
    }

    @PostMapping("/anadir-titulo")
    public String guardar(@ModelAttribute Pelicula pelicula) {
        int v = pelicula.getValoracion() == null ? 0 : pelicula.getValoracion();
        pelicula.setValoracion(Math.max(0, Math.min(5, v)));
        peliculaRepository.save(pelicula);
        return "redirect:/mi-lista";
    }

    @PostMapping("/mi-lista/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        peliculaRepository.deleteById(id);
        return "redirect:/mi-lista";
    }
}