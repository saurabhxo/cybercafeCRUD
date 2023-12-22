package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Long>{
	List<Computer> findByComputerStatus(String computerStatus);

}
