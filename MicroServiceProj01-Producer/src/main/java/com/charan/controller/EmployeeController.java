package com.charan.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charan.entity.Employee;
import com.charan.projections.EmployeeDTO;
import com.charan.projections.NamesAndDesig;
import com.charan.service.EmployeeService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/producer/emp-api")
@RequiredArgsConstructor
@OpenAPIDefinition(
	info = @Info(
		title = "${openapi.service.title}",
		version = "${openapi.service.version}",
		description = "${openapi.service.description}"
	),
	servers = @Server(
		url = "${openapi.service.url}"
	)
)
public class EmployeeController {

	private final EmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee emp){
		Employee employee = service.save(emp);
		return ResponseEntity.ok(employee);
	}

	@Operation(summary = "Gets all employees", description = "Fetches all employees in the database")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "On Success"),
		@ApiResponse(responseCode = "500", description = "On Failure")
	})
	@GetMapping("/get/all")
	public ResponseEntity<Iterable<Employee>> findAll() {
		Iterable<Employee> list = service.getAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/get")
	public ResponseEntity<Employee> findById(@RequestParam Integer id){
		Employee emp = service.findById(id);
		return ResponseEntity.ok(emp);
	}

	@GetMapping("/get/projection/all")
	public ResponseEntity<List<EmployeeDTO>> findAllprojections() {
		List<EmployeeDTO> list = service.findAllByProjection();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/get/interface-projection/all")
	public ResponseEntity<List<NamesAndDesig>> findAllIntprojections() {
		List<NamesAndDesig> list = service.findAllByInterfaceProjection();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/get/class-projection/all")
	public ResponseEntity<List<EmployeeDTO>> findAllClassprojections() {
		List<EmployeeDTO> list = service.findAllByClassProjection();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/get/dynamic-projection/all/{job}")
	public ResponseEntity<List<?>> findAllDynamicprojections(@PathVariable String job, @RequestParam String type) {
		List<EmployeeDTO> list = service.findAllByJob(job, type);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/save/{empId}")
	public ResponseEntity<Employee> findAllDynamicprojections(@PathVariable Integer empId, @RequestBody Employee emp) {
		emp.setEmpno(empId);
		System.out.println(emp.toString());
		return ResponseEntity.ok(emp);
	}

}
