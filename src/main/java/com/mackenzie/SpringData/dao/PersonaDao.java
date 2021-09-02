package com.mackenzie.SpringData.dao;

import com.mackenzie.SpringData.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long> {

}
