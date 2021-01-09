package tacos.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="PLACEDAT")
	private Date placedAt;

	@NotBlank(message = "Name is required")
	@Column(name="delivery_Name")
	private String name;

	@NotBlank(message = "Street is required")
	@Column(name="delivery_Street")
	private String street;

	@NotBlank(message = "City is required")
	@Column(name="delivery_City")
	private String city;

	@NotBlank(message = "State is required")
	@Column(name="delivery_State")
	private String state;

	@NotBlank(message = "Zip code is required")
	@Column(name="delivery_Zip")
	private String zip;

	@CreditCardNumber(message = "Not a valid credit card number")
	@Column(name="CCNUMBER")
	private String ccNumber;

	@Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
	@Column(name="CCEXPIRATION")
	private String ccExpiration;

	@Digits(integer = 3, fraction = 0, message = "Invalid CVV")
	@Column(name="CCCVV")
	private String ccCVV;

	@ManyToMany(targetEntity=Taco.class)
	private List<Taco> tacos = new ArrayList<>();

	@ManyToOne
	private User user;
	
	
	public void addDesign(Taco saved) {
		this.tacos.add(saved);
	}

	@PrePersist
	void placedAt() {
		this.placedAt = new Date();
	}
}
