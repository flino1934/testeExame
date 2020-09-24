package com.lino.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lino.teste.domain.entity.Exame;

public interface ExamesRepository extends JpaRepository<Exame, Integer>{

	@Query(" select e from Exame e join e.paciente p where upper (p.nome) like upper( :nome) and MONTH(e.dataExame) =:mes ")
	List<Exame> findNomePacienteAndMes(@Param("nome") String nome,@Param("mes") Integer mes);

}
