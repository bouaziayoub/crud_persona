package crud_person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud_person.service.PersonaService;

import java.util.List;
import crud_person.model.Persona;

@RestController
@RequestMapping("/people")
public class PersonaController {

    @Autowired
    private PersonaService personService;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @GetMapping("/all")
    public List<Persona> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("id/{id}")
    public Persona getPersonById(@PathVariable Long id) {
        return personService.getPeopleById(id);
    }

    @PostMapping("/create")
    public Persona createPerson(@RequestBody Persona person) {
        return personService.createPerson(person);
    }

    @PutMapping("update/{id}")
    public Persona updatePerson(@PathVariable Long id, @RequestBody Persona persona) {
        return personService.updatePerson(id, persona);
    }

     @DeleteMapping("delete/{id}")
     public void deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
    }
}
