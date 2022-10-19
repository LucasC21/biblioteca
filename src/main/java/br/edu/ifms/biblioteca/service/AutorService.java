package br.edu.ifms.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.biblioteca.dto.AutorDto;
import br.edu.ifms.biblioteca.model.Autor;
import br.edu.ifms.biblioteca.repository.AutorRepository;
import br.edu.ifms.biblioteca.service.exception.DataIntegrityException;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepo;
	
	public Autor buscarPorId(Integer id) {
		Optional<Autor> obj = autorRepo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Autor.class.getName(), null));		
	}
	
	public Autor insert (Autor obj) {
		obj.setIdAutor(0);
		return autorRepo.save(obj);
	}
	
	public Autor update(Autor obj) {
		Autor newObj = buscarPorId(obj.getIdAutor());
		updateData(newObj, obj);
		return autorRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		buscarPorId(id);
		try {
			autorRepo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir!");
		}
	}

	public List<Autor> findAll() {
		return autorRepo.findAll();
	}
	
	public Autor fromDto(AutorDto objDto) {
		return new Autor(objDto.getIdAutor(), objDto.getNome());
	}
	
	private void updateData(Autor newObj, Autor obj) {
		newObj.setNome(obj.getNome());
	}
}
