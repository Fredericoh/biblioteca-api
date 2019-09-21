package br.com.faculdadedelta.bibliotecaapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.JDBCException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BibliotecaExceptionApi extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handlerEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request){

        String mensagemUsuario = "Recurso não encontrado.";
        String mensagemDesenvolvedo = ex.toString ();
        List<ErroDetalhe> erros = Collections.singletonList (new ErroDetalhe (mensagemUsuario, mensagemDesenvolvedo));

        return handleExceptionInternal (ex, erros, new HttpHeaders (), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({JDBCException.class})
    public ResponseEntity<Object> handlerSQLIntegrityConstraintViolationException(JDBCException ex,
                                                                                  WebRequest request){

        String mensagemUsuario = "Não foi possivel executar a operação.";
        String mensagemDesenvolvedo = ex.toString ();
        List<ErroDetalhe> erros = Collections.singletonList (new ErroDetalhe (mensagemUsuario, mensagemDesenvolvedo));

        return handleExceptionInternal (ex, erros, new HttpHeaders (), HttpStatus.NOT_FOUND, request);
    }

    private List<ErroDetalhe> criarListaErros(BindingResult bindingResult){

        List<ErroDetalhe> erros = new ArrayList<>();

//        for (FieldError fieldError : bindingResult.getFieldErrors ()) {
//            erros.add (new ErroDetalhe (fieldError.getDefaultMessage (), fieldError.toString ()));
//        }

        bindingResult.getFieldErrors ().forEach ((fieldError -> erros.add (new ErroDetalhe (fieldError.getDefaultMessage (),
                fieldError.toString ()))));

        return erros;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ErroDetalhe> erros = criarListaErros (ex.getBindingResult ());

        return handleExceptionInternal (ex, erros, headers, HttpStatus.BAD_REQUEST, request);
    }

    @AllArgsConstructor
    @Getter
    private static class ErroDetalhe{
        private String mensagemUsuario;
        private String mensagemDesenvolvedor;
    }

}