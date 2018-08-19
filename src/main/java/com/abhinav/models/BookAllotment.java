package com.abhinav.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import java.util.Date;

/**
 * @author abhinav
 *
 */
@Entity
public class BookAllotment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "BOOKALLOT_GEN", allocationSize = 1)
	@Id
	private String allot_id;

	private String book_id;
	private String student_id;
	private Date dateFrom;
	private Date dateTo;
	private boolean isReturned;

	public String getAllot_id() {
		return allot_id;
	}

	public void setAllot_id(String allot_id) {
		this.allot_id = allot_id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean returned) {
		isReturned = returned;
	}

}

