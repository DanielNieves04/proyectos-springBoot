package com.spring.gestionNotasPersonales.Controller;

import com.spring.gestionNotasPersonales.Entity.Note;
import com.spring.gestionNotasPersonales.Service.NoteServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class NoteController {

    @Autowired
    private NoteServices noteServices;

    @GetMapping("/getNotes")
    public List<Note> getNotes(){
        return noteServices.findAllNotes();
    }

    @GetMapping("/getNoteById/{id}")
    public Optional<Note> getNoteById(@PathVariable Long id){
        return noteServices.findNoteById(id);
    }

    @PostMapping("/saveNote")
    @ResponseStatus(HttpStatus.CREATED)
    public Note saveNote(@Valid @RequestBody Note note){
        return noteServices.saveNote(note);
    }

    @PutMapping("/updateNote/{id}")
    public Note updateNote(@Valid @RequestBody Note note,@PathVariable Long id)
    {
        return noteServices.updateNote(note,id);
    }

    @DeleteMapping("/deleteNote/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteNote(@PathVariable Long id){
        noteServices.deleteNote(id);
        return "Nota eliminada";
    }

}
