package lv.latvijasrokdarbi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "AtlaideTable")
@Entity
public class Atlaide {

	@Id
	@Column(name="AtlaideId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int atlaideId;
	
	@OneToMany(mappedBy = "atlaide")
	@ToString.Exclude
	private Collection<Prece> preces = new ArrayList<Prece>();
	
	@Column(name="Nosaukums")
	@NotNull
	@Size(min=3, max=50)
	@Pattern(regexp = "[A-zÀ-ȕ0-9 ]+", message = "Tikai burti, skaitli un atstarpe")
	private String nosaukums;
	
	@Column(name="AtlaidesApmers")
	@Min(0)
	@Max(1)
	private float atlaidesApmers;
	
	@Column(name="SakumaDatumsLaiks")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
	private LocalDateTime sakumaDatumsLaiks;
	
	@Column(name="BeiguDatumsLaiks")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
	private LocalDateTime beiguDatumsLaiks;
	
	@Column(name="Apraksts")
	@NotNull
	@Size(min=3, max=280)
	@Pattern(regexp = ".+", message = "Jebkadi simboli")
	private String apraksts;
	
	public Atlaide(String nosaukums, float atlaidesApmers, LocalDateTime sakumaDatumsLaiks, LocalDateTime beiguDatumsLaiks, String apraksts /*, Prece ... preces*/) {
		setNosaukums(nosaukums);
		setAtlaidesApmers(atlaidesApmers);
		setSakumaDatumsLaiks(sakumaDatumsLaiks);
		setBeiguDatumsLaiks(beiguDatumsLaiks);
		setApraksts(apraksts);
//		for(Prece tempP: preces)
//			addPrece(tempP);
	}
	
//	public void addPrece(Prece prece) {
//		if(!preces.contains(prece)) {
//			preces.add(prece);
//		}
//	}
}
