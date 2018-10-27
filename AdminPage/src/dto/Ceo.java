package dto;

import java.util.Date;

public class Ceo {
	private int mem_no;
	private int mem_group_no;
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String mem_nick;
	private Date mem_birth;
	private int mem_gen;
	private String mem_phone;
	private String mem_addr1;
	private String mem_addr2;
	private int mem_point;
	private int mem_acc_point;
	private int mem_grade;
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public int getMem_group_no() {
		return mem_group_no;
	}
	public void setMem_group_no(int mem_group_no) {
		this.mem_group_no = mem_group_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_nick() {
		return mem_nick;
	}
	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	public Date getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}
	public int getMem_gen() {
		return mem_gen;
	}
	public void setMem_gen(int mem_gen) {
		this.mem_gen = mem_gen;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_addr1() {
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public int getMem_point() {
		return mem_point;
	}
	public void setMem_point(int mem_point) {
		this.mem_point = mem_point;
	}
	public int getMem_acc_point() {
		return mem_acc_point;
	}
	public void setMem_acc_point(int mem_acc_point) {
		this.mem_acc_point = mem_acc_point;
	}
	public int getMem_grade() {
		return mem_grade;
	}
	public void setMem_grade(int mem_grade) {
		this.mem_grade = mem_grade;
	}
	@Override
	public String toString() {
		return "Ceo [mem_no=" + mem_no + ", mem_group_no=" + mem_group_no + ", mem_id=" + mem_id + ", mem_pw=" + mem_pw
				+ ", mem_name=" + mem_name + ", mem_nick=" + mem_nick + ", mem_birth=" + mem_birth + ", mem_gen="
				+ mem_gen + ", mem_phone=" + mem_phone + ", mem_addr1=" + mem_addr1 + ", mem_addr2=" + mem_addr2
				+ ", mem_point=" + mem_point + ", mem_acc_point=" + mem_acc_point + ", mem_grade=" + mem_grade + "]";
	}
	
	
}
