package com.charan.projections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String empName;
    private String desig;
    private Double salary;
    private DeptDTO deptDTO;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class DeptDTO{
       private String deptName;
    }
}

