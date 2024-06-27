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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table (name = "PasakumaKategorijaTable")
@Entity
public class PasakumaKategorija {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pkID")
    private int pkID;
	
	@OneToMany(mappedBy = "pasakumaKategorija")
	@ToString.Exclude
	private Collection<Pasakums> pasakums = new ArrayList<Pasakums>();

	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Tikai burti un atstarpes ir atļautas")
	@Column(name = "Nosaukums")
	private String nosaukums;
	
	public PasakumaKategorija (String nosaukums) {
		
		setNosaukums(nosaukums);
	}
}
