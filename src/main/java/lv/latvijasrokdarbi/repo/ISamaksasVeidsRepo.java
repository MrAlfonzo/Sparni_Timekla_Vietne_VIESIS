package lv.latvijasrokdarbi.repo;

import org.springframework.data.repository.CrudRepository;

import lv.latvijasrokdarbi.model.SamaksasVeids;

public interface ISamaksasVeidsRepo extends CrudRepository<SamaksasVeids, Integer> {
	
	SamaksasVeids findBySamaksasVeidsId(int id);
	
	SamaksasVeids findByNosaukumsIgnoreCaseContaining(String nosaukums);

}
