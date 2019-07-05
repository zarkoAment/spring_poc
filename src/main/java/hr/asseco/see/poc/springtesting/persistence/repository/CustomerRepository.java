package hr.asseco.see.poc.springtesting.persistence.repository;

import hr.asseco.see.poc.springtesting.persistence.model.CustomerPersistence;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerPersistence, Long> {
	
	List<CustomerPersistence> findByName(final String name);
}
