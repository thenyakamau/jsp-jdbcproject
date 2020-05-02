/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.students;

public class Students {

	private int id;
	private String reg_no;
	private String fname;
	private String lname;
	private String email;
	private String gender;
	private String number;
	private String password;
	
	
	public Students(int id, String reg_no, String fname, String lname, String email, String gender, String number,
			String password) {
		super();
		this.id = id;
		this.reg_no = reg_no;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.number = number;
		this.password = password;
	}
	
	
	public Students(String reg_no, String fname, String lname, String email, String gender, String number,
			String password) {
		super();
		this.reg_no = reg_no;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.number = number;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}