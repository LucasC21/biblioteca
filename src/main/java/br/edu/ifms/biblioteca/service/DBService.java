package br.edu.ifms.biblioteca.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.biblioteca.repository.AlunoRepository;
import br.edu.ifms.biblioteca.repository.CategoriaRepository;
import br.edu.ifms.biblioteca.repository.LivroRepository;

@Service
public class DBService {

	@Autowired
	private AlunoRepository alunoRepo;
	@Autowired
	private AutorService autorRepo;
	@Autowired
	private CategoriaRepository categoriaRepo;
	@Autowired
	private LivroRepository livroRepo;
	
	public void instantiateTestDataBase() throws ParseException {
		
	}
}
