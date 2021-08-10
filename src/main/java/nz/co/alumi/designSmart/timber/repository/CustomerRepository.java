package nz.co.alumi.designSmart.timber.repository;

import nz.co.alumi.designSmart.timber.document.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
}