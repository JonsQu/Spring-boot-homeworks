package fi.tuni.shado1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Shado1Application implements CommandLineRunner {

    @Autowired
    LocationRepository locationRepository;

    public static void main(String[] args) {
        SpringApplication.run(Shado1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Save new location
        locationRepository.save(new Location(66,66));
        locationRepository.save(new Location(122, 50));
        locationRepository.save(new Location(112, 70));
        locationRepository.save(new Location(102, 90));
        // Retrieve new location
        //Optional<Location> loc = locationRepository.findById(1);
        // If found, print it
        //loc.ifPresent(System.out::println);
        //Iterable<Location> foundLoc = locationRepository.findByLatitudeOrderByLongitudeDesc(5);
        locationRepository.findAll().forEach(System.out::println);
    }
}

    /*
    @Autowired
    EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(Shado1Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Store location object
        entityManager.persist(new Location(5,5));
        // Fetch location object based on id 1
        Location obj = entityManager.find(Location.class, 1);
        System.out.println(obj);
    }
}

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Shado1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("CREATE TABLE locations(id int, lat double, lon double)");
        jdbcTemplate.update("INSERT INTO locations values(1, 60.0, 60.0)");


        List<Location> locations = jdbcTemplate.query("SELECT * FROM locations",
                (result, rowNum) -> {
                    Location loc = new Location(result.getInt("id"),
                            result.getDouble("lat"),
                            result.getDouble("lon"));
                    return loc;
                });

        locations.forEach(System.out::println);
    }
}*/

