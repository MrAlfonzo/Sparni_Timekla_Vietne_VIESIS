package lv.latvijasrokdarbi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pasakumi {
	
	private int pasakumi_id;

	private String s_datums;
	
	private String b_datums;
	
	private String nosaukums;
	
	private String laiks;
	
	private String vieta;
	
	private String apraksts;
	
	public Pasakumi(String s_datums, String b_datums, String nosaukums,
			String laiks, String vieta, String apraksts) {
		
		setS_datums(s_datums);
		setB_datums(b_datums);
		setNosaukums(nosaukums);
		setLaiks(laiks);
		setVieta(vieta);
		setApraksts(apraksts);
		
	}
}
