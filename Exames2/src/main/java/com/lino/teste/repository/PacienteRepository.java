package com.lino.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lino.teste.domain.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
