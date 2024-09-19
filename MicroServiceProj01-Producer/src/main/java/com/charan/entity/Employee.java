package com.charan.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMP")
@SequenceGenerator(name = "emp_seq", sequenceName = "emp_sequence", initialValue = 8724, allocationSize = 10)
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3269624669786186198L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	private Integer empno;
	
	private String ename;
	
	private String job;
	
	private Integer mgr;
	
	private LocalDate hiredate;
	
	private Double sal;
	
	private Double comm;
	
	@ManyToOne(targetEntity = Dept.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "deptno", referencedColumnName = "deptno")
	private Dept dept;
}
