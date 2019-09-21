package br.com.faculdadedelta.bibliotecaapi.repository;

import br.com.faculdadedelta.bibliotecaapi.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
}
