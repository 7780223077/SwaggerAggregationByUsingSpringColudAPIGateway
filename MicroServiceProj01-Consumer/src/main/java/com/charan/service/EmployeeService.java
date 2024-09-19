package com.charan.service;

import java.util.List;

import com.charan.entity.Employee;
import com.charan.projections.EmployeeDTO;
import com.charan.projections.NamesAndDesig;

public interface EmployeeService {
	public Iterable<Employee> getAll();
	public List<EmployeeDTO> findAllByProjection();
	public List<NamesAndDesig> findAllByInterfaceProjection();
	public List<EmployeeDTO> findAllByClassProjection();
	public <T> List<T>  findAllByJob(String job, String type);
	
	public Employee findById(Integer id);
	public Employee save(Integer empId, Employee emp);
	Employee save(Employee emp);
}
