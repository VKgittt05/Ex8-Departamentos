package com.Gerenciamento_Departamentos.Departamentos.controllers;

import com.Gerenciamento_Departamentos.Departamentos.models.Departamento;
import com.Gerenciamento_Departamentos.Departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @PostMapping
    public ResponseEntity<Departamento> criar(@RequestBody Departamento departamento) {
        Departamento novoDepto = service.salvar(departamento);
        return new ResponseEntity<>(novoDepto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Departamento> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

