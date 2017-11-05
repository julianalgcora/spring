package com.example.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mvc.entity.Book;
import com.example.mvc.repository.BookRepository;

@Controller
@RequestMapping("/")
public class BookController {
	
	private BookRepository livroRepository;

	@Autowired
	public BookController(BookRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@RequestMapping(value = "/{autor}", method = RequestMethod.GET)
	public String listaLivros(@PathVariable("autor") String autor, Model model) {
		List<Book> listaLivros = livroRepository.findByAutor(autor);
		if (listaLivros != null) {
			model.addAttribute("livros", listaLivros);
		}
		return "listBooks";
	}

	@RequestMapping(value = "/{autor}", method = RequestMethod.POST)
	public String adicionaLivroAutor(@PathVariable("autor") String autor, Book livro) {
		livro.setAutor(autor);
		livroRepository.save(livro);
		return "redirect:/{autor}";
	}
}
