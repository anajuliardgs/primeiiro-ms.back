package br.com.nava.controllers;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.nava.entities.ProfessorEntity;

@RestController
@RequestMapping("Professor")
public class ProfessorController {
	private ArrayList<ProfessorEntity> listaProfessor = new ArrayList<ProfessorEntity>();
	private int contator = 1;
	@GetMapping("")
	public ArrayList<ProfessorEntity> getProfessor() {
		return listaProfessor;
	}
	@GetMapping("{id}")
	public ProfessorEntity getOne(@PathVariable Integer id) {
		System.out.println(id);
		for (int i = 0; i < listaProfessor.size(); i++ ) {
			if (listaProfessor.get(i).getId() == id) {
				return listaProfessor.get(i);
			}
		}
	return null;
	}
	@PostMapping ("")
	public ProfessorEntity save(@RequestBody ProfessorEntity professor) {
		System.out.println(professor);
		professor.setId(contator);
		listaProfessor.add(professor);
		contator++;
		System.out.println(professor);
		return professor;
	}
	@PatchMapping("{id}")
	public ProfessorEntity update(@PathVariable Integer id, @RequestBody ProfessorEntity professor) {
		System.out.println(id);
		System.out.println(professor);
		
		for (int i = 0 ; i < listaProfessor.size(); i++) {
			if (listaProfessor.get(i).getId() == id) {
				listaProfessor.get(i).setNome(professor.getNome());
				listaProfessor.get(i).setCpf(professor.getCpf());
				listaProfessor.get(i).setRua(professor.getRua());
				listaProfessor.get(i).setNumero(professor.getNumero());
				return listaProfessor.get(i);
			}
		}
		return null;
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		for (int i = 0 ; i < listaProfessor.size(); i++) {
			if (listaProfessor.get(i).getId() == id) {
				
				listaProfessor.remove(i);
			}
		}
	}
}
