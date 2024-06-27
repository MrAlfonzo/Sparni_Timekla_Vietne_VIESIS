package lv.latvijasrokdarbi.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.latvijasrokdarbi.model.Prece;
import lv.latvijasrokdarbi.model.PrecesBilde;

public interface IPrecesBildeRepo  extends CrudRepository<PrecesBilde, Integer>{

	PrecesBilde findByPreceAndBildeAndApraksts(Prece prece, String bilde, String apraksts);

	ArrayList<PrecesBilde> findByPrece_PreceId(int id);

}
