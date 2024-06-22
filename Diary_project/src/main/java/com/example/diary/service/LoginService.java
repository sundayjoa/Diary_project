package com.example.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary.model.Login;
import com.example.diary.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
    private LoginRepository loginRepository;

    public boolean isIdAvailable(String id) {
        return !loginRepository.existsById(id);
    }

    public boolean isPasswordAvailable(String password) {
        return !loginRepository.existsByPassword(password);
    }

    public String getNameByIdAndPassword(String id, String password) {
        return loginRepository.findNameByIdAndPassword(id, password);
    }

    public void register(Login login) {
        loginRepository.save(login);
    }
}