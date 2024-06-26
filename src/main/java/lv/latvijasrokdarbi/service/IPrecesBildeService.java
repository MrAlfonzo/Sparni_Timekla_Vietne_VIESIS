package lv.latvijasrokdarbi.service;

import java.util.ArrayList;

import lv.latvijasrokdarbi.model.PrecesBilde;

public interface IPrecesBildeService {
	public abstract void createPrecesBilde(PrecesBilde precesBilde);
	
	public abstract PrecesBilde retrievePrecesBildeById(int id) throws Exception;

	public abstract void updatePrecesBildeById(int id, PrecesBilde precesBilde) throws Exception;
	
	public abstract void deletePrecesBildeById(int id) throws Exception;
	
	public abstract void deletePrecesBildeByPreceId(int id) throws Exception;
	
	public abstract ArrayList<PrecesBilde> selectAllPrecesBildes() throws Exception;
	
	public abstract ArrayList<PrecesBilde> selectAllPrecesBildesByPrecesId(int id) throws Exception;
}
