package com.example.transaction.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;

import com.example.transaction.exeption.UserSaveException;
import com.example.transaction.model.User;
import com.example.transaction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements ServiceCRUD<User, Long> {

	private final UserRepository repository;

	@Transactional2(message = "Test")
	private String message;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findByID(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("User is id = [{%s}] not found", id)));
	}

	@Override
	public void save(User object) {
		log.info("Message {} ", message);
		repository.save(object);
		throw new UserSaveException("Error");
	}

	@Override
	public void delete(User object) {
		repository.deleteByLogin(object.getLogin());
	}

	@Override
	public void deleteByID(Long id) {
		repository.deleteById(id);
	}

	@PostConstruct
	public void init() {
		System.out.println(2);
	}
}
