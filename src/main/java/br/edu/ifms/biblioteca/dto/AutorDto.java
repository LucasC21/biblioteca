package br.edu.ifms.biblioteca.dto;

import java.io.Serializable;

public class AutorDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idAutor;
	private String nome;
	
	public AutorDto() {
		
	}

	public AutorDto(int idAutor, String nome) {
		super();
		this.idAutor = idAutor;
		this.nome = nome;
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
