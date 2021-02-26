package com.robertbuckley.EventsBeltReviewer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertbuckley.EventsBeltReviewer.models.Event;
import com.robertbuckley.EventsBeltReviewer.models.Message;
import com.robertbuckley.EventsBeltReviewer.models.User;
import com.robertbuckley.EventsBeltReviewer.respositories.EventRepository;
import com.robertbuckley.EventsBeltReviewer.respositories.MessageRepoistory;
import com.robertbuckley.EventsBeltReviewer.respositories.UserRepository;

@Service
public class AllServices {
	@Autowired
	private EventRepository eRepo;
	@Autowired
	private MessageRepoistory mRepo;
	@Autowired
	private UserRepository uRepo;
	
	public AllServices(EventRepository eRepo, MessageRepoistory mRepo, UserRepository uRepo) {
		this.eRepo = eRepo;
		this.mRepo = mRepo;
		this.uRepo = uRepo;
	}
	
	public List<Message> getAllMessages(){
		return this.mRepo.findAll();
		}
	
	public List<Event> getAllEvents(){
		return this.eRepo.findAll();
		}
	
	public List<User> getAllUsers(){
		return this.uRepo.findAll();
		}
	
	public Event getOneEvent(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	public Event createEvent(Event newEvent) {
		return this.eRepo.save(newEvent);
	}
	
	
	public Event updateEvent(Event eventToUpdate) {
		return this.eRepo.save(eventToUpdate);
	}
	
	public void deleteEvent(Long id) {
		this.eRepo.deleteById(id);
	}
	
	public List<User> usersAttendingEvent(){
		return this.usersAttendingEvent();
	}
	
	public void addEventToUser(User user, Event event) {
		List<User> addUserToEvent = event.getUsersAttending();
		addUserToEvent.add(user);
		this.eRepo.save(event);
	}
	
	public void removeEventFromUser(User user, Event event) {
		List<Event> removeEvent = user.getEvent();
		removeEvent.remove(event);
		this.uRepo.save(user);
	}
	
	public void addMessageToEvent(Event event, Message message) {
		List<Message> addMessage = event.getMessages();
		addMessage.add(message);
		this.eRepo.save(event);
	}
	
	public void createMessage(User user, String content, Event event) {
		this.mRepo.save(new Message(user,content, event));
	}
	
	public List<Event> eventsByInState(String state){
		List<Event> inState = this.eRepo.findByState(state);
		return inState;
	}
	
	public List<Event> eventsNotInState(String state){
		List<Event> outOfState = this.eRepo.findByStateIsNot(state);
		return outOfState;
	}
	

}
