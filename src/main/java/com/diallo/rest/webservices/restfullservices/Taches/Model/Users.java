package com.diallo.rest.webservices.restfullservices.Taches.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Users {



    @Id
    @GeneratedValue
    @Column
    private Long idUser;

   // @NotEmpty(message = "Last name cannot be empty")
    private String lastname;
    
    @Column
    //@NotEmpty(message = " First name cannot be empty")
    private String firstname;

    /*@Past(message = "Date of be must be in the past ")
    @NotNull(message = "Date of b must be specified")
    private LocalDate dob;*/
    @Column
   // @Email(message = "Email name cannot be empty")
   // @NotEmpty(message = "email cannot be empty")
    private String email;
    
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="user" )
    private List<Todo> commands = new ArrayList<>();

	public Long getId() {
		return idUser;
	}

	public void setId(Long id) {
		this.idUser = id;
	}

	public Users( String lastname,
			String firstname, String email) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
	}



	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + idUser + ", lastname=" + lastname + ", firstname=" + firstname + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, idUser, lastname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(idUser, other.idUser) && Objects.equals(lastname, other.lastname);
	}
	
    //@DecimalMin(value = "1000.00", message = "Salary must be a least 1000.00")
    //@NotNull(message = "Salary of b must be specified")
    // private BigDecimal salary;


   
}