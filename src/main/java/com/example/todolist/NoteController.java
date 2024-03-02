package com.example.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {

    @GetMapping("/note/list")
    public String listNotes(Model model) {

        return "list";
    }

    @GetMapping("/note/edit")
    public String editNoteForm() {
        return "edit";
    }

}
