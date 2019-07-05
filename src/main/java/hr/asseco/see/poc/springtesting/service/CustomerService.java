package hr.asseco.see.poc.springtesting.service;

import hr.asseco.see.poc.springtesting.persistence.model.CustomerPersistence;
import hr.asseco.see.poc.springtesting.rest.model.CustomerRest;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface CustomerService {
	
	List<CustomerRest> getAllCustomers();
	
	List<CustomerRest> getCustomerByName(@NotBlank final String name);
	
	CustomerRest createNewCustomer(@NotNull final CustomerRest customerRest);
	
	CustomerRest getCustomerById(@NotNull final Long id);
	
	void deleteCustomer(@NotNull final Long id);
	
	CustomerRest updateCustomer(@NotNull final Long id, @NotNull final CustomerRest customerRest);
}
