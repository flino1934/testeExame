package com.lino.teste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lino.teste.domain.entity.Paciente;
import com.lino.teste.repository.PacienteRepository;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
	
	@GetMapping
	public List<Paciente>obterTodos(){
		return repository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente salvar(@RequestBody @Valid Paciente paciente) {
		
		return repository.save(paciente);
		
	}
	
	@GetMapping("{id}")
	public Paciente acharPorId(@PathVariable("id") Integer id) {
		
		return repository
				.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente Não encontrado!!!"));
		
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		
		repository.findById(id).map(paciente ->{
			
			repository.delete(paciente);
			return Void.TYPE;
			
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente Não encontrado!!!"));
		
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Integer id,@RequestBody Paciente pacienteAtualizado) {
		
		repository.findById(id).map(paciente ->{
			
			pacienteAtualizado.setId(paciente.getId());
			return repository.save(pacienteAtualizado);
			
			
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente Não encontrado!!!"));
		
	}
	
}
