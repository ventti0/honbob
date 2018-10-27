package dto;

import java.sql.Date;

public class Order {
    private int order_no;
    private String mem_name;
    private String res_name;
    private String menu_name;
    private int quantity;
    private int order_sum;
    private int owner_check;
	private Date pay_time;
	
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrder_sum() {
		return order_sum;
	}
	public void setOrder_sum(int order_sum) {
		this.order_sum = order_sum;
	}
	public int getOwner_check() {
		return owner_check;
	}
	public void setOwner_check(int owner_check) {
		this.owner_check = owner_check;
	}
	public Date getPay_time() {
		return pay_time;
	}
	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}
	
	@Override
	public String toString() {
		return "Order [order_no=" + order_no + ", mem_name=" + mem_name + ", res_name=" + res_name + ", menu_name="
				+ menu_name + ", quantity=" + quantity + ", order_sum=" + order_sum + ", owner_check=" + owner_check
				+ ", pay_time=" + pay_time + "]";
	}
	
	
    
    
    
}
