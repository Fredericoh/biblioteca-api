package br.com.faculdadedelta.bibliotecaapi.service;

import br.com.faculdadedelta.bibliotecaapi.model.Editora;
import br.com.faculdadedelta.bibliotecaapi.repository.EditoraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    @Transactional
    public Editora inserir(Editora editora){
        editora.setId (null);
        return editoraRepository.save (editora);
    }

    public Editora pesquisarPorId(Long id){

        return editoraRepository.findById (id).orElseThrow (()-> new EmptyResultDataAccessException (1));
    }

    @Transactional
    public Editora alterar(Editora editora, Long id){
        Editora editoraPesquisada = pesquisarPorId (id);

        BeanUtils.copyProperties (editora, editoraPesquisada, "id");

        return editoraRepository.save (editoraPesquisada);
    }

    @Transactional
    public void excluir(Long id){

        editoraRepository.deleteById (id);
    }

    public List<Editora> listar(){

        return editoraRepository.findAll ();
    }
}
