package br.edu.ifms.biblioteca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int maricula;
	private String nome;
	private int turma;
	private String disciplina;
	@OneToMany(mappedBy = "livro")
	private List<Livro> livros= new ArrayList<Livro>();
	
	public Aluno() {
		
	}

	public Aluno(int maricula, String nome, int turma, String disciplina) {
		super();
		this.maricula = maricula;
		this.nome = nome;
		this.turma = turma;
		this.disciplina = disciplina;
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

	@Override
	public int hashCode() {
		return Objects.hash(disciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(disciplina, other.disciplina);
	}

}
