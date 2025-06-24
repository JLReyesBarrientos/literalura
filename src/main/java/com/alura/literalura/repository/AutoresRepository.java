package com.alura.literalura.repository;

import com.alura.literalura.Modelo.Autor;
import com.alura.literalura.Modelo.Idioma;
import com.alura.literalura.Modelo.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutoresRepository  extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Libros l JOIN l.autor a WHERE a.nombre LIKE %:nombre%")
    Optional<Autor> buscarAutorPorNombre(@Param("nombre") String nombre);

    @Query("SELECT l FROM Libros l JOIN l.autor a WHERE l.titulo LIKE %:titulo%")
    Optional<Libros> buscarLibroPorNombre(@Param("titulo") String titulo);

    @Query("SELECT l FROM Autor a JOIN a.libros l ORDER BY l.titulo")
    List<Libros> librosRegistrados();

    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :fecha AND a.fechaDeMuerte > :fecha")
    List<Autor> listarAutoresVivos(@Param("fecha") Integer fecha);

    @Query("SELECT l FROM Autor a JOIN a.libros l WHERE l.idioma = :idioma")
    List<Libros> librosPorIdioma(@Param("idioma") Idioma idioma);

    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento = :nacimiento")
    List<Autor> listarAutorPorFechaNacimiento(Integer nacimiento);

    @Query("SELECT a FROM Autor a Where a.fechaDeMuerte = :muerte")
    List<Autor> listarAutorPorFechaDeMuerte(Integer muerte);
}
