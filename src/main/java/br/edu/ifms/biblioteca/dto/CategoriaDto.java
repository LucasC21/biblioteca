package br.edu.ifms.biblioteca.dto;

import java.io.Serializable;

import br.edu.ifms.biblioteca.model.Categoria;

public class CategoriaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idCategoria;
	private String nome;
	
	public CategoriaDto() {
		
	}

	public CategoriaDto(Categoria obj) {
		super();
		this.idCategoria = obj.getIdCategoria();
		this.nome = obj.getNome();
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
