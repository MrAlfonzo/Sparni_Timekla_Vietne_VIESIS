package lv.latvijasrokdarbi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="PreceTable")
@Entity
public class Prece {
	
	@Id
	@Column(name="PreceId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	private int preceId;
	
	@Column(name="Nosaukums")
	@NotNull
	@Size(min=3, max=50)
	@Pattern(regexp = "[\\w\\d ]+", message = "Tikai burti, skaitli un atstarpe")
	private String nosaukums;
	
	@Column(name="Apraksts")
	@NotNull
	@Size(min=3, max=280)
	@Pattern(regexp = ".", message = "Jebkadi simboli")
	private String apraksts;
	
	@Column(name="Cena")
	@Min(0)
	@Max(1000)
	private float cena;
	
	@Column(name="Daudzums")
	@Min(1)
	@Max(500)
	private int daudzums;
	
	public Prece(String nosaukums, String apraksts, float cena, int daudzums) {
		setNosaukums(nosaukums);
		setApraksts(apraksts);
		setCena(cena);
		setDaudzums(daudzums);
	}
}
