package kmitl.esd.exercise2.service;

import kmitl.esd.exercise2.model.CustomerDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import kmitl.esd.exercise2.model.CustomerDTO;
class CustomerServiceTest {
    private CustomerService service = CustomerService.INSTANCE;

    /**
     * Test for get all customers
     */
    @Test
    void getAllCustomers() {
        List<CustomerDTO> customers = service.getAllCustomers();

        assertEquals(customers.size(), 5);
    }


}