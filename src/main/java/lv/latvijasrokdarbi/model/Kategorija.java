package lv.latvijasrokdarbi.model;

import java.util.ArrayList;
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
	private Collection<Prece> preces  = new ArrayList<Prece>();
	
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
	
	public Kategorija(String nosaukums, String apraksts) {
		setNosaukums(nosaukums);
		setApraksts(apraksts);
	}
	
//	public void addPrece(Prece prece) {
//		if(!preces.contains(prece)) {
//			preces.add(prece);
//		}
//	}
	
}
