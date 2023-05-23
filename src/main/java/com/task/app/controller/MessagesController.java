package com.task.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.app.model.Messages;
import com.task.app.service.MessagesService;

@RestController
@RequestMapping("message")
public class MessagesController 
{
	@Autowired
	private MessagesService service;
	
	@RequestMapping("addMessage")
	public Messages saveMessages(@RequestParam int id,@RequestParam String message)
	{
		Messages msg = service.saveMessages(id, message);
		return msg;
	}
	
	@GetMapping("getAllMessages")
	public List<Messages> getAllMessages()
	{
		List<Messages> list = service.getAllMessages();
		return list;
	}
	
	@GetMapping("getMessage")
	public Messages getMessgeById(@RequestParam int id)
	{
		Messages msg = service.getMessgeById(id);
		return msg;
	}
	
	@GetMapping("deleteMessage")
	public Messages deleteMessgeById(@RequestParam int id)
	{
		
		Messages msg = service.deleteMessgeById(id);
		return msg;
	}
	
	@GetMapping("updateMessage")
	public Messages updateMessgeById(@RequestParam int id,@RequestParam String message)
	{
		
		Messages msg = service.updateMessgeById(id, message);
		return msg;
	}
	
	
}
