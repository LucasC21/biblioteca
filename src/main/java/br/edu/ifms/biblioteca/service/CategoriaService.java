package br.edu.ifms.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.biblioteca.model.Categoria;
import br.edu.ifms.biblioteca.repository.CategoriaRepository;
import br.edu.ifms.biblioteca.service.exception.DataIntegrityException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> obj = categoriaRepo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName(), null));		
	}
	
	public Categoria insert (Categoria obj) {
		obj.setIdCategoria(0);
		return categoriaRepo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		Categoria newObj = buscarPorId(obj.getIdCategoria());
		updateData(newObj, obj);
		return categoriaRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		buscarPorId(id);
		try {
			categoriaRepo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir!");
		}
	}
	
	public List<Categoria> findAll() {
		return categoriaRepo.findAll();
	}
	
	public Categoria fromDto(Categoria objDto) {
		return new Categoria(objDto.getIdCategoria(), objDto.getNome());
	}
	
	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
}
