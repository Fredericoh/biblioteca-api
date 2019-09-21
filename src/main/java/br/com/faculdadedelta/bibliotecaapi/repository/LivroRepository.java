package br.com.faculdadedelta.bibliotecaapi.repository;

import br.com.faculdadedelta.bibliotecaapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
