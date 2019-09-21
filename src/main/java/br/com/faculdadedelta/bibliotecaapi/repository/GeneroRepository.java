package br.com.faculdadedelta.bibliotecaapi.repository;

import br.com.faculdadedelta.bibliotecaapi.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
