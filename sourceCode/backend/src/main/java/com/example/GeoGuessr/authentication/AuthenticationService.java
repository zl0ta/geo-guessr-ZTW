package com.example.GeoGuessr.authentication;

import com.example.GeoGuessr.user.User;
import org.springframework.stereotype.Service;

@Service
record AuthenticationService(UserRepository userRepository) {

        public User registerUser(String username, String password) throws UserAlreadyExistsException {
            User user = new User(username, password);
            if(userRepository.findByUsername(username).isPresent()) {
                throw new UserAlreadyExistsException("User " + username + " already exists");
            }
            return userRepository.save(user);
        }

        public User loginUser(String username, String password) {
            return userRepository.findByUsername(username)
                    .filter(user -> user.getPassword().equals(password))
                    .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));
        }
}
