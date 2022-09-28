package br.edu.ifms.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.biblioteca.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{

}
