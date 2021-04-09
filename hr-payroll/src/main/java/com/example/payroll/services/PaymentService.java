package com.example.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payroll.entities.Payment;
import com.example.payroll.entities.Worker;
import com.example.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient feignClient;
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = feignClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(),worker.getDailyIncome(),days);
	}
}
