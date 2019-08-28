package swrdism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import swrdism.Classmate;
import swrdism.QueryParameter;
import swrdism.service.ClassmateService;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/classmate")

public class ClassmateController {

    @Autowired
    private ClassmateService classmateService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Classmate> getClassmate(@PathVariable("id") int id) {
        Classmate classmate = classmateService.getClassmate(id);
        return ResponseEntity.ok(classmate);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Classmate>> getClassmates(@ModelAttribute QueryParameter param) {
        List<Classmate> classmates = classmateService.getClassmates(param);
        return ResponseEntity.ok(classmates);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Classmate> createClassmates(@RequestBody Classmate request) {
        Classmate classmate = classmateService.createClassmate(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(classmate.getNumber())
                .toUri();
        return ResponseEntity.created(location).body(classmate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Classmate> replaceClassmate(@PathVariable("id") int id, @RequestBody Classmate request) {
        Classmate classmate = classmateService.replaceClassmate(id, request);
        return ResponseEntity.ok(classmate);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteClassmate(@PathVariable("id") int id) {
        classmateService.deleteClassmate(id);
        return ResponseEntity.noContent().build();
    }
}





