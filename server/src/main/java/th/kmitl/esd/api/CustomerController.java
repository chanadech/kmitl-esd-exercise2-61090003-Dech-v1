
package th.kmitl.esd.api;

import kmitl.esd.exercise2.model.CustomerDTO;
import kmitl.esd.exercise2.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Web controller
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    /**
     * Function to get all of the customers
     * Can be called using GET method
     *
     * @return list of customers
     */
    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return CustomerService.INSTANCE.getAllCustomers();
    }

    /**
     * Function to create customer
     * Can be called using POST method
     *
     * @return customer
     */
    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customer) {
        return CustomerService.INSTANCE.createCustomer(customer);
    }

    /**
     * Function to update customer
     * Can be called using PUT method
     *
     * @return customer
     */
    @PutMapping
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customer) {
        return CustomerService.INSTANCE.updateCustomer(customer);
    }

    /**
     * Function to delete customer
     * Can be called using DELETE method
     *
     * @param customerId
     * @return boolean - the result of deletion
     */
    @DeleteMapping("/{id}")
    public boolean deleteCustomer(@PathVariable("id") Long customerId) {
        return CustomerService.INSTANCE.deleteCustomer(customerId);
    }
}