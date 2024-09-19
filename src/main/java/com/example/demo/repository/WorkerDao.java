package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Worker;
@Repository
public interface WorkerDao extends JpaRepository<Worker, Integer>{
	
}
