package com.osintegra.demo.domain.model;

import javax.persistence.*;

@Entity
public class Cliente {
	
	/*
	 * @Author : lucasDev20
	 * Description : Classe cliente 
	 * que pega e retorna atributos que vao 
	 * ser utilizados dentro do projeto
	 * 
	 * 
	 */
	
	//---------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	
	@Column(name = "fone")
	private String telefone;

    //Geters
	//--------------------------------------------------------------

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}
	
	//--------------------------------------------------------------

	//Seters 
	//--------------------------------------------------------------
    
	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//-------------------------------------------------------------- 
	
	//entendendo hashcode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	// garante que a informaçao esteja em um so lugar 
	// fonte : https://angeliski.com.br/2014/01/05/equals-e-hashcode/#:~:text=O%20hashCode%20%C3%A9%20uma%20ferramenta,de%20hash%20de%20modo%20correto.
	//---------------------------------------------------------------------
	
    //---------------------------------------------------------------------
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	// fonte : https://www.devmedia.com.br/sobrescrevendo-o-metodo-equals-em-java/26484

	//---------------------------------------------------------------------
}
