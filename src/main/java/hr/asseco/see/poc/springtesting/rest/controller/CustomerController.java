package hr.asseco.see.poc.springtesting.rest.controller;

import hr.asseco.see.poc.springtesting.rest.model.CustomerRest;
import hr.asseco.see.poc.springtesting.service.CustomerService;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerRest>> getAllCustomers() {
		List<CustomerRest> customerRestList = this.customerService.getAllCustomers();
		
		return new ResponseEntity<List<CustomerRest>>(customerRestList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerRest>> getAllCustomersWithName(@RequestParam("user-name") @NotBlank final String name) {
		List<CustomerRest> customerRestList = this.customerService.getCustomerByName(name);
		
		return new ResponseEntity<List<CustomerRest>>(customerRestList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public ResponseEntity<CustomerRest> createNewCustomer(@RequestBody @NotNull final CustomerRest customerRest) {
		CustomerRest createdCustomerRest = this.customerService.createNewCustomer(customerRest);
		
		return new ResponseEntity<CustomerRest>(createdCustomerRest, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerRest> getCustomerById(@PathVariable @NotNull final Long id) {
		CustomerRest customerRest = this.customerService.getCustomerById(id);
		
		return new ResponseEntity<CustomerRest>(customerRest, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable @NotNull final Long id) {
		this.customerService.deleteCustomer(id);
	}
	
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CustomerRest> updateCustomer(@PathVariable @NotNull final Long id, @RequestBody @NotNull final CustomerRest customerRest) {
		CustomerRest updatedCustomerRest = this.customerService.updateCustomer(id, customerRest);
		
		return new ResponseEntity<CustomerRest>(updatedCustomerRest, HttpStatus.OK);
	}
}
