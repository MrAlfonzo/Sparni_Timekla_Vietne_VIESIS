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
@Table(name="PirkumsTable")
@Entity
public class Pirkums {
	
	@Id
	@Column(name="PirkumsId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int pirkumsId;
	
	@ManyToOne
	@JoinColumn(name="PircejsId")
	private Pircejs pircejs;
	
	@ManyToOne
	@JoinColumn(name="PiegadesVeidsId")
	private PiegadesVeids piegadesVeids;
	
	@ManyToOne
	@JoinColumn(name="SamaksasVeidsId")
	private SamaksasVeids samaksasVeids;
	
	@OneToMany(mappedBy = "pirkums")
	@ToString.Exclude
	private Collection<PirkumaElements> pirkumaElements = new ArrayList<PirkumaElements>();
	
	@NotNull
	@Column(name="PasutijumaDatums")
	private LocalDateTime pasutijumaDatums;
	
	@Column(name="PiegadesDetalas")
	@Size(max=150)
	private String piegadesDetalas;
	
	@NotNull
	@Column(name="Statuss")
	private Statuss statuss;
	
	
	
}
