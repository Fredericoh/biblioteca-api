package br.com.faculdadedelta.bibliotecaapi.service;

import br.com.faculdadedelta.bibliotecaapi.model.Autor;
import br.com.faculdadedelta.bibliotecaapi.repository.AutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public Autor inserir(Autor autor){
        autor.setId (null);
        return autorRepository.save (autor);
    }

    public Autor pesquisarPorId(Long id){

        return autorRepository.findById (id).orElseThrow (()-> new EmptyResultDataAccessException (1));
    }

    @Transactional
    public Autor alterar(Autor autor, Long id){
        Autor autorPesquisado = pesquisarPorId (id);

        BeanUtils.copyProperties (autor, autorPesquisado, "id");

        return autorRepository.save (autorPesquisado);
    }

    @Transactional
    public void excluir(Long id){

        autorRepository.deleteById (id);
    }

    public List<Autor> listar(){

        return autorRepository.findAll ();
    }
}
