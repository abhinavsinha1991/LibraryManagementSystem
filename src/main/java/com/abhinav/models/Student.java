package com.abhinav.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 * @author abhinav
 *
 */
@Entity
public class Student {

	@TableGenerator(name = "STUDENT_GEN", allocationSize = 1)
	@Id
	private String student_id;
	private String student_name;

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
}

