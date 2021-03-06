package fi.tuni.restshadow;


import java.util.Optional;

public interface MyCrudRepository<T, ID> {
    public T save(T entity);
    public void deleteById(ID id);
    public Iterable<T> findAll();
    public Optional<T> findById(ID id);
}
