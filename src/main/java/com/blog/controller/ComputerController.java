package com.blog.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.Computer;
import com.blog.repository.ComputerRepository;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    ComputerRepository computerRepository;

    @PostMapping("/create")
    public ResponseEntity<Computer> createNewComputer(@RequestBody Computer computer) {
        return ResponseEntity.ok(computerRepository.save(computer));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Computer>> getAllComputers() {
        return new ResponseEntity<>(computerRepository.findAll(), HttpStatus.OK);
    }
}
