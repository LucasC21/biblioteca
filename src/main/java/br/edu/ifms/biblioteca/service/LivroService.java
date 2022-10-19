package br.edu.ifms.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.biblioteca.model.Livro;
import br.edu.ifms.biblioteca.repository.LivroRepository;
import br.edu.ifms.biblioteca.service.exception.DataIntegrityException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepo;
	
	public Livro buscarPorId(Integer id) {
		Optional<Livro> obj = livroRepo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName(), null));
	}
	
	public Livro insert(Livro obj) {
		obj.setIdLivro(0);
		return livroRepo.save(obj);
	}
	
	public Livro update(Livro obj) {
		Livro newObj = buscarPorId(obj.getIdLivro());
		updateData(newObj, obj);
		return livroRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		buscarPorId(id);
		try {
			livroRepo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir!");
		}
	}
	
	public List<Livro> findAll() {
		return livroRepo.findAll();
	}
	
	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setEdicao(obj.getEdicao());
		newObj.setExemplares(obj.getExemplares());
	} 
}
