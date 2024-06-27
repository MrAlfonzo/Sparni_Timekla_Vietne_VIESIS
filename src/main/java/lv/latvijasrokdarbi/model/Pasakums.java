package lv.latvijasrokdarbi.model;

import java.time.LocalDateTime;
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
@Table (name = "PasakumiTable")
@Entity
public class Pasakums {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "pasakumsId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //autoincrement
	private int pasakumsId;
	
	@OneToMany(mappedBy = "pasakums")
	@ToString.Exclude
	private Collection<PasakumaBilde> pasakumaBilde = new ArrayList<PasakumaBilde>();

	@ManyToOne
	@JoinColumn(name="pkID")
	private PasakumaKategorija pasakumaKategorija;
	
	@NotNull
	@Column(name = "sDatumLaiks")
	private LocalDateTime sDatumsLaiks;
	
	@NotNull
	@Column(name = "bDatumsLaiks")
	private LocalDateTime bDatumsLaiks;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Tikai burti un atstarpes ir atļautas")
	@Column(name = "Nosaukums")
	private String nosaukums;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Tikai burti un atstarpes ir atļautas")
	@Column(name = "Vieta")
	private String vieta;
	
	@NotNull
	@Size(min = 3, max = 4000)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Tikai burti un atstarpes ir atļautas")
	@Column(name = "Apraksts")
	private String apraksts;
	
	
	
	public Pasakums(LocalDateTime sDatumsLaiks, LocalDateTime bDatumsLaiks, String nosaukums
			, String vieta, String apraksts) {
		
		setSDatumsLaiks(sDatumsLaiks);
		setBDatumsLaiks(bDatumsLaiks);
		setNosaukums(nosaukums);
		setVieta(vieta);
		setApraksts(apraksts);
	}
}
