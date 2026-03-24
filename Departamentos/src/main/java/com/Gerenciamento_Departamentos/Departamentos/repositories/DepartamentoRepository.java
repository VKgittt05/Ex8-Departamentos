package com.Gerenciamento_Departamentos.Departamentos.repositories;

import com.Gerenciamento_Departamentos.Departamentos.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}

