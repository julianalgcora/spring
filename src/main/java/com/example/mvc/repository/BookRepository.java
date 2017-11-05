package com.example.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	/**
	 * Encontra todos os livros de um mesmo autor.
	 * 
	 * @param autor
	 * @return lista de livros
	 */
	List<Book> findByAutor(String autor);

	/**
	 * Encontra um livro a partir do seu título. Retorna uma lista pois podem
	 * existir mais de um livro com mesmo título.
	 * 
	 * @param titulo
	 * @return lista de livros
	 */
	List<Book> findByTitulo(String titulo);

	/**
	 * Encontra um livro a partir de seu isbn, como o isbn é único, apenas um
	 * livro pode ser encontrado.
	 * 
	 * @param isbn
	 * @return livro
	 */
	Book findByIsbn(String isbn);
}
