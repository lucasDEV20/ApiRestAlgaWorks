package com.osintegra.demo.domain.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osintegra.demo.domain.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	
/*
 * @author : LucasDev20
 * Description : interface do repositorio de clientes, 
 * que e estendida pela classe controladora Cliente.
 *  
 *
 */
	
	//List<Cliente> findByName(String id);
	//List<Cliente> fimdByNameContaining(String nome);
	List<Cliente> findByNome(String nome); //exemplo consulta =
	List<Cliente> findByNomeContaining(String nome); //exemplo consulta like
	Cliente findByEmail(String email); //exemplo consulta por atributo
  //	

}
