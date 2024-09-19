package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Worker;

public interface WorkerService {
	public String insertWorker(Worker worker);
	public String updateWorker(Worker worker);
	public List<Worker> getAllWorkers();
	public Worker getWorkerById(int id);
	public String deleteWorkerByID(int id);
	
}
