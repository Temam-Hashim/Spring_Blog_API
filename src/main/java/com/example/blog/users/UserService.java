package com.example.blog.users;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //or use @Component
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers(){

        return userRepository.findAll();

    }


    public void AddUsers(Users users) {
        Optional<Users> email = userRepository.findUsersByEmail(users.getEmail());

        if(email.isPresent()){
                throw new IllegalStateException("Email already Exists");
        }

         userRepository.save(users);
    }

    public void DeleteUsers(Long userId) {
        if(!userRepository.existsById(userId)){
                throw new IllegalStateException("User with Id "+userId+" doesn't exist");
        }
            userRepository.deleteById(userId);

    }

    @Transactional
    public void UpdateUser(Long userId,String name,String email,String mobile) {

        Users users = userRepository.findById(userId)
                .orElseThrow(()->new IllegalStateException("User with Id "+userId+" doesn't exist"));

        if(name!=null && name.length()>0 && !Objects.equals(users.getName(),name)){
            users.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(users.getEmail(),email)){
            if(userRepository.findUsersByEmail(email).isPresent()){
                throw new IllegalStateException("Email Already Exists");
            }
            users.setEmail(email);
        }
        if(mobile!=null && mobile.length()>0 && !Objects.equals(users.getMobile(),mobile)){
            users.setMobile(mobile);
        }
    }

    public Optional<Users> GetUserById(Long userId){
        if(!userRepository.existsById(userId)){
            throw new IllegalStateException("No user found with ID "+userId);
        }
         return userRepository.findById(userId);
    }

}
