package com.charan.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.charan.entity.Employee;

@FeignClient("Producer")
public interface ProducerClient {
	
	@GetMapping("/emp-api/get/all")
	public Iterable<Employee> findAll();

	@GetMapping("/emp-api/get")
	public Employee findById(@RequestParam Integer id);

	@PostMapping("/emp-api/save")
	public Employee save(@RequestBody Employee emp);
	
	@PostMapping("/emp-api/save/{empId}")
	public Employee save(@PathVariable Integer empId, @RequestBody Employee emp);
}
