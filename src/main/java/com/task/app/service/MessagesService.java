package com.task.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.task.app.model.Messages;
import com.task.app.repository.MessagesRepository;

@Service
public class MessagesService 
{

	@Autowired
	private MessagesRepository repo;
	
	public Messages saveMessages(int id,String message)
	{
		Messages msg = new Messages();
		msg.setId(id);
		msg.setMessage(message);
		repo.save(msg);
		return msg;
	}
	
	public List<Messages> getAllMessages()
	{
		return repo.findAll();
	}
	
	
	public Messages getMessgeById(int id)
	{
		Optional<Messages> op = repo.findById(id);
		Messages msg = op.get();
		return msg;
	}
	

	public Messages deleteMessgeById(int id)
	{
		Optional<Messages> op = repo.findById(id);
		Messages msg = op.get();
		repo.deleteById(id);
		return msg;
	}
	
	
	public Messages updateMessgeById(int id,String message)
	{
		Optional<Messages> op = repo.findById(id);
		Messages msg = op.get();
		msg.setMessage(message);
		return msg;
	}
	
	
}
