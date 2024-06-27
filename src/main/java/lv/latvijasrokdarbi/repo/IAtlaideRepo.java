package lv.latvijasrokdarbi.repo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.latvijasrokdarbi.model.Atlaide;

public interface IAtlaideRepo extends CrudRepository<Atlaide, Integer>{

	Atlaide findByNosaukumsAndAtlaidesApmersAndSakumaDatumsLaiksAndBeiguDatumsLaiksAndApraksts(String nosaukums,
			float atlaidesApmers, LocalDateTime sakumaDatumsLaiks, LocalDateTime beiguDatumsLaiks, String apraksts);

	ArrayList<Atlaide> findByNosaukumsIgnoreCaseContainingOrAprakstsIgnoreCaseContaining(String phrase, String phrase2);

}
