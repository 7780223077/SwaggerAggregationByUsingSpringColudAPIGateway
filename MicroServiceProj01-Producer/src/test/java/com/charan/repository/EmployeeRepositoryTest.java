package com.charan.repository;

import com.charan.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import java.time.LocalDate;

@DataJpaTest
@ActiveProfiles("test")
// We don't want the H2 in-memory database
// We will provide a custom `test container` as DataSource, don't replace it.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepo;

    private Employee employee;

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)// Prevents automatic rollback
            public void testSaveEmployee() {
        employee = Employee.builder()
                .ename("CHARANREDDY")
                .job("JAVA DEVELOPER")
                .mgr(2593)
                .hiredate(LocalDate.now())
                .comm(20.0)
                .build();

        Employee saveEmployee = employeeRepo.save(employee);

        System.out.println(saveEmployee);
        Assertions.assertNotNull(saveEmployee);
        Assertions.assertEquals("CHARANREDDY", saveEmployee.getEname());

    }

}
