package gr.hua.dit.DistributedSystemsAssignment.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="application")
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String name;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="date_of_birth")
	private Date birthDate;
	
	@Column(name="id_number")
	private String idNumber;
	
	@Column(name="AFM")
	private String AFM;
	
	@Column(name="AMKA")
	private String AMKA;
	
	@Column(name="marital_status")
	private String maritalStatus;
	
	@Column(name="primary_nationality")
	private String primaryNationality;
	
	@Column(name="city_of_residence")
	private String city;
	
	@Column(name="unemployment_start_date")
	private Date dateOfUnemployment;
	
	@Column(name="photo")
    private String photo;
	
	@Column(name="income")
	private float income;
	
	@Column(name="submitted")
	private boolean submitted;
	
	@Column(name="validated")
	private boolean validated;
	
	@Column(name="approved")
	private boolean approved;
	
	public Application() {
		
	}
	
	public Application(int id, String name, String lname, String email, Date birthDate, String idNumber, String aFM,
			String aMKA, String maritalStatus, String primaryNationality, String city, Date dateOfUnemployment,
			float income, boolean submitted, boolean validated, boolean approved) {
		super();
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.email = email;
		this.birthDate = birthDate;
		this.idNumber = idNumber;
		AFM = aFM;
		AMKA = aMKA;
		this.maritalStatus = maritalStatus;
		this.primaryNationality = primaryNationality;
		this.city = city;
		this.dateOfUnemployment = dateOfUnemployment;
		this.income = income;
		this.submitted = submitted;
		this.validated = validated;
		this.approved = approved;
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

	public Date getDateOfUnemployment() {
		return dateOfUnemployment;
	}

	public void setDateOfUnemployment(Date dateOfUnemployment) {
		this.dateOfUnemployment = dateOfUnemployment;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getPrimaryNationality() {
		return primaryNationality;
	}
	
	public void setPrimaryNationality(String primaryNationality) {
		this.primaryNationality = primaryNationality;
	}
	
	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Transient
    public String getPhotosImagePath() {
        if (photo == null || id == 0) return null;
         
        return "/user-photos/" + id + "/" + photo;
    }
	
	public float getIncome() {
		return income;
	}
	
	public void setIncome(float income) {
		this.income = income;
	}
	
	public boolean isApproved() {
		return approved;
	}
	
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public boolean isValidated() {
		return validated;
	}
	
	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	
}