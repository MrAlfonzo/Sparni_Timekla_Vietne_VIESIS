package lv.latvijasrokdarbi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="PirkumaElementsTable")
@Entity
public class PirkumaElements {
	
	@Id
	@Column(name="PirkumaElementsId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	private int pirkumaElementsId;
	
	@ManyToOne
	@JoinColumn(name="PirkumsId")
	private Pirkums pirkums;
	
	@ManyToOne
	@JoinColumn(name="PreceId")
	private Prece prece;
	
	@Column(name="Daudzums")
	@Min(1)
	@Max(50)
	private int daudzums;
}
