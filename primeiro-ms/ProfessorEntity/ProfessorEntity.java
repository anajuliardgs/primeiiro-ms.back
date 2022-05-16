package br.com.nava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorEntity {
	private int id;
	private String nome;
	private String cpf;
	private String rua;
	private int numero;
	private String cep;
}
