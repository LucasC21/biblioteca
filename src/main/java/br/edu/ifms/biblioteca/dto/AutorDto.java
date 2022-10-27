package br.edu.ifms.biblioteca.dto;

import java.io.Serializable;

import br.edu.ifms.biblioteca.model.Autor;

public class AutorDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idAutor;
	private String nome;
	
	public AutorDto() {
		
	}

	public AutorDto(Autor obj) {
		super();
		this.idAutor = obj.getIdAutor();
		this.nome = obj.getNome();
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
