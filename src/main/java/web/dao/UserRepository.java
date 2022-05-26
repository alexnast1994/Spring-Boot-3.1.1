package web.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    void deleteById(Long id);

    List<User> findAll();

    Optional<User> getUserById(Long id);




}
