package com.spring.gestionNotasPersonales.Service;

import com.spring.gestionNotasPersonales.Entity.Note;

import java.util.List;
import java.util.Optional;

public interface NoteServices {
    List<Note> findAllNotes();
    Optional<Note> findNoteById(Long id);
    Note saveNote(Note note);
    Note updateNote(Note note, Long id);
    void  deleteNote(Long id);
}
