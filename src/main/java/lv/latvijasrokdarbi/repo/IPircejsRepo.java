package lv.latvijasrokdarbi.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.latvijasrokdarbi.model.Pircejs;

public interface IPircejsRepo extends CrudRepository<Pircejs, Integer>{
	
		Pircejs findByPircejsId(int id);
		
		Pircejs findByEpastsIgnoreCaseContaining(String epasts);
		
		ArrayList<Pircejs> findByVardsIgnoreCaseContainingOrUzvardsIgnoreCaseContaining(String vards, String uzvards);

}
