package com.challenge.user.service;

import com.challenge.api.security.model.JwtResponse;
import com.challenge.api.security.service.CipherService;
import com.challenge.api.security.service.JwtTokenHelper;
import com.challenge.user.model.User;
import com.challenge.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class UserServiceHandler implements UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    JwtTokenHelper jwtTokenHelper;
    @Autowired
    CipherService cipherService;

    @Override
    public JwtResponse login(User model) {
        JwtResponse response = new JwtResponse();
        response.setAccess(Boolean.FALSE);
        response.setUser(model);

        User dbUser = repository.findByLogin(model.getLogin());

        if (dbUser == null) {
            return response;
        }

        String password = cipherService.encrypt(model.getPassword());
        String dbPassword = dbUser.getPassword();

        if (password.equalsIgnoreCase(dbPassword)) {
            String token = jwtTokenHelper.generateToken(dbUser.getEmail());

            dbUser.setPassword("**********");
            response.setAccess(Boolean.TRUE);
            response.setUser(dbUser);
            response.setToken(token);
        }

        return response;
    }

    @Override
    public User save(User model) throws Exception {
        User dbUser = repository.findByLogin(model.getLogin());
        if (dbUser != null) {
            throw new RuntimeException("User with login " + model.getLogin() + " already exist");
        }
        String password = cipherService.encrypt(model.getPassword());
        model.setPassword(password);
        return repository.save(model);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseGet(User::new));
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(User t) {
        repository.delete(t);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}
