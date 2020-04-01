package fi.tuni.restshadow;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerRepImplemetation implements CustomerRepository {
    private List<Customer> db = new ArrayList<>();
    @Override
    public Customer save(Customer entity) {
        db.add(entity);
        return entity;
    }

    @Override
    public void deleteById(Long aLong) {
        db = db.stream().filter(customer -> customer.getId() != aLong).collect(Collectors.toList());
    }

    @Override
    public Iterable<Customer> findAll() {
        return db;
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        Optional<Customer> tCust = null;
        try {
            tCust = Optional.ofNullable(db.stream().filter(customer -> customer.getId() == aLong).collect(Collectors.toList()).get(0));
        }catch (Exception e){
            e.printStackTrace();
        }
        return tCust;
    }
}
