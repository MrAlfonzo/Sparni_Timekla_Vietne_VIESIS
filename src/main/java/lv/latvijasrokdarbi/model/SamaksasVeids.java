package lv.latvijasrokdarbi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name="SamaksasVeidsTable")
@Entity
public class SamaksasVeids {
	
	@Id
	@Column(name="SamaksasVeidsId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	private int samaksasVeidsId;
	
	@Column(name="Nosaukums")
	@Size(min = 5, max = 20)
	@Pattern(regexp="[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+")
	private String nosaukums;
	
	@Column(name="Piezimes")
	@Size(min = 2, max = 150)
	private String piezimes;
	
	public SamaksasVeids (String nosaukums, String piezimes) {
		setNosaukums(nosaukums);
		setPiezimes(piezimes);
	}
}
