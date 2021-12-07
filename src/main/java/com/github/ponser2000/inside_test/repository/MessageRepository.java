package com.github.ponser2000.inside_test.repository;


import com.github.ponser2000.inside_test.model.Message;

import java.util.List;

public interface MessageRepository {

    Message save(Message message, int userId);

    List<Message> getAll(int userId);
}
