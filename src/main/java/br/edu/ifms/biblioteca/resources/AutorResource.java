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

import br.edu.ifms.biblioteca.dto.AutorDto;
import br.edu.ifms.biblioteca.model.Autor;
import br.edu.ifms.biblioteca.service.AutorService;

@RestController
@RequestMapping(value = "/autor")
public class AutorResource {

	@Autowired
	private AutorService autorServ;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AutorDto objDto) {
		Autor obj= autorServ.fromDto(objDto);
		obj= autorServ.insert(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAutor()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Autor> find(@PathVariable Integer id) {
		Autor obj= autorServ.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AutorDto objDto, @PathVariable Integer id) {
		Autor obj= autorServ.fromDto(objDto);
		obj.setIdAutor(id);
		obj= autorServ.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
		autorServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Autor obj, @PathVariable Integer id) {
		autorServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AutorDto>> findAll() {
		List<Autor> list= autorServ.findAll();
		List<AutorDto> listDto= list.stream().map(obj->new AutorDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
