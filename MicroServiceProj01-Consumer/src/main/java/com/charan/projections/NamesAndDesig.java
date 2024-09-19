package com.charan.projections;

import org.springframework.beans.factory.annotation.Value;

public interface NamesAndDesig {

	@Value("#{target.ename}")
	String getEmpname();

	@Value("#{target.job}")
	String getDesignation();

	@Value("#{target.sal}")
	Double getSalary();

	@Value("#{target.dept}")
	DeptInfo getDepartment();

	interface DeptInfo {
		@Value("#{target.dname}")
		String getDepartmentName();

		@Value("#{target.loc}")
		String getLoc();

		Integer getDeptno();

		default String getInfo(){
			return getLoc().concat(" ").concat(getDepartmentName());
		}

	}
}

