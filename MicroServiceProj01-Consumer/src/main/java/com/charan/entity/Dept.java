package com.charan.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dept implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5552076645855870581L;

    private Integer deptno;

    private String dname;

    private String loc;
}
