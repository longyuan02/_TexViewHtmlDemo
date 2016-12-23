package com.android.ui;

import java.io.Serializable;

public class InputFund implements Serializable{
	private String fund_name;//基金名称
	private String fund_id;//基金Id
	private String fund_money_type;//基金类型
	private String code;//基金代码
	public InputFund() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFund_name() {
		return fund_name;
	}
	public void setFund_name(String fund_name) {
		this.fund_name = fund_name;
	}
	public String getFund_id() {
		return fund_id;
	}
	public void setFund_id(String fund_id) {
		this.fund_id = fund_id;
	}
	public String getFund_money_type() {
		return fund_money_type;
	}
	public void setFund_money_type(String fund_money_type) {
		this.fund_money_type = fund_money_type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
