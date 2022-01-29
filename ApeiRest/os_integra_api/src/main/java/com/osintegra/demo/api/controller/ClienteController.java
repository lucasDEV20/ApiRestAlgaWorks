package com.osintegra.demo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.osintegra.demo.domain.model.Cliente;
import com.osintegra.demo.domain.repositoy.ClienteRepository;

/*
 * @Author LucasDev20
 * Description > classe que mapeia 
 * 
 */

/**
 * 
 * @author LucasDEV20
 * @Descreptiom 
 * @date 
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/{clienteid}")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
		// return clienteRepository.findByNameContaining("si");
	}

	@GetMapping("/clientes/{clienteid}")
	public ResponseEntity<Cliente> buscar(@PathVariable long clienteid) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteid);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get()); 
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> put( @PathVariable Long id, @RequestBody Cliente cliente) {
		// ResponseEntity para tratar resposta requisições
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id); // set id para JPA entender como "editar" ao inves de "incluir"
		return ResponseEntity.ok(cliente);
	}
	
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable long clienteId){
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(clienteId);
		return ResponseEntity.noContent().build();
	}

	
	
	
	

}
