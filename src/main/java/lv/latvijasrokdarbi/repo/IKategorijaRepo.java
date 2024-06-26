package lv.latvijasrokdarbi.repo;

import org.springframework.data.repository.CrudRepository;

import lv.latvijasrokdarbi.model.Kategorija;

public interface IKategorijaRepo  extends CrudRepository<Kategorija, Integer>{

}
