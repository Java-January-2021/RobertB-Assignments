package com.robertbuckley.EventsBeltReviewer.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robertbuckley.EventsBeltReviewer.models.Message;

@Repository
public interface MessageRepoistory extends CrudRepository<Message, Long>{
	List<Message> findAll();
}
