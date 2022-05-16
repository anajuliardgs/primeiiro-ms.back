package br.com.nava.services;

import java.util.ArrayList; 
import org.springframework.stereotype.Service;
import br.com.nava.entities.ProfessorEntity;

@Service
public class ProfessorService {

	public void mostrar() {
		System.out.println("mostrar");
	}
	
	public ProfessorEntity getOne(int id, ArrayList<ProfessorEntity> listaProfessor) {
		
		int indice = findIndex(id, listaProfessor);
		return (indice >= 0 ? listaProfessor.get(indice) : null);
	}
	
	public int findIndex(int id, ArrayList<ProfessorEntity> listaProfessor) {
		
		for (int i = 0; i < listaProfessor.size(); i++) {
			if (listaProfessor.get(i).getId() == id) {
				return i;
			}
		}
		
		return -1;
	}
	 // variável professor contém os dados vindo da requisição  REST
	public ProfessorEntity update(int id, ProfessorEntity professor, 
				ArrayList<ProfessorEntity> listaProfessor ) {
		
		int indice = findIndex(id, listaProfessor);
		
		if (indice >= 0) {
			
			listaProfessor.get(indice).setNome( professor.getNome() );
			listaProfessor.get(indice).setCpf( professor.getCpf() );
			listaProfessor.get(indice).setRua( professor.getRua() );
			listaProfessor.get(indice).setNumero( professor.getNumero() );
			listaProfessor.get(indice).setCep( professor.getCep() );
			
			return listaProfessor.get(indice);
		}
		
		return null;
	}
	
	public void delete(int id, ArrayList<ProfessorEntity> listaProfessor) {
		
		int indice = findIndex(id, listaProfessor);
		
		if (indice >= 0) listaProfessor.remove(indice);
	}
}
