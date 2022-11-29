package br.edu.ifms.biblioteca.dto;

import java.io.Serializable;

import br.edu.ifms.biblioteca.model.Aluno;

public class AlunoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private int matricula;
	private String nome;
	private int turma;
	private String disciplina;
	
	public AlunoDto() {
	
	}

	public AlunoDto(Aluno obj) {
		super();
		this.id = obj.getId();
		this.matricula = obj.getMatricula();
		this.nome = obj.getNome();
		this.turma = obj.getTurma();
		this.disciplina = obj.getDisciplina();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
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
