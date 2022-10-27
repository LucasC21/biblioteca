package br.edu.ifms.biblioteca.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.biblioteca.dto.AlunoDto;
import br.edu.ifms.biblioteca.model.Aluno;
import br.edu.ifms.biblioteca.service.AlunoService;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource {

	@Autowired
	private AlunoService alunoServ;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AlunoDto objDto) {
		Aluno obj= alunoServ.fromDto(objDto);
		obj= alunoServ.insert(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> find(@PathVariable Integer id) {
		Aluno obj= alunoServ.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AlunoDto objDto, @PathVariable Integer id) {
		Aluno obj= alunoServ.fromDto(objDto);
		obj.setId(id);
		obj= alunoServ.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
		alunoServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Aluno obj, @PathVariable Integer id) {
		alunoServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AlunoDto>> findAll() {
		List<Aluno> list= alunoServ.findAll();
		List<AlunoDto> listDto= list.stream().map(obj->new AlunoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
