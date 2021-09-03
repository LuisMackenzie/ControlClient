package com.mackenzie.SpringData.service;

import com.mackenzie.SpringData.domain.Persona;

import java.util.List;

public interface PersonaService {

    public abstract List<Persona> getAllPersonas();

    public abstract void save(Persona persona);

    public abstract void delete(Persona persona);

    public abstract Persona findPersona(Persona persona);

}
