package kmitl.esd.exercise2.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Customer model
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerDTO implements Serializable {
    private Long id;
    private String name;
    private Long age;
    private String remark;

    /**
     * Constructor to create model
     *
     * @param id of the customer
     * @param name of the customer
     * @return void
     */
    public CustomerDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public CustomerDTO(long id, String name,Long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * Function to print details of the customer
     *
     * @return string customer details
     */
    @Override
    public String toString() {
        return Long.toString(id)+ "," + name + " ," + age;
    }
}