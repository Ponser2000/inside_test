package com.github.ponser2000.inside_test.controller;


import com.github.ponser2000.inside_test.service.MessageRequest;
import com.github.ponser2000.inside_test.service.MessageService;
import com.github.ponser2000.inside_test.to.MessageTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    public ResponseEntity<List<MessageTo>> message(HttpServletRequest request, @RequestBody MessageRequest messageRequest) {
        final String authorizationHeader = request.getHeader("Authorization");

        String jwt = null;
        List<MessageTo> result = new ArrayList<>();

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            result = messageService.saveMessage(jwt, messageRequest);

        }
        return ResponseEntity.ok().body(result);
    }

}
