package com.charan.repository;

import java.util.List;

import com.charan.projections.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.charan.entity.Employee;
import com.charan.projections.NamesAndDesig;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT e.ename AS ename, e.job AS job, e.sal As sal FROM Employee e")
	public List<Object[]> findAllByProjection();

	@Query("SELECT e.ename AS ename, e.job AS job, e.sal AS sal, e.dept AS dept FROM Employee e")
	public List<NamesAndDesig> findAllByInterfaceProjection();

	@Query("SELECT new com.charan.projections.EmployeeDTO(e.ename, e.job , e.sal, new com.charan.projections.EmployeeDTO$DeptDTO(e.dept.dname)) FROM Employee e")
	public List<EmployeeDTO> findAllByClassProjection();

	public <T> List<T> findByJobIgnoreCase(String job, Class<T> type);

}
