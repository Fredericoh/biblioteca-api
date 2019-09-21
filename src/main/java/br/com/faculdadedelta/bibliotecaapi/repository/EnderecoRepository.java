package br.com.faculdadedelta.bibliotecaapi.repository;

import br.com.faculdadedelta.bibliotecaapi.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
