package br.edu.ifms.biblioteca.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idAutor;
	private String nome;
	
	public Autor() {
		
	}

	public Autor(int idAutor, String nome) {
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

	@Override
	public int hashCode() {
		return Objects.hash(idAutor, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return idAutor == other.idAutor && Objects.equals(nome, other.nome);
	}
	
	
}
