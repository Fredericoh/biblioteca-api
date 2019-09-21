package br.com.faculdadedelta.bibliotecaapi.service;

import br.com.faculdadedelta.bibliotecaapi.model.Genero;
import br.com.faculdadedelta.bibliotecaapi.repository.GeneroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Transactional
    public Genero inserir(Genero genero){
        genero.setId (null);
        return generoRepository.save (genero);
    }

    public Genero pesquisarPorId(Long id){

        return generoRepository.findById (id).orElseThrow (()-> new EmptyResultDataAccessException (1));
    }

    @Transactional
    public Genero alterar(Genero genero, Long id){
        Genero generoPesquisado = pesquisarPorId (id);

        BeanUtils.copyProperties (genero, generoPesquisado, "id");

        return generoRepository.save (generoPesquisado);
    }

    @Transactional
    public void excluir(Long id){

        generoRepository.deleteById (id);
    }

    public List<Genero> listar(){

        return generoRepository.findAll ();
    }

}
