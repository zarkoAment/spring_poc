package hr.asseco.see.poc.springtesting.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import hr.asseco.see.poc.springtesting.persistence.model.CustomerPersistence;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerRest {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private Date created;
	
	public CustomerRest() {
	
	}
	
	public CustomerRest(final CustomerPersistence customerPersistence) {
		this.id = customerPersistence.getId();
		this.name = customerPersistence.getName();
		this.email = customerPersistence.getEmail();
		this.created = customerPersistence.getCreated();
	}
	
	@JsonProperty(value = "id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty(value = "name")
	@NotBlank
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty(value = "email")
	@Email
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty(value = "created")
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
}
