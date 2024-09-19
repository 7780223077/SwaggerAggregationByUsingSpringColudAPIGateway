package com.charan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.charan.entity.Employee;
import com.charan.projections.EmployeeDTO;
import com.charan.projections.NamesAndDesig;
import com.charan.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepo;

	@Override
	public Iterable<Employee> getAll() {
		return employeeRepo.findAll();
	}

	@Override
	public List<EmployeeDTO> findAllByProjection() {
		 List<Object[]> list = employeeRepo.findAllByProjection();
		 List<EmployeeDTO> listOfDto = new ArrayList<>();
		 for(Object[] obj : list) {
			 String name = (String) obj[0];
	         String job = (String) obj[1];
	         Double salary = ((Number) obj[2]).doubleValue(); // Safely cast to Double
			 listOfDto.add(new EmployeeDTO(name, job, salary, null));
		 }
		 return listOfDto;
	}

	@Override
	public List<NamesAndDesig> findAllByInterfaceProjection() {
		return employeeRepo.findAllByInterfaceProjection();
	}

	@Override
	public List<EmployeeDTO> findAllByClassProjection() {
		return employeeRepo.findAllByClassProjection();
	}

	@Override
	public List<?> findAllByJob(String job, String type) {
		if(type.equalsIgnoreCase("FULL"))
			return employeeRepo.findByJobIgnoreCase(job, Employee.class);
		return employeeRepo.findByJobIgnoreCase(job, NamesAndDesig.class);
	}

	@Override
	public Employee findById(Integer id) {
		return employeeRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Employee not found"));
	}

	@Override
	public Employee save(Employee emp) {
		return employeeRepo.save(emp);
	}

}
