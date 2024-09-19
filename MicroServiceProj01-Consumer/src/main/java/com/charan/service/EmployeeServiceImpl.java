package com.charan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.charan.client.ProducerClient;
import com.charan.entity.Employee;
import com.charan.projections.EmployeeDTO;
import com.charan.projections.NamesAndDesig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final ProducerClient client;

	@Override
	public Iterable<Employee> getAll() {
		return client.findAll();
	}

	@Override
	public List<EmployeeDTO> findAllByProjection() {
		 return null;
	}

	@Override
	public List<NamesAndDesig> findAllByInterfaceProjection() {
		return null;
	}

	@Override
	public List<EmployeeDTO> findAllByClassProjection() {
		return null;
	}

	@Override
	public List<?> findAllByJob(String job, String type) {
		return null;
	}

	//
	@Override
	public Employee findById(Integer id) {
		return client.findById(id);
	}

	@Override
	public Employee save(Employee emp) {
		return client.save(emp);
	}

	@Override
	public Employee save(Integer empId, Employee emp) {
		return client.save(empId, emp);
	}

}
