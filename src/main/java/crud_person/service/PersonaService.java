package crud_person.service;

import java.util.List;

import crud_person.model.Persona;

public interface PersonaService {

    public List<Persona> getAllPeople();

    public Persona getPeopleById(Long id);

    public Persona createPerson(Persona person);

    public Persona updatePerson(Long id, Persona person);

    public void deleteById(Long id);

    public void delete(Persona person);

    public void deleteAll();

    public long count();

    public List<Persona> findByNombre(String nombre);

}
