package th.kmitl.esd.api;

import kmitl.esd.exercise2.model.CustomerDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerControllerTest {

    private CustomerController customerController = new CustomerController();

    /**
     * Test for getting all customers
     */
    @Test
    void getAllCustomers() {
        List<CustomerDTO> customers = customerController.getAllCustomers();

        assertEquals(customers.size(), 10);
    }

    /**
     * Test for create customer
     */
    @Test
    void createCustomer() {
        customerController.createCustomer(new CustomerDTO(7L, "Micky", 50L));

        assertEquals(customerController.getAllCustomers().size(), 5);

        customerController.deleteCustomer(7L);
    }

    /**
     * Test for update customer
     */
    @Test
    void updateCustomer() {
        CustomerDTO customer = customerController.createCustomer(new CustomerDTO(4L, "Micky", 50L));
        customer.setAge(60L);

        CustomerDTO updatedCustomer = customerController.updateCustomer(customer);
        assertEquals(updatedCustomer.getAge(), 50);

        customerController.deleteCustomer(4L);
    }

    /**
     * Test for deleting customer
     */
    @Test
    void deleteCustomer() {
        assertEquals(customerController.getAllCustomers().size(), 6);

        customerController.deleteCustomer(2L);

        assertEquals(customerController.getAllCustomers().size(), 1);

        customerController.createCustomer(new CustomerDTO(1L, "Micky2", 70L));
    }


}