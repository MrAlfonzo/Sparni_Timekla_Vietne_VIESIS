package lv.latvijasrokdarbi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lv.latvijasrokdarbi.model.Pircejs;

public interface IPircejsService {
	
	void createPircejs(Pircejs pircejs) throws Exception;
	
	Pircejs retrievePircejsById(int id) throws Exception;
	
	void updatePircejsById(int id, Pircejs pircejs) throws Exception;
	
	void deletePircejsById(int id) throws Exception;
	
	ArrayList<Pircejs> selectAllPircejs() throws Exception;
	
}
