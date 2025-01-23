package api_login_user.service;

import api_login_user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api_login_user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel register(UserModel user) {
        user.setPassword(user.getPassword());
        return userRepository.save(user);

    }

    public UserModel login(String email, String password) {
        UserModel user = userRepository.findByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        throw new RuntimeException("Invalid credentials");
    }

}
