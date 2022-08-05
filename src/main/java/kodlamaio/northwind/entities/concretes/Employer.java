package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor; 
 
@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false) 
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
public class Employer extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name="company_name",nullable = false)
	private String companyName;
	
	@Column(name="web_address",nullable = false) 
	private String webAddress;
	
	@Column(name="phone_number",nullable = false)
	private String phoneNumber;
	
	
}
