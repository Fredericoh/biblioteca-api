package br.com.faculdadedelta.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faculdadedelta.bibliotecaapi.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
