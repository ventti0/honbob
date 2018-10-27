package dto;

public class Res {
    private int res_no;
	private int owner_no;
	private int res_group_no;
	private String res_name;
	private String res_phone;
	private String res_addr1;
	private String res_addr2;
	private String res_busi_hour;
	private int res_total_score;
	private int res_total_score_cnt;
	private int res_alone_score;
	private int res_alone_score_cnt;
	private int can_deliver;
	private int can_park;
	private int can_advance_pay;
	private int can_alone_drink;
	private int capacity;
	private String add_info;
	private int comment_cnt;
	private int activation;
	public int getRes_no() {
		return res_no;
	}
	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}
	public int getOwner_no() {
		return owner_no;
	}
	public void setOwner_no(int owner_no) {
		this.owner_no = owner_no;
	}
	public int getRes_group_no() {
		return res_group_no;
	}
	public void setRes_group_no(int res_group_no) {
		this.res_group_no = res_group_no;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getRes_phone() {
		return res_phone;
	}
	public void setRes_phone(String res_phone) {
		this.res_phone = res_phone;
	}
	public String getRes_addr1() {
		return res_addr1;
	}
	public void setRes_addr1(String res_addr1) {
		this.res_addr1 = res_addr1;
	}
	public String getRes_addr2() {
		return res_addr2;
	}
	public void setRes_addr2(String res_addr2) {
		this.res_addr2 = res_addr2;
	}
	public String getRes_busi_hour() {
		return res_busi_hour;
	}
	public void setRes_busi_hour(String res_busi_hour) {
		this.res_busi_hour = res_busi_hour;
	}
	public int getRes_total_score() {
		return res_total_score;
	}
	public void setRes_total_score(int res_total_score) {
		this.res_total_score = res_total_score;
	}
	public int getRes_total_score_cnt() {
		return res_total_score_cnt;
	}
	public void setRes_total_score_cnt(int res_total_score_cnt) {
		this.res_total_score_cnt = res_total_score_cnt;
	}
	public int getRes_alone_score() {
		return res_alone_score;
	}
	public void setRes_alone_score(int res_alone_score) {
		this.res_alone_score = res_alone_score;
	}
	public int getRes_alone_score_cnt() {
		return res_alone_score_cnt;
	}
	public void setRes_alone_score_cnt(int res_alone_score_cnt) {
		this.res_alone_score_cnt = res_alone_score_cnt;
	}
	public int getCan_deliver() {
		return can_deliver;
	}
	public void setCan_deliver(int can_deliver) {
		this.can_deliver = can_deliver;
	}
	public int getCan_park() {
		return can_park;
	}
	public void setCan_park(int can_park) {
		this.can_park = can_park;
	}
	public int getCan_advance_pay() {
		return can_advance_pay;
	}
	public void setCan_advance_pay(int can_advance_pay) {
		this.can_advance_pay = can_advance_pay;
	}
	public int getCan_alone_drink() {
		return can_alone_drink;
	}
	public void setCan_alone_drink(int can_alone_drink) {
		this.can_alone_drink = can_alone_drink;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getAdd_info() {
		return add_info;
	}
	public void setAdd_info(String add_info) {
		this.add_info = add_info;
	}
	public int getComment_cnt() {
		return comment_cnt;
	}
	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}
	public int getActivation() {
		return activation;
	}
	public void setActivation(int activation) {
		this.activation = activation;
	}
	@Override
	public String toString() {
		return "Res [res_no=" + res_no + ", owner_no=" + owner_no + ", res_group_no=" + res_group_no + ", res_name="
				+ res_name + ", res_phone=" + res_phone + ", res_addr1=" + res_addr1 + ", res_addr2=" + res_addr2
				+ ", res_busi_hour=" + res_busi_hour + ", res_total_score=" + res_total_score + ", res_total_score_cnt="
				+ res_total_score_cnt + ", res_alone_score=" + res_alone_score + ", res_alone_score_cnt="
				+ res_alone_score_cnt + ", can_deliver=" + can_deliver + ", can_park=" + can_park + ", can_advance_pay="
				+ can_advance_pay + ", can_alone_drink=" + can_alone_drink + ", capacity=" + capacity + ", add_info="
				+ add_info + ", comment_cnt=" + comment_cnt + ", activation=" + activation + "]";
	}
	
	
}
