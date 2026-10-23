package com.example.cinelista.repository;

import com.example.cinelista.model.Pelicula;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Almacen en memoria de peliculas/series. No hay base de datos.
 */
@Component
public class PeliculaRepository {

    private final Map<Long, Pelicula> peliculas = new ConcurrentHashMap<>();
    private final AtomicLong idSequence = new AtomicLong();

    public Collection<Pelicula> findAll() {
        return peliculas.values().stream()
                .sorted(Comparator.comparing(Pelicula::getId))
                .toList();
    }

    public Optional<Pelicula> findById(Long id) {
        return Optional.ofNullable(peliculas.get(id));
    }

    public Pelicula save(Pelicula pelicula) {
        long id = idSequence.incrementAndGet();
        pelicula.setId(id);
        peliculas.put(id, pelicula);
        return pelicula;
    }

    public boolean deleteById(Long id) {
        return peliculas.remove(id) != null;
    }
}