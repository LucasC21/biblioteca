package br.edu.ifms.biblioteca.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.biblioteca.model.Aluno;
import br.edu.ifms.biblioteca.model.Autor;
import br.edu.ifms.biblioteca.model.Categoria;
import br.edu.ifms.biblioteca.model.Livro;
import br.edu.ifms.biblioteca.repository.AlunoRepository;
import br.edu.ifms.biblioteca.repository.AutorRepository;
import br.edu.ifms.biblioteca.repository.CategoriaRepository;
import br.edu.ifms.biblioteca.repository.LivroRepository;

@Service
public class DBService {

	@Autowired
	private AlunoRepository aluno;
	@Autowired
	private AutorRepository autor;
	@Autowired
	private CategoriaRepository categoria;
	@Autowired
	private LivroRepository livro;
	
	public void instantiateTestDataBase() throws ParseException {
		
		Aluno aluno1= new Aluno(null, 123, "João", 1111, "Matemática");
		Aluno aluno2= new Aluno(null, 345, "Renan", 2222, "Desenvolvimento web");
		Aluno aluno3= new Aluno(null, 567, "Maria", 3333, "Programação de computadores");
		Aluno aluno4= new Aluno(null, 789, "Marcos", 4444, "Empreendedorismo");
		
		Autor autor1= new Autor(1, "Chad Fowler");
		Autor autor2= new Autor(2, "Donald Miller");
		Autor autor3= new Autor(3, "Malba Tahan");
		Autor autor4= new Autor(4, "Semmy Purewal");
		
		Categoria categoria1= new Categoria(1, "Exatas");
		Categoria categoria2= new Categoria(2, "Finanças");
		Categoria categoria3= new Categoria(3, "Tecnologia da informação");
		Categoria categoria4= new Categoria(4, "Programação");
		
		Livro livro1= new Livro(1, "Storybrand: Crie mensagens claras e atraia a atenção dos clientes para sua marca", 2, 10, aluno4, categoria2);
		Livro livro2= new Livro(2, "O homem que calculava", 3, 15, aluno1, categoria1);
		Livro livro3= new Livro(3, "O Programador Apaixonado: Construindo uma carreira notável em desenvolvimento de software", 4, 25, aluno3, categoria3);
		Livro livro4= new Livro(4, "Aprendendo a Desenvolver Aplicações Web: Desenvolva Rapidamente com as Tecnologias JavaScript Mais Modernas", 5, 40, aluno2, categoria4);
		
		aluno.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));
		autor.saveAll(Arrays.asList(autor1, autor2, autor3, autor4));
		categoria.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4));
		livro.saveAll(Arrays.asList(livro1, livro2, livro3, livro4));
	}
}
