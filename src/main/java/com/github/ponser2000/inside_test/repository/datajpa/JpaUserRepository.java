package com.github.ponser2000.inside_test.repository.datajpa;

import com.github.ponser2000.inside_test.model.MyUser;
import com.github.ponser2000.inside_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepository implements UserRepository {

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Override
    public MyUser getByName(String name) {
        return crudUserRepository.findByName(name);
    }
}
