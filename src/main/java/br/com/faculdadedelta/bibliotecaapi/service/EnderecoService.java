package br.com.faculdadedelta.bibliotecaapi.service;

import br.com.faculdadedelta.bibliotecaapi.model.Endereco;
import br.com.faculdadedelta.bibliotecaapi.repository.EnderecoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco inserir(Endereco endereco){
        endereco.setId (null);
        return enderecoRepository.save (endereco);
    }

    public Endereco pesquisarPorId(Long id){

        return enderecoRepository.findById (id).orElseThrow (()-> new EmptyResultDataAccessException (1));
    }

    @Transactional
    public Endereco alterar(Endereco endereco, Long id){
        Endereco enderecoPesquisado = pesquisarPorId (id);

        BeanUtils.copyProperties (endereco, enderecoPesquisado, "id");

        return enderecoRepository.save (enderecoPesquisado);
    }

    @Transactional
    public void excluir(Long id){

        enderecoRepository.deleteById (id);
    }

    public List<Endereco> listar(){

        return enderecoRepository.findAll ();
    }
}
