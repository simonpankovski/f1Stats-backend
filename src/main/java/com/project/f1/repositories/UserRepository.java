package com.project.f1.repositories;

import com.project.f1.domain.Constructor;
import com.project.f1.domain.Driver;
import com.project.f1.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User getById(Long id);
    User findByUsername(String username);
    @Query(value="select u.driverSet from User u where u.id=?1")
    List<?> getDriverSet(Long id);
    @Query(value="select u.constructor from User u where u.id=?1")
    Constructor getConstructorByUserId(Long id);

}
