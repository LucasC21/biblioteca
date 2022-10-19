package br.edu.ifms.biblioteca.dto;

import java.io.Serializable;

public class LivroDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idLivro;
	private String titulo;
	private int edicao;
	private int exemplares;
	
	public LivroDto() {
	
	}

	public LivroDto(int idLivro, String titulo, int edicao, int exemplares) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.edicao = edicao;
		this.exemplares = exemplares;
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
