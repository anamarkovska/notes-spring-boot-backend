package com.springdemo.springbootnote.controller;

import com.springdemo.springbootnote.model.Note;
import com.springdemo.springbootnote.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NotesController {
    @Autowired
    NotesRepository notesRepository;

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAll(){
        return new ResponseEntity<List<Note>>(notesRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<Note>(notesRepository.save(note), HttpStatus.CREATED);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> readNote(@PathVariable Long id){
        return new ResponseEntity<Note>(notesRepository.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id){
        notesRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/notes")
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<Note>(notesRepository.save(note), HttpStatus.OK);
    }
}
