package lv.latvijasrokdarbi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="PrecesBildeTable")
@Entity
public class PrecesBilde {
	
	@Id
	@Column(name="PrecesBildeId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	private int precesBildeId;
	
	@ManyToOne
	@JoinColumn(name="PreceId")
	private Prece prece;
	
	@Column(name="Bilde")
	@NotNull
	@Pattern(regexp = "([a-zA-Z]:)?(\\\\[a-zA-Z0-9_.-]+)+\\\\?", message = "Faila ceļš")
	private String bilde;
	
	@Column(name="Apraksts")
	@NotNull
	@Size(min=3, max=280)
	@Pattern(regexp = ".", message = "Jebkadi simboli")
	private String apraksts;
	
	public PrecesBilde(String bilde, String apraksts) {
		setBilde(bilde);
		setApraksts(apraksts);
	}
}
