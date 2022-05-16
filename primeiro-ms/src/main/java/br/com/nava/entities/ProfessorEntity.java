package br.com.nava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorEntity {

	//id, nome, cpf, rua, cep, numero
	
	private int id;
	private String nome;
	private String cpf;
	private String rua;
	private String cep;
	private int numero;
}
