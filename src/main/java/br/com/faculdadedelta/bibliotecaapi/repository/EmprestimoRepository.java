package br.com.faculdadedelta.bibliotecaapi.repository;

import br.com.faculdadedelta.bibliotecaapi.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
