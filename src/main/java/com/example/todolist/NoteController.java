package com.example.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {

    // Перенаправлення на сторінку списку нотаток
    @GetMapping("/list")
    public String getNoteList(Model model) {

        return "note_list"; // Повертає ім'я шаблону HTML для відображення
    }

    // Обробка запиту на видалення нотатки
    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id) {

        return "redirect:/note/list"; // Перенаправлення на сторінку списку нотаток
    }

    // Перенаправлення на сторінку редагування нотатки
    @GetMapping("/edit")
    public String getEditNotePage(@RequestParam Long id, Model model) {

        return "note_edit"; // Повертає ім'я шаблону HTML для відображення
    }

    // Обробка запиту на редагування нотатки
    @PostMapping("/edit")
    public String editNote(@RequestParam Long id, @RequestParam String title, @RequestParam String content) {

        return "redirect:/note/list"; // Перенаправлення на сторінку списку нотаток після редагування
    }
}
