package com.mackenzie.SpringData.service;

import com.mackenzie.SpringData.dao.PersonaDao;
import com.mackenzie.SpringData.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> getAllPersonas() {
        return (List<Persona>) dao.findAll();
    }

    @Override
    @Transactional
    public void save(Persona persona) {
        dao.save(persona);
    }

    @Override
    @Transactional
    public void delete(Persona persona) {
        dao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findPersona(Persona persona) {
        return dao.findById(persona.getIdPersona()).orElse(null);
    }
}
