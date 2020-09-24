package com.lino.teste.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lino.teste.controller.dto.ExameDTO;
import com.lino.teste.domain.entity.Exame;
import com.lino.teste.domain.entity.Paciente;
import com.lino.teste.repository.ExamesRepository;
import com.lino.teste.repository.PacienteRepository;

@RestController
@RequestMapping("/api/exames")
public class ExameController {
	
	@Autowired
	private ExamesRepository repository;
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Exame salvar(@RequestBody ExameDTO dto) {
		
		LocalDate data = LocalDate.parse(dto.getDataExame(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idPaciente = dto.getIdPaciente();
		
		Paciente paciente = 
				pacienteRepository
				.findById(idPaciente).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Paciente inesistente"));
		
		
		Exame exame = new Exame();
		exame.setDescricao(dto.getDescricao());
		exame.setDataExame(data);
		exame.setPaciente(paciente);
		
		return repository.save(exame);
		
	}
	
	@GetMapping
	public List<Exame> pesquisar(@RequestParam(value = "nome",required = false,defaultValue = "") String nome,
								 @RequestParam(value = "mes",required = false) Integer mes){
		
		return repository.findNomePacienteAndMes("%"+nome+"%",mes);
		
		
	}

}
