package lv.latvijasrokdarbi.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.latvijasrokdarbi.model.PirkumaElements;

public interface IPirkumaElementsRepo extends CrudRepository<PirkumaElements, Integer> {
	
	@Query(nativeQuery = true, value="select * from PirkumaElementsTable where PirkumsId=(?1)")
	ArrayList<PirkumaElements> selectAllPirkumaElementsByPirkumsId(int id);
	
	@Query(nativeQuery = true, value="select * from PirkumaElementsTable where PreceId=(?1)")
	ArrayList<PirkumaElements> selectAllPirkumaElementsByPreceId(int id);
}
