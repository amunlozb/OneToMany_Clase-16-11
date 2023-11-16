package com.onetomany.service;

import com.onetomany.model.Autor;
import com.onetomany.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }
}
