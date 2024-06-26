package lv.latvijasrokdarbi.service;

import java.util.ArrayList;

import lv.latvijasrokdarbi.model.Atlaide;

public interface IAtlaideService {
	
	public abstract void createAtlaide(Atlaide atlaide);
	
	public abstract Atlaide retrieveAtlaideById(int id) throws Exception;

	public abstract void updateAtlaideById(int id, Atlaide atlaide) throws Exception;
	
	public abstract void deleteAtlaideById(int id) throws Exception;
	
	public abstract ArrayList<Atlaide> selectAllAtlaides() throws Exception;
	
	public abstract ArrayList<Atlaide> filterByNosaukumsOrApraksts(String phrase) throws Exception;
}
