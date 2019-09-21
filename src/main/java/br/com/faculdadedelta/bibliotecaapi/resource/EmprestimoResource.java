package br.com.faculdadedelta.bibliotecaapi.resource;

import br.com.faculdadedelta.bibliotecaapi.model.Emprestimo;
import br.com.faculdadedelta.bibliotecaapi.service.EmprestimoService;
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
@RequestMapping("/emprestimos")
public class EmprestimoResource {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Emprestimo inserir(@RequestBody @Valid Emprestimo emprestimo, HttpServletResponse response){

        Emprestimo emprestimoSalvo = emprestimoService.inserir (emprestimo);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest ()
                .path ("/{id}")
                .buildAndExpand (emprestimo.getId ()).toUri ();

        response.setHeader (HttpHeaders.LOCATION, uri.toString ());

        return emprestimoSalvo;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Emprestimo> listar(){

        return emprestimoService.listar ();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Emprestimo pesquisarPorId(@PathVariable("id") Long id){

        return emprestimoService.pesquisarPorId (id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Emprestimo alterar(@RequestBody @Valid Emprestimo emprestimo, @PathVariable Long id){

        return emprestimoService.alterar (emprestimo, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){

        emprestimoService.excluir (id);
    }
}
