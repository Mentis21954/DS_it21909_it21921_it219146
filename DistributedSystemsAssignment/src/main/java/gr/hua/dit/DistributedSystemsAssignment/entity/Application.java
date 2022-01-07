package gr.hua.dit.DistributedSystemsAssignment.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="application")
public class Application {
	//check how to add foreign keys
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="city_of_residence")
	private String city;
	
	@Column(name="AFM")
	private String AFM;
	
	@Column(name="AMKA")
	private String AMKA;
	
	@Column(name="date_of_birth")
	private Date birthDate;
	
	@Column(name="id_number")
	private String idNumber;
	
	@Column(name="primary_nationality")
	private String primaryNationality;
	
	@Column(name="marital_status")
	private String maritalStatus;
	
	@Column(name="income")
	private float income;
	
	@Column(name="approved")
	private boolean approved;
	
	@Column(name="validated")
	private boolean validated;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_applicant")
    private Citizen citizen;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_validator")
    private EmployeeOAED employeeOAED;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_authorizer")
    private EmployeeOASA employeeOASA;
	
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
	
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	
	public Citizen getCitizen() {
        return citizen;
	}

	public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
	}

	public EmployeeOAED getEmployeeOAED() {
		return employeeOAED;
	}

	public void setEmployeeOAED(EmployeeOAED employeeOAED) {
		this.employeeOAED = employeeOAED;
	}

	public EmployeeOASA getEmployeeOASA() {
		return employeeOASA;
	}

	public void setEmployeeOASA(EmployeeOASA employeeOASA) {
		this.employeeOASA = employeeOASA;
	}
	
	public Application() {
		
	}
	
	public Application(int id, String city, String aFM, String aMKA, Date birthDate, String idNumber,
			String primaryNationality, String maritalStatus, float income, boolean approved, boolean validated,
			int idApplicant, int id_validator, int idAuthorizer) {
		super();
		this.id = id;
		this.city = city;
		AFM = aFM;
		AMKA = aMKA;
		this.birthDate = birthDate;
		this.idNumber = idNumber;
		this.primaryNationality = primaryNationality;
		this.maritalStatus = maritalStatus;
		this.income = income;
		this.approved = approved;
		this.validated = validated;
	}
	
}
