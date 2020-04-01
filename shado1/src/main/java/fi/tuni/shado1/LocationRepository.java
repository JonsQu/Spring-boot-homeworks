package fi.tuni.shado1;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Integer> {
    public Iterable<Location> findByLatitudeOrderByLongitudeDesc(double latitude);
}
