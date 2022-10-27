package br.edu.ifms.biblioteca.dto;

import java.io.Serializable;

import br.edu.ifms.biblioteca.model.Livro;

public class LivroDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idLivro;
	private String titulo;
	private int edicao;
	private int exemplares;
	
	public LivroDto() {
	
	}

	public LivroDto(Livro obj) {
		super();
		this.idLivro = obj.getIdLivro();
		this.titulo = obj.getTitulo();
		this.edicao = obj.getEdicao();
		this.exemplares = obj.getExemplares();
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
	
}
