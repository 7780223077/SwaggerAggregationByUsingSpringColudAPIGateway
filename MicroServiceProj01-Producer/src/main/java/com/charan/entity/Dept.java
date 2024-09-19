package com.charan.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "DEPT")
public class Dept implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5552076645855870581L;

	@Id
    private Integer deptno;

    private String dname;

    private String loc;
}
