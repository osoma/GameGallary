package com.example.demo;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.repo.UserRepo;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepo userRepo;
	
	
}
