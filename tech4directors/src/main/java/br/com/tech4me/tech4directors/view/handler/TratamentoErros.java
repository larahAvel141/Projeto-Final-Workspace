package br.com.tech4me.tech4directors.view.handler;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TratamentoErros extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
    HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        List<String> erros = ex.getBindingResult()
        .getFieldErrors().stream()
        .map(err -> String.format("Campo: %s - Mensagem: %s", err.getField(),err.getDefaultMessage()))
        .collect(Collectors.toList());
        return new ResponseEntity<>(erros, NOT_ACCEPTABLE);
    }
    
}
