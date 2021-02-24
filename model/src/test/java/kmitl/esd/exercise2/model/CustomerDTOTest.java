package kmitl.esd.exercise2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDTOTest {

    private CustomerDTO customerDTO;

    /**
     * Prepare customer dto
     */
    @BeforeEach
    void prepareCustomerDTO() {
        this.customerDTO = new CustomerDTO(1L, "Dech", 22L);
    }

    /**
     * check getter and setter that it's work or not
     */
    @Test
    void checkCustomerId() {
        assertEquals(customerDTO.getId(), 1L);
        this.customerDTO.setId(4L);
        assertEquals(customerDTO.getId(), 4L);
    }

    /**
     * check getter and setter for age that it's work or not
     */
    @Test
    void checkCustomerAge() {
        assertEquals(customerDTO.getAge(), 55);
        this.customerDTO.setAge(65L);
        assertEquals(customerDTO.getAge(), 65);
    }

    /**
     * check name of  getter and setter that it's work or not
     */
    @Test
    void checkCustomerName() {
        assertEquals(customerDTO.getName(), "Dech");
        this.customerDTO.setName("DDech");
        assertEquals(customerDTO.getName(), "DDech");
    }

}