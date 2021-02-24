package kmitl.esd.exercise2.service;//import kmitl.esd.exercise2.model.CustomerDTO;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
//
///**
// * Web service for customer CRUD operations
// * Produce endpoints as a part of the server API
// * Controller reacts to requests, controls the workflow, and gives a response
// * RESTful webservices -> HTTP method calls
// * Data format for data objects is JSON
// */
//@RestController
//@RequestMapping("/customer")
//public class CustomerService {
//
//    private final AtomicLong counter = new AtomicLong();
//
//    //ToDo test database
//    private static List<CustomerDTO> customers = new ArrayList<>(); //Todo map
//
//    //Todo replace with connection to database
//    static{
//        CustomerDTO customerTom = new CustomerDTO(1L,"Tom", 35L);
//        CustomerDTO customerSuzi = new CustomerDTO(1L,"Suzi", 53L);
//
//        customers.add(customerTom);
//        customers.add(customerSuzi);
//    }
//
//    /**
//     * REST web service endpoint: http://localhost:8080/test?name=Mike
//     * GET (HTTP) method for finding all customer
//     * Example:https://localhost:8080/customer/findall
//     * @return String with Hello, name
//     */
//
//    @GetMapping("/findall")
//    public List<CustomerDTO>  getAllCustomers(){
//        return customers; //Todo use customer service and DB
//    }
//
//    /**
//     * Create a customer
//     * @param customer as a request body
//     * @return the saved version of the customer or null if not succesful
//     */
//    @PostMapping
//    public CustomerDTO createCustomer(CustomerDTO customer){
//        customers.add(customer);
//        return customer;
//    }
//
//    /**
//     * update / modify a customer
//     * @param customer as a req.body
//     * @return the updated customer object or null if not successful
//     */
//
//    @PutMapping
//    public CustomerDTO updateCustomer(CustomerDTO customer){
//        CustomerDTO customerToBeUpdated =  customers.stream().filter(c -> c.getId().equals(customer.getId())).findFirst().get();
//    if (customerToBeUpdated != null) { // exists -> replace
//        customers.remove(customerToBeUpdated);
//    } else {
//        return null; //no customer found for the update
//
//    }
//        customers.add(customer); // ToDo replace the existing customer
//        return customer;
//
//    }
//
//    /**
//     * Delete a customer
//     * @param customerId id for the customer
//     * @return true if deleted ,false if not found
//     */
//
//
//    @DeleteMapping("/{id}")
//    public Boolean deleteCustomer(@PathVariable("id") Long customerId){
//        CustomerDTO customerToBeDeleted =  customers.stream().filter(c -> c.getId().equals(customerId)).findFirst().get();
//            if (customerToBeDeleted != null){
//                customers.remove(customerToBeDeleted);
//                return true;
//            }else {
//                return false;
//            }
//    }
//
//
//}

import kmitl.esd.exercise2.model.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Web service for customer CRUD operations
 * Produce endpoints as a part of the server API
 * Controller reacts to requests, controls the workflow, and gives a response
 * RESTful webservices -> HTTP method calls
 * Data format for data objects is JSON
 */
@RestController
@RequestMapping("/customer")
public class CustomerService {

    /**
     * Singleton service
     */
    public static CustomerService INSTANCE = new CustomerService();


    private final AtomicLong counter = new AtomicLong();

    //ToDo test database
    private static List<CustomerDTO> customers = new ArrayList<>(); //Todo map

    //Todo replace with connection to database
    static{
        CustomerDTO customerTom = new CustomerDTO(1L,"Tom", 35L);
        CustomerDTO customerSuzi = new CustomerDTO(1L,"Suzi", 53L);

        customers.add(customerTom);
        customers.add(customerSuzi);
    }

    /**
     * Private constructor - singleton pattern
     */
    private CustomerService() {}

    /**
     * REST web service endpoint: http://localhost:8080/test?name=Mike
     * GET (HTTP) method for finding all customer
     * Example:https://localhost:8080/customer/findall
     * @return String with Hello, name
     */

    @GetMapping("/findall")
    public List<CustomerDTO>  getAllCustomers(){
        return customers; //Todo use customer service and DB
    }

    /**
     * Create a customer
     * @param customer as a request body
     * @return the saved version of the customer or null if not succesful
     */
    @PostMapping
    public CustomerDTO createCustomer(CustomerDTO customer){
        customers.add(customer);
        return customer;
    }

    /**
     * update / modify a customer
     * @param customer as a req.body
     * @return the updated customer object or null if not successful
     */

    @PutMapping
    public CustomerDTO updateCustomer(CustomerDTO customer){
        CustomerDTO customerToBeUpdated =  customers.stream().filter(c -> c.getId().equals(customer.getId())).findFirst().get();
        if (customerToBeUpdated != null) { // exists -> replace
            customers.remove(customerToBeUpdated);
        } else {
            return null; //no customer found for the update

        }
        customers.add(customer); // ToDo replace the existing customer
        return customer;

    }

    /**
     * Delete a customer
     * @param customerId id for the customer
     * @return true if deleted ,false if not found
     */


    @DeleteMapping("/{id}")
    public Boolean deleteCustomer(@PathVariable("id") Long customerId){
        CustomerDTO customerToBeDeleted =  customers.stream().filter(c -> c.getId().equals(customerId)).findFirst().get();
        if (customerToBeDeleted != null){
            customers.remove(customerToBeDeleted);
            return true;
        }else {
            return false;
        }
    }


}