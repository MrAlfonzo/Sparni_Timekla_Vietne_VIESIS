package lv.latvijasrokdarbi.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="KategorijaTable")
@Entity
public class Kategorija {

	@Id
	@Column(name="KategorijaId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	private int kategorijaId;
	
	@OneToMany(mappedBy = "kategorija")
	@ToString.Exclude
	private Collection<Prece> preces;
	
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
	
	public Kategorija(String nosaukums, String apraksts, Prece ... preces) {
		setNosaukums(nosaukums);
		setApraksts(apraksts);
		for(Prece tempP: preces)
			addPrece(tempP);
	}
	
	public void addPrece(Prece prece) {
		if(!preces.contains(prece)) {
			preces.add(prece);
		}
	}
	
}
