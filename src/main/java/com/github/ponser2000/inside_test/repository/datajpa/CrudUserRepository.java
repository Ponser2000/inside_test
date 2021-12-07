package com.github.ponser2000.inside_test.repository.datajpa;

import com.github.ponser2000.inside_test.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudUserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findByName(String name);

}
