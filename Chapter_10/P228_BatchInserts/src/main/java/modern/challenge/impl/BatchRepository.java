package modern.challenge.impl;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BatchRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    
    <S extends T> S persist(S entity);
    <S extends T> Iterable<S> saveInBatch(Iterable<S> entites);
}
