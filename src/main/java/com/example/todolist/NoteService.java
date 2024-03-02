package com.example.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        Optional<Note> existingNote = noteRepository.findById(note.getId());
        if (existingNote.isPresent()) {
            Note updatedNote = existingNote.get();
            updatedNote.setTitle(note.getTitle());
            updatedNote.setContent(note.getContent());
            noteRepository.save(updatedNote);
        } else {
            throw new IllegalArgumentException("Note with id " + note.getId() + " not found");
        }
    }

    public Note getById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));
    }
}
