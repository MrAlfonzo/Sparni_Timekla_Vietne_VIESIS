package lv.latvijasrokdarbi.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.latvijasrokdarbi.model.Prece;

public interface IPreceRepo  extends CrudRepository<Prece, Integer>{

	Prece findByNosaukumsAndAprakstsAndCena(String nosaukums, String apraksts, float cena);

	ArrayList<Prece> findByCenaLessThanEqual(float cena);

	ArrayList<Prece> findByDaudzumsLessThanEqual(int daudzums);

	ArrayList<Prece> findByNosaukumsIgnoreCaseContainingOrAprakstsIgnoreCaseContaining(String phrase, String phrase2);

	ArrayList<Prece> findByKategorija_KategorijaId(int id);

	ArrayList<Prece> findByAtlaide_AtlaideId(int id);

}
