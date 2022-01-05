package gr.hua.dit.DistributedSystemsAssignment.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unemployed")
public class Unemployed {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String name;
	@Column(name="last_name")
	private String lname;
	@Column(name="email")
	private String email;
	@Column(name="city_of_residence")
	private String city;
	@Column(name="AFM")
	private String AFM;
	@Column(name="AMKA")
	private String AMKA;
	@Column(name="unemployment_duration")
	private int daysOfUnemployment;
	@Column(name="date_of_birth")
	private Date birthDate;
	@Column(name="id_number")
	private String idNumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAFM() {
		return AFM;
	}
	public void setAFM(String aFM) {
		AFM = aFM;
	}
	public String getAMKA() {
		return AMKA;
	}
	public void setAMKA(String aMKA) {
		AMKA = aMKA;
	}
	public int getDaysOfUnemployment() {
		return daysOfUnemployment;
	}
	public void setDaysOfUnemployment(int daysOfUnemployment) {
		this.daysOfUnemployment = daysOfUnemployment;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Unemployed(int id, String name, String lname, String email, String city, String aFM, String aMKA,
			int daysOfUnemployment, Date birthDate, String idNumber) {
		super();
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.email = email;
		this.city = city;
		AFM = aFM;
		AMKA = aMKA;
		this.daysOfUnemployment = daysOfUnemployment;
		this.birthDate = birthDate;
		this.idNumber = idNumber;
	}
	
	public Unemployed() {
		
	}
}
