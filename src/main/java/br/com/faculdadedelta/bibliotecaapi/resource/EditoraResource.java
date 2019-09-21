package br.com.faculdadedelta.bibliotecaapi.resource;

import br.com.faculdadedelta.bibliotecaapi.model.Editora;
import br.com.faculdadedelta.bibliotecaapi.service.EditoraService;
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
@RequestMapping("/editoras")
public class EditoraResource {

    @Autowired
    private EditoraService editoraService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Editora inserir(@RequestBody @Valid Editora editora, HttpServletResponse response){

        Editora livroSalvo = editoraService.inserir (editora);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest ()
                .path ("/{id}")
                .buildAndExpand (editora.getId ()).toUri ();

        response.setHeader (HttpHeaders.LOCATION, uri.toString ());

        return livroSalvo;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Editora> listar(){

        return editoraService.listar ();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Editora pesquisarPorId(@PathVariable("id") Long id){

        return editoraService.pesquisarPorId (id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Editora alterar(@RequestBody @Valid Editora editora, @PathVariable Long id){

        return editoraService.alterar (editora, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){

        editoraService.excluir (id);
    }
}
