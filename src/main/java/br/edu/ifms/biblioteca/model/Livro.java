package br.edu.ifms.biblioteca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLivro;
	private String titulo;
	private int edicao;
	private int exemplares;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idAluno")
	private Aluno aluno;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="Autor_Livro",
			joinColumns = @JoinColumn(name="idLivro"),
			inverseJoinColumns = @JoinColumn(name="idAutor"))
	private List<Autor> autores = new ArrayList<Autor>();
	
	public Livro() {
		
	}
	
	public Livro(int idLivro, String titulo, int edicao, int exemplares, Aluno aluno, Categoria categoria) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.edicao = edicao;
		this.exemplares = exemplares;
		this.aluno = aluno;
		this.categoria = categoria;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getExemplares() {
		return exemplares;
	}

	public void setExemplares(int exemplares) {
		this.exemplares = exemplares;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLivro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return idLivro == other.idLivro;
	}

}
