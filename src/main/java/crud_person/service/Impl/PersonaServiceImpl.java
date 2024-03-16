package crud_person.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud_person.model.Persona;
import crud_person.repository.PersonaRepository;
import crud_person.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personRepository;

    @Override
    public List<Persona> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Persona getPeopleById(Long id) {
        // return personRepository.findById(id).orElse(null);
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found!"));

    }

    @Override
    public Persona createPerson(Persona person) {
        return personRepository.save(person);
    }

    @Override
    public Persona updatePerson(Long id, Persona persona) {
        Optional<Persona> existingPersona = personRepository.findById(id);
        if (existingPersona.isPresent()) {
            persona.setId(id);
            return personRepository.save(persona);
        } else {
            throw new RuntimeException("Person not found!");
        }
    }

    @Override
    public void deleteById(Long id) {

        personRepository.deleteById(id);

    }

    @Override
    public void delete(Persona person) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public List<Persona> findByNombre(String nombre) {
        throw new UnsupportedOperationException("Unimplemented method 'findByNombre'");
    }

}
