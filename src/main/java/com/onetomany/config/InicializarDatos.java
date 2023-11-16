package com.onetomany.config;

import com.github.javafaker.Faker;
import com.onetomany.model.Autor;
import com.onetomany.model.Libro;
import com.onetomany.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InicializarDatos implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        List<Autor> autores = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Autor autor = new Autor();

            autor.setNombre(faker.name().fullName());
            autores.add(autor);

            int numLibros = faker.number().numberBetween(1, 6);
            for (int j = 0; j < numLibros; j++) {
                Libro libro = new Libro();
                libro.setTitulo(faker.book().title());
                libro.setAutor(autor);

                autor.getLibros().add(libro);
            }
        }
        autorRepository.saveAll(autores);
    }
}
