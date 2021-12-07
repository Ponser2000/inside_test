package com.github.ponser2000.inside_test.repository.datajpa;

import com.github.ponser2000.inside_test.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrudMessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findByMyUserIdOrderByDateTime(int userId);

}
