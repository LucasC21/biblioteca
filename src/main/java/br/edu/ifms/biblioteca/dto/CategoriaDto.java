package br.edu.ifms.biblioteca.dto;

import java.io.Serializable;

public class CategoriaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idCategoria;
	private String nome;
	
	public CategoriaDto() {
		
	}

	public CategoriaDto(int idCategoria, String nome) {
		super();
		this.idCategoria = idCategoria;
		this.nome = nome;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
