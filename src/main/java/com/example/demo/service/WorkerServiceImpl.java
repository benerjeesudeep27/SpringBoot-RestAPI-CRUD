package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Worker;
import com.example.demo.repository.WorkerDao;

@Service
public class WorkerServiceImpl implements WorkerService{

	@Autowired
	private WorkerDao dao;
	@Override
	public String insertWorker(Worker worker) {
		String status = null;
		Worker work =dao.save(worker);
		if(work != null) {
			status = "Worker Inserted";
		}else {
			status = "Error Occured";
		}
		return status;
	}

	@Override
	public String updateWorker(Worker worker) {
		String status = null;
		Worker work =dao.save(worker);
		if(work != null) {
			status = "Worker Updated";
		}else {
			status = "Error Occured";
		}
		return status;
	}

	@Override
	public List<Worker> getAllWorkers() {
		List<Worker> list =  dao.findAll();
		return list;
	}

	@Override
	public Worker getWorkerById(int id) {
		Optional<Worker> worker = dao.findById(id);
		return worker.get();
	}

	@Override
	public String deleteWorkerByID(int id) {
		String msg = "Error Occured";
		try{
			dao.deleteById(id);
			msg= "Worker Deleted Successfully";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
