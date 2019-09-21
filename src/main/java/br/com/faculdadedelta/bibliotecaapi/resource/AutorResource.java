package br.com.faculdadedelta.bibliotecaapi.resource;

import br.com.faculdadedelta.bibliotecaapi.model.Autor;
import br.com.faculdadedelta.bibliotecaapi.service.AutorService;
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
@RequestMapping("/autores")
public class AutorResource {

    @Autowired
    private AutorService autorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autor inserir(@RequestBody @Valid Autor autor, HttpServletResponse response){

        Autor autorSalvo = autorService.inserir (autor);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest ()
                .path ("/{id}")
                .buildAndExpand (autor.getId ()).toUri ();

        response.setHeader (HttpHeaders.LOCATION, uri.toString ());

        return autorSalvo;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Autor> listar(){

        return autorService.listar ();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autor pesquisarPorId(@PathVariable("id") Long id){

        return autorService.pesquisarPorId (id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autor alterar(@RequestBody @Valid Autor autor, @PathVariable Long id){

        return autorService.alterar (autor, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){

        autorService.excluir (id);
    }
}
