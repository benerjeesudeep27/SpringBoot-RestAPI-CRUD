package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Worker;
import com.example.demo.service.WorkerServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MyController {
	@Autowired
	private WorkerServiceImpl serviceImpl;
	@PostMapping("/data")
	public String insertDataInDB(@RequestBody Worker worker) {
		String status = serviceImpl.insertWorker(worker);
		return status;
	}
	@PutMapping("/data")
	public String updateDataInDB(@RequestBody Worker worker) {
		String status = serviceImpl.updateWorker(worker);
		return status;
	}
	@GetMapping("/data")
	public List<Worker> getDataInDB() {
		List<Worker> list = serviceImpl.getAllWorkers();
		return list;
	}
	@GetMapping("/data/{id}")
	public Worker getDataInDB(@PathVariable int id) {
		Worker worker =  serviceImpl.getWorkerById(id);
		return worker;
	}
	@DeleteMapping("/data/{id}")
	public String deleteWorkerById(@PathVariable int id) {
		String msg = "Error Occured";
		try {
			serviceImpl.deleteWorkerByID(id);
			msg = "Worker Deleted Successfully";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}
