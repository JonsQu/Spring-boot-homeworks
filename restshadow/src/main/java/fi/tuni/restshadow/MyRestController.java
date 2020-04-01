package fi.tuni.restshadow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
public class MyRestController {

    @Autowired
    CustomerRepository database;
    @PostConstruct
    public void init(){

    }
    @RequestMapping(value="/customers", method = RequestMethod.GET)
    public Iterable<Customer> getCustomers(){
        System.out.println("getLocations");
        return database.findAll();
    }
    @RequestMapping(value="/customers/{userID}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable int userID){
        System.out.println("getLocation/id");
        Optional<Customer> tCust = database.findById((long) userID);
        if(tCust.isPresent()){
            return tCust.get();
        }
        return null;
    }
    @RequestMapping(value="/customers/{userID}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int userID){
        System.out.println("deleteLocation");
        database.deleteById((long) userID);
    }
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<Void> saveCustomer(@RequestBody Customer c, UriComponentsBuilder b){
        System.out.println("saveLocation");
        database.save(c);

        UriComponents uriComponents =
                b.path("/customers/{id}").buildAndExpand(c.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
