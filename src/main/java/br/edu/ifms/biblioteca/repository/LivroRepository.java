package br.edu.ifms.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.biblioteca.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
