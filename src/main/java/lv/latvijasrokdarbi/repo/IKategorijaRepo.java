package lv.latvijasrokdarbi.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.latvijasrokdarbi.model.Kategorija;

public interface IKategorijaRepo  extends CrudRepository<Kategorija, Integer>{

	Kategorija findByNosaukumsAndApraksts(String nosaukums, String apraksts);

	ArrayList<Kategorija> findByNosaukumsIgnoreCaseContainingOrAprakstsIgnoreCaseContaining(String phrase, String phrase2);

}
