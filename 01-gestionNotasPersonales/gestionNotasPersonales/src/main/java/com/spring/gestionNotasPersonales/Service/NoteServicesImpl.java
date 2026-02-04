package com.spring.gestionNotasPersonales.Service;

import com.spring.gestionNotasPersonales.Entity.Note;
import com.spring.gestionNotasPersonales.Repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServicesImpl implements NoteServices {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Optional<Note> findNoteById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note note, Long id) {
        Note noteExisting = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada"));
        noteExisting.setTitle(note.getTitle());
        noteExisting.setContent(note.getContent());
        noteExisting.setCreatedAt(note.getCreatedAt());
        return noteRepository.save(noteExisting);
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada"));

        noteRepository.deleteById(id);
    }

}
