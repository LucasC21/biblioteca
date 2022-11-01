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

import br.edu.ifms.biblioteca.dto.CategoriaDto;
import br.edu.ifms.biblioteca.model.Categoria;
import br.edu.ifms.biblioteca.service.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

	
	
	
	@Autowired
	private CategoriaService categoriaServ;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDto objDto) {
		Categoria obj= categoriaServ.fromDto(objDto);
		obj= categoriaServ.insert(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCategoria()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria obj= categoriaServ.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDto objDto, @PathVariable Integer id) {
		Categoria obj= categoriaServ.fromDto(objDto);
		obj.setIdCategoria(id);
		obj= categoriaServ.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
		categoriaServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Categoria obj, @PathVariable Integer id) {
		categoriaServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDto>> findAll() {
		List<Categoria> list= categoriaServ.findAll();
		List<CategoriaDto> listDto= list.stream().map(obj->new CategoriaDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
