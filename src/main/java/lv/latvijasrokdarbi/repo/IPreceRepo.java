package lv.latvijasrokdarbi.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.latvijasrokdarbi.model.Prece;

public interface IPreceRepo  extends CrudRepository<Prece, Integer>{

	Prece findByNosaukumsAndAprakstsAndCena(String nosaukums, String apraksts, float cena);

	ArrayList<Prece> findByCenaLessThan(float cena);

	ArrayList<Prece> findByDaudzumsLessThan(int daudzums);

	ArrayList<Prece> findByNosaukumsIgnoreCaseContainingOrAprakstsIgnoreCaseContaining(String phrase, String phrase2);

	ArrayList<Prece> findByKategorijaId(int id);

	ArrayList<Prece> findByAtlaideId(int id);

}
