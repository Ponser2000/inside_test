package com.github.ponser2000.inside_test.repository.datajpa;

import com.github.ponser2000.inside_test.model.Message;
import com.github.ponser2000.inside_test.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaMessageRepository implements MessageRepository {

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Autowired
    private CrudMessageRepository crudMessageRepository;

    @Override
    public Message save(Message message, int userId) {
        message.setUser(crudUserRepository.getById(userId));
        return crudMessageRepository.save(message);
    }

    @Override
    public List<Message> getAll(int userId) {
        return crudMessageRepository.findByMyUserIdOrderByDateTime(userId);
    }
}
