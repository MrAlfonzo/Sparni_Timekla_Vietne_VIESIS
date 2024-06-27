package lv.latvijasrokdarbi.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name="KategorijaId")
	private Kategorija kategorija;
	
	@ManyToOne
	@JoinColumn(name="AtlaideId")
	private Atlaide atlaide;
	
	@OneToMany(mappedBy = "prece")
	@ToString.Exclude
	private Collection<PrecesBilde> bildes = new ArrayList<PrecesBilde>();
	
	@Column(name="Nosaukums")
	@NotNull
	@Size(min=3, max=50)
	@Pattern(regexp = "[A-zÀ-ȕ0-9 ]+", message = "Tikai burti, skaitli un atstarpe")
	private String nosaukums;
	
	@Column(name="Apraksts")
	@NotNull
	@Size(min=3, max=280)
	@Pattern(regexp = ".+", message = "Jebkadi simboli")
	private String apraksts;
	
	@Column(name="Cena")
	@Min(0)
	@Max(1000)
	private float cena;
	
	@Column(name="Daudzums")
	@Min(1)
	@Max(500)
	private int daudzums;
	
	public Prece(Kategorija kategorija, String nosaukums, String apraksts, float cena, int daudzums, Atlaide atlaide /*, PrecesBilde ... precesBildes */) {
		setKategorija(kategorija);
		setNosaukums(nosaukums);
		setApraksts(apraksts);
		setCena(cena);
		setDaudzums(daudzums);
		setAtlaide(atlaide);
//		for(PrecesBilde tempP: precesBildes) {
//			addPrecesBilde(tempP);
//		}
	}
//	public void addPrecesBilde(PrecesBilde precesBilde) {
//		if(!bildes.contains(precesBilde)) {
//			bildes.add(precesBilde);
//		}
//	}
}
