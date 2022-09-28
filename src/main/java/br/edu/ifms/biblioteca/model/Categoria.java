package br.edu.ifms.biblioteca.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Id;

public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idCategoria;
	private String nome;
	
	public Categoria() {
	
	}

	public Categoria(int idCategoria, String nome) {
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

	@Override
	public int hashCode() {
		return Objects.hash(idCategoria, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return idCategoria == other.idCategoria && Objects.equals(nome, other.nome);
	}
	
}
