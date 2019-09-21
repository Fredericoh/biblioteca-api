package br.com.faculdadedelta.bibliotecaapi.service;

import br.com.faculdadedelta.bibliotecaapi.model.Livro;
import br.com.faculdadedelta.bibliotecaapi.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public Livro inserir(Livro livro){
        livro.setId (null);
        return livroRepository.save (livro);
    }

    public Livro pesquisarPorId(Long id){

        return livroRepository.findById (id).orElseThrow (()-> new EmptyResultDataAccessException (1));
    }

    @Transactional
    public Livro alterar(Livro livro, Long id){
        Livro livroPesquisado = pesquisarPorId (id);

        BeanUtils.copyProperties (livro, livroPesquisado, "id");

        return livroRepository.save (livroPesquisado);
    }

    @Transactional
    public void excluir(Long id){

        livroRepository.deleteById (id);
    }

    public List<Livro> listar(){

        return livroRepository.findAll ();
    }
}
