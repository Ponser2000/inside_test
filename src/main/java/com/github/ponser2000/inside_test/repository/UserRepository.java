package com.github.ponser2000.inside_test.repository;

import com.github.ponser2000.inside_test.model.MyUser;

public interface UserRepository {

    MyUser getByName(String name);
}
