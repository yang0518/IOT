package com.stylefeng.guns.modular.system.model;

import java.util.List;
import java.util.Map;

public class BaseRspBean {
	private String respCode;
	private String respDes;
	private Date date;
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespDes() {
		return respDes;
	}
	public void setRespDes(String respDes) {
		this.respDes = respDes;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public static class  Date{
		private String pageNumber;
		private String lastPage;
		private List<Map<String,Object>> devices;
		
		public String getPageNumber() {
			return pageNumber;
		}
		public void setPageNumber(String pageNumber) {
			this.pageNumber = pageNumber;
		}
		public String getLastPage() {
			return lastPage;
		}
		public void setLastPage(String lastPage) {
			this.lastPage = lastPage;
		}
		public List<Map<String, Object>> getDevices() {
			return devices;
		}
		public void setDevices(List<Map<String, Object>> devices) {
			this.devices = devices;
		}
		
		
		
	}
	

}
