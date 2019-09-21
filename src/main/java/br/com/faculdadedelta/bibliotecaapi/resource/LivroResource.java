package br.com.faculdadedelta.bibliotecaapi.resource;

import br.com.faculdadedelta.bibliotecaapi.model.Livro;
import br.com.faculdadedelta.bibliotecaapi.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro inserir(@RequestBody @Valid Livro livro, HttpServletResponse response){

        Livro livroSalvo = livroService.inserir (livro);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest ()
                .path ("/{id}")
                .buildAndExpand (livro.getId ()).toUri ();

        response.setHeader (HttpHeaders.LOCATION, uri.toString ());

        return livroSalvo;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> listar(){

        return livroService.listar ();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Livro pesquisarPorId(@PathVariable("id") Long id){

        return livroService.pesquisarPorId (id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Livro alterar(@RequestBody @Valid Livro livro, @PathVariable Long id){

        return livroService.alterar (livro, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){

        livroService.excluir (id);
    }
}
