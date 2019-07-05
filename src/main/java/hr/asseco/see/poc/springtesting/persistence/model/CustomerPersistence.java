package hr.asseco.see.poc.springtesting.persistence.model;

import hr.asseco.see.poc.springtesting.rest.model.CustomerRest;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

@Entity(name = "customer")
public class CustomerPersistence {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private Date created;
	
	public CustomerPersistence() {
	
	}
	
	public CustomerPersistence(final CustomerRest customerRest) {
		this.name = customerRest.getName();
		this.email = customerRest.getEmail();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name")
	@NotBlank
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Email
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "created_date")
	@CreatedDate
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof CustomerPersistence)) {
			return false;
		}
		CustomerPersistence customerPersistence = (CustomerPersistence) o;
		return Objects.equals(getId(), customerPersistence.getId()) &&
				Objects.equals(getName(), customerPersistence.getName()) &&
				Objects.equals(getEmail(), customerPersistence.getEmail()) &&
				Objects.equals(getCreated(), customerPersistence.getCreated());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getEmail(), getCreated());
	}
	
	@Override
	public String toString() {
		return "CustomerPersistence{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", created=" + created +
				'}';
	}
}
