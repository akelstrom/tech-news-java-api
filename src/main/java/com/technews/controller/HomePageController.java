package com.technews.controller;

import com.technews.model.Post;
import com.technews.model.User;
import com.technews.respository.CommentRepository;
import com.technews.respository.PostRepository;
import com.technews.respository.UserRepository;
import com.technews.respository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomePageController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        if(request.getSession(false) != null) {
            return "redirect:/";
        }

        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/users/logout")
    public String logout(HttpServletRequest request) {
        if(request.getSession(false) != null) {
            request.getSession().invalidate();
        }
        return "redirect:/login";
    }

    @GetMapping("/")
    public String homepageSetup(Model model, HttpServletRequest request) {
        User sessionUser = new User();

        if(request.getSession(false) != null) {
            sessionUser = (User) request.getSession().getAttribute("SESSION_USER");
            model.addAttribute("loggedIn", false);
        }

        List<Post> postList = postRepository.findAll();
        for(Post post : postList) {
            post.setVoteCount(voteRepository.countVotesByPostId(post.getId()));
            User user = userRepository.getById(post.getUserId());
            post.setUserName(user.getUsername());
        }

        model.addAttribute("postList", postList);
        model.addAttribute("loggedIn", sessionUser.isLoggedIn());
        model.addAttribute("point", "point");
        model.addAttribute("points", "points");

        return "homepage";
    }
}
