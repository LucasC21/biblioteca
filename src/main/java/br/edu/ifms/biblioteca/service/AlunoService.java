package br.edu.ifms.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.biblioteca.dto.AlunoDto;
import br.edu.ifms.biblioteca.model.Aluno;
import br.edu.ifms.biblioteca.repository.AlunoRepository;
import br.edu.ifms.biblioteca.service.exception.DataIntegrityException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepo;
	
	public Aluno buscarPorId(Integer id) {
		Optional<Aluno> obj= alunoRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName(), null));
	}
	
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return alunoRepo.save(obj);
	}
	
	public Aluno update(Aluno obj) {
		Aluno newObj= buscarPorId(obj.getId());
		updateData(newObj, obj);
		return alunoRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		buscarPorId(id);
		try {
			alunoRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir!");
		}
	}
	
	public List<Aluno> findAll() {
		return alunoRepo.findAll();
	}
	
	public Aluno fromDto(AlunoDto objDto) {
		return new Aluno(objDto.getId(), objDto.getMaricula(), objDto.getNome(), objDto.getTurma(), objDto.getDisciplina());
	}
	
	private void updateData(Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
		newObj.setMaricula(obj.getMaricula());
		newObj.setTurma(obj.getTurma());
		newObj.setDisciplina(obj.getDisciplina());
	}
}
