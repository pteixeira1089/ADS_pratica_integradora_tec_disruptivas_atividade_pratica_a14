package com.projeto.integrado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.integrado.entity.Recurso;
import com.projeto.integrado.service.RecursoService;

import ch.qos.logback.core.joran.conditional.ElseAction;

@RestController
@RequestMapping("/recurso")
public class RecursoController {
	@Autowired
	RecursoService recursoService;
	
	@GetMapping
	public ResponseEntity<List<Recurso>> getAll(){
		List<Recurso> recursos = recursoService.getAll();
		if(!recursos.isEmpty())
			return new ResponseEntity<>(recursos, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Recurso> getById(@PathVariable Integer id) {
		Recurso recurso = recursoService.getById(id);
		if(recurso != null)
			return new ResponseEntity<>(recurso, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}

	@GetMapping("nome/{nome}")
	public ResponseEntity<Recurso> getByNome(@PathVariable String nome){
		Recurso recurso = recursoService.getByNome(nome);
		if(recurso != null)
			return new ResponseEntity<>(recurso, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Recurso> saveRecurso(@RequestBody Recurso recurso) {
		return new ResponseEntity<>(recursoService.saveRecurso(recurso), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Recurso> updateRecurso(@PathVariable Integer id, @RequestBody Recurso recurso) {
		Recurso recursoAtualizada = recursoService.updateRecurso(id, recurso);
		if(recursoAtualizada != null)
			return new ResponseEntity<>(recursoAtualizada, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteRecurso(@PathVariable Integer id) {
		if(recursoService.deleteRecurso(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}
}