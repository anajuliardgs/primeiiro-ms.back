package br.com.nava.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nava.entities.ProfessorEntity;
import br.com.nava.services.ProfessorService;

@RestController
@RequestMapping("professores")
public class ProfessorController {

	private ArrayList<ProfessorEntity> listaProfessor = new ArrayList<>();
	private int contador = 0;
	
	//ProfessorService professorService = new ProfessorService();
	@Autowired
	private ProfessorService professorService;
	
	
	@GetMapping()
	public ArrayList<ProfessorEntity> getAll(){
		//professorService.mostrar();
		return listaProfessor;
	}
	
	@GetMapping("{id}")
	public ProfessorEntity getOne(@PathVariable int id) {
		
//		for (int i = 0; i < listaProfessor.size(); i++) {
//			if (listaProfessor.get(i).getId() == id) {
//				return listaProfessor.get(i);
//			}
//		}
//		int indice = findIndex(id);
//		return (indice >= 0 ? listaProfessor.get(indice) : null);
//		if (indice >= 0) { 
//			return listaProfessor.get(indice);
//		}
//		return null;
		
		return professorService.getOne(id, listaProfessor);
	}
	
	@PostMapping()
	public ProfessorEntity save(@RequestBody ProfessorEntity professor) {
		
		professor.setId(contador);
		//contador++;
		
		listaProfessor.add(professor);
		contador++;
		
		return professor;
	}
	
	@PatchMapping("{id}")
	public ProfessorEntity update(@PathVariable int id, 
			@RequestBody ProfessorEntity professor) {
		
//		for (int i = 0; i < listaProfessor.size(); i++) {
//			if (listaProfessor.get(i).getId() == id) {
//				//if (professor.getNome() != null)
//				
//				listaProfessor.get(i).setNome( professor.getNome() );
//				listaProfessor.get(i).setCpf( professor.getCpf() );
//				listaProfessor.get(i).setRua( professor.getRua() );
//				listaProfessor.get(i).setNumero( professor.getNumero() );
//				listaProfessor.get(i).setCep( professor.getCep() );
//				
//				return listaProfessor.get(i);
//			}
//		}
		
//		int indice = findIndex(id);
//		
//		if (indice >= 0) {
//			
//			listaProfessor.get(indice).setNome( professor.getNome() );
//			listaProfessor.get(indice).setCpf( professor.getCpf() );
//			listaProfessor.get(indice).setRua( professor.getRua() );
//			listaProfessor.get(indice).setNumero( professor.getNumero() );
//			listaProfessor.get(indice).setCep( professor.getCep() );
//			
//			return listaProfessor.get(indice);
//		}
//		
//		return null;
		
		return professorService.update(id, professor, listaProfessor);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
//		for (int i = 0; i < listaProfessor.size(); i++) {
//			if (listaProfessor.get(i).getId() == id) {
//				listaProfessor.remove(i);
//			}
//		}	
		
//		int indice = findIndex(id);
//		
//		if (indice >= 0) listaProfessor.remove(indice);
		professorService.delete(id, listaProfessor);
	}
	

}

