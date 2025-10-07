package com.example.mvccrudlogin.controller;

import com.example.mvccrudlogin.model.Book;
import com.example.mvccrudlogin.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookRepository repo;
    public BookController(BookRepository repo) { this.repo = repo; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", repo.findAll());
        return "books/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute Book book, BindingResult br) {
        if (br.hasErrors()) return "books/form";
        repo.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Book b = repo.findById(id).orElseThrow();
        model.addAttribute("book", b);
        return "books/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute Book book, BindingResult br) {
        if (br.hasErrors()) return "books/form";
        book.setId(id);
        repo.save(book);
        return "redirect:/books";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/books";
    }
}
