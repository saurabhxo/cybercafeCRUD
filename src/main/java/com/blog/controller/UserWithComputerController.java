package com.blog.controller;

import com.blog.model.Computer;
import com.blog.model.User;
import com.blog.repository.ComputerRepository;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usersWithComputer")
public class UserWithComputerController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ComputerRepository computerRepository;


    private final Object lock = new Object();

    @PostMapping("/assign")
    public ResponseEntity<?> assignUser(@RequestParam Long userId) {
        synchronized (lock) {
            Optional<User> byId = userRepository.findById(userId);
            if (!byId.isPresent()) {
                return ResponseEntity.ok("User Details Not Matched With Database");
            }

            User userValue = byId.get();
            if (userValue.getAssignedComputerId() == 0) {
                List<Computer> listComputer = computerRepository.findByComputerStatus("Free");
                if (!listComputer.isEmpty()) {
                    userValue.setAssignedComputerId(listComputer.get(0).getComputerId());
                    Computer computer = listComputer.get(0);
                    computer.setComputerStatus("Reserved");
                    computerRepository.save(computer);
                    return ResponseEntity.ok("Computer Assigned");
                }
                return ResponseEntity.ok("All Computers Are Busy");
            }

            return ResponseEntity.ok("Already Assigned a Computer");
        }
    }


    @PostMapping("/unassign")
    public ResponseEntity<?> unAssignUser(@RequestParam Long userId) {
        Optional<User> byId = userRepository.findById(userId);
        if(!byId.isPresent()) {
            return ResponseEntity.ok("User Details Not Matched With Db");
        }
        User userValue = byId.get();
        if(userValue.getAssignedComputerId() != 0) {
            Long computerid = userValue.getAssignedComputerId();
            userValue.setAssignedComputerId(0L);
            userRepository.save(userValue);
            Computer findComputer = computerRepository.findById(computerid).orElseThrow(() -> new RuntimeException());
            findComputer.setComputerStatus("Free");
            computerRepository.save(findComputer);
            return ResponseEntity.ok("Computer UnAssigned");
        }
        return ResponseEntity.ok("No Computer Is Assigned To This  User");
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<UserWithComputerResponse>> getAllUsersWithComputers() {
        List<User> users = userRepository.findAll();

        // Create a list to store the response containing user and computer details
        List<UserWithComputerResponse> responseList = new ArrayList<>();

        for (User user : users) {
            UserWithComputerResponse response = new UserWithComputerResponse();
            response.setUser(user);

            // Check if the user has an assigned computer
            if (user.getAssignedComputerId() != 0) {
                Optional<Computer> optionalComputer = computerRepository.findById(user.getAssignedComputerId());
                optionalComputer.ifPresent(response::setComputer);
            }

            responseList.add(response);
        }

        return ResponseEntity.ok(responseList);
    }

}
