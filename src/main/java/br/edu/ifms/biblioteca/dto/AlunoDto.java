package br.edu.ifms.biblioteca.dto;

import java.io.Serializable;

public class AlunoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private int maricula;
	private String nome;
	private int turma;
	private String disciplina;
	
	public AlunoDto() {
	
	}

	public AlunoDto(Integer id, int maricula, String nome, int turma, String disciplina) {
		super();
		this.id = id;
		this.maricula = maricula;
		this.nome = nome;
		this.turma = turma;
		this.disciplina = disciplina;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getMaricula() {
		return maricula;
	}

	public void setMaricula(int maricula) {
		this.maricula = maricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTurma() {
		return turma;
	}

	public void setTurma(int turma) {
		this.turma = turma;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

}
