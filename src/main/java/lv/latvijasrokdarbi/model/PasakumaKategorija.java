package lv.latvijasrokdarbi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Tikai burti un atstarpes ir atļautas")
	@Column(name = "Nosaukums")
	private String nosaukums;
	
	public PasakumaKategorija (String nosaukums) {
		
		setNosaukums(nosaukums);
	}
}
