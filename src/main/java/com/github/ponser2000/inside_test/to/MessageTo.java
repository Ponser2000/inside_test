package com.github.ponser2000.inside_test.to;

import java.time.LocalDateTime;

public class MessageTo {
    int id;
    LocalDateTime dateTime;
    String message;
    int user_id;

    public MessageTo(int id, LocalDateTime dateTime, String message, int user_id) {
        this.id = id;
        this.dateTime = dateTime;
        this.message = message;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "MessageTo{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", message='" + message + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
