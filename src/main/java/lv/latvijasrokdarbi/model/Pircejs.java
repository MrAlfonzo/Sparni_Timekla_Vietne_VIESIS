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
@Table
@Entity(name="PircejsTable")
public class Pircejs {
	@Id
	@Column(name="PircejsId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	private int pircejsId;
	
	@OneToMany(mappedBy = "pircejs")
	@ToString.Exclude
	private Collection<Pirkums> pirkums = new ArrayList<Pirkums>();
	
	@NotNull
	@Column(name = "Vards")
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Tikai burti un atstarpe")
	private String vards;
	
	@NotNull
	@Column(name = "Uzvards")
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Tikai burti un atstarpe")
	private String uzvards;
	
	@NotNull
	@Column(name="Epasts")
	@Size(min = 6, max = 30)
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
	private String epasts;
	
	@NotNull
	@Column(name="Adrese")
	@Size(min = 10, max = 50)
	@Pattern(regexp="[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ0-9, ]+")
	private String adrese;
	
	@Column(name="BankasNosaukums")
	@Size(min = 3, max = 20)
	@Pattern(regexp="[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ0-9, ]+")
	private String bankasNosaukums;
	
	@Column(name="BankasSwiftKods")
	@Size(min = 8, max = 11)
	@Pattern(regexp="[A-Z]{6}[A-Z0-9]+")
	private String bankasSwiftKods;
	
	@Column(name="BankasKonts")
	@Size(min = 8, max = 17)
	@Pattern(regexp="[A-Z0-9]+")
	private String bankasKonts;
	
	public Pircejs (String vards, String uzvards, String epasts, String adrese, String bankasNosaukums, String bankasSwiftKods, String bankasKonts) {
		setVards(vards);
		setUzvards(uzvards);
		setEpasts(epasts);
		setAdrese(adrese);
		setBankasNosaukums(bankasNosaukums);
		setBankasSwiftKods(bankasSwiftKods);
		setBankasKonts(bankasKonts);
	}
}
