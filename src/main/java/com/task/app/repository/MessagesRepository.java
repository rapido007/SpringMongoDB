package com.task.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.task.app.model.Messages;

public interface MessagesRepository extends MongoRepository<Messages, Integer>
{

}
