package com.task.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.app.model.Messages;
import com.task.app.repository.MessagesRepository;

@RestController
@RequestMapping("message")
public class MessagesController 
{
	@Autowired
	private MessagesRepository repo;
	
	@RequestMapping("addMessage")
	public Messages saveMessages(@RequestParam int id,@RequestParam String message)
	{
		Messages msg = new Messages();
		msg.setId(id);
		msg.setMessage(message);
		repo.save(msg);
		return msg;
	}
	
	@GetMapping("getAllMessages")
	public List<Messages> getAllMessages()
	{
		return repo.findAll();
	}
	
	@GetMapping("getMessage")
	public Messages getMessgeById(@RequestParam int id)
	{
		Optional<Messages> op = repo.findById(id);
		Messages msg = op.get();
		return msg;
	}
	
	@GetMapping("deleteMessage")
	public Messages deleteMessgeById(@RequestParam int id)
	{
		Optional<Messages> op = repo.findById(id);
		Messages msg = op.get();
		repo.deleteById(id);
		return msg;
	}
	
	@GetMapping("updateMessage")
	public Messages updateMessgeById(@RequestParam int id,@RequestParam String message)
	{
		Optional<Messages> op = repo.findById(id);
		Messages msg = op.get();
		msg.setMessage(message);
		return msg;
	}
	
	
}
