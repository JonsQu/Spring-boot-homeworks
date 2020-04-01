package fi.tuni.restshadow;

import org.springframework.stereotype.Component;

public class Customer {
    private String name;
    private long id;
    private static long numberOfCustomer = 1;



    public Customer() {
        this.name = "";
        this.id = numberOfCustomer;
        numberOfCustomer++;
    }

    public Customer(String name) {
        this.name = name;
        this.id = numberOfCustomer;
        numberOfCustomer++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
