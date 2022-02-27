package com.technews.controller;

import com.technews.model.Post;
import com.technews.model.User;
import com.technews.respository.UserRepository;
import com.technews.respository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    @Autowired
    VoteRepository voteRepository;

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        List<User> userList = repository.findAll();
        for(User user : userList) {
            List<Post> postList = user.getPosts();
            for(Post post: postList) {
                post.setVoteCount(voteRepository.countVotesByPostId(post.getId()));
            }
        }
        return userList;
    }

    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        User returnUser = repository.getById(id);
        List<Post> postList = returnUser.getPosts();
        for(Post post : postList) {
            post.setVoteCount(voteRepository.countVotesByPostId(post.getId()));
        }
        return returnUser;
    }

    @PostMapping("/api/users")
    public User addUser(@RequestBody User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt())); //Encrypt password
        repository.save(user);
        return user;
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User tempUser = repository.getById(id);

        if(!tempUser.equals(null)) {
            user.setId(tempUser.getId());
            repository.save(user);
        }
        return user;
    }

    @DeleteMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }

}
