package lv.latvijasrokdarbi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table (name = "PasakumaBildeTable")
@Entity
public class PasakumaBilde {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "pasakumaBildesID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //autoincrement
	private int pasakumaBildesID;
	
	@NotNull
	@Column(name = "Bilde")
	private String bilde;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Tikai burti un atstarpes ir atļautas")
	@Column(name = "Nosaukums")
	private String nosaukums;
	
	@NotNull
	@Size(min = 3, max = 4000)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Tikai burti un atstarpes ir atļautas")
	@Column(name = "Nosaukums")
	private String apraksts;
	
	private 
	
	public PasakumaBilde (String bilde, String nosaukums, String apraksts) {
		
		setBilde(bilde);
		setNosaukums(nosaukums);
		setApraksts(apraksts);
	}
	
}
