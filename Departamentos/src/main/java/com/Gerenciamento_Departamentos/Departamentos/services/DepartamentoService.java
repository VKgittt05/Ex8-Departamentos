package com.Gerenciamento_Departamentos.Departamentos.services;

import com.Gerenciamento_Departamentos.Departamentos.models.Departamento;
import com.Gerenciamento_Departamentos.Departamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    public Departamento salvar(Departamento departamento) {
        return repository.save(departamento);
    }

    public List<Departamento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Departamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

