package com.charan.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3269624669786186198L;

	private Integer empno;
	
	private String ename;
	
	private String job;
	
	private Integer mgr;
	
	private LocalDate hiredate;
	
	private Double sal;
	
	private Double comm;
	
	private Dept dept;
}
