package com.github.ponser2000.inside_test.service;

import com.github.ponser2000.inside_test.model.Message;
import com.github.ponser2000.inside_test.model.MyUser;
import com.github.ponser2000.inside_test.repository.MessageRepository;
import com.github.ponser2000.inside_test.repository.UserRepository;
import com.github.ponser2000.inside_test.security.JWTUtil;
import com.github.ponser2000.inside_test.to.MessageTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;


    public List<MessageTo> getAllMessages(String jwt) {
        String username = jwtUtil.extractUsername(jwt);
        MyUser myUser = userRepository.getByName(username);
        if (myUser == null) {
            return null;
        }

        List<Message> messageList = messageRepository.getAll(myUser.getId());

        List<MessageTo> result = messageList.stream()
                .map(m -> new MessageTo(m.getId(), m.getDateTime(), m.getMessage(), m.getMyUser().getId()))
                .collect(Collectors.toList());

        return result;
    }

    public List<MessageTo> getLastTenMessages(String jwt) {
        String username = jwtUtil.extractUsername(jwt);
        MyUser myUser = userRepository.getByName(username);
        if (myUser == null) {
            return null;
        }

        List<Message> messageList = messageRepository.getAll(myUser.getId());

        List<MessageTo> result = messageList.stream()
                .map(m -> new MessageTo(m.getId(), m.getDateTime(), m.getMessage(), m.getMyUser().getId()))
                .collect(Collectors.toList());

        return result.subList(result.size() - Math.min(result.size(), 10), result.size());
    }


    public List<MessageTo> saveMessage(String jwt, MessageRequest messageRequest) {
        String username = jwtUtil.extractUsername(jwt);
        MyUser myUser = userRepository.getByName(username);

        if (myUser == null || !messageRequest.getName().equals(myUser.getName())) {
            return null;
        }

        if (messageRequest.getMessage().equals("history 10")) {
            return getLastTenMessages(jwt);
        }

        Message message = messageRepository.save(new Message(LocalDateTime.now(), messageRequest.getMessage()), myUser.getId());

        return null;
    }
}
