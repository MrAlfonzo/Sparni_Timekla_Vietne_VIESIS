package lv.latvijasrokdarbi.service;

import java.util.ArrayList;

import lv.latvijasrokdarbi.model.SamaksasVeids;

public interface ISamaksasVeidsService {

	void createSamaksasVeids(SamaksasVeids samaksasVeids) throws Exception;
	
	SamaksasVeids retrieveSamaksasVeidsById(int id) throws Exception;
	
	void updateSamaksasVeidsById(int id, SamaksasVeids samaksasVeids) throws Exception;
	
	void deleteSamaksasVeidsById(int id) throws Exception;
	
	ArrayList<SamaksasVeids> selectAllSamaksasVeids() throws Exception;
	
}
