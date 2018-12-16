package com.book.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScheduleResponseList {

	private List<ScheduleResponse> list;

	public List<ScheduleResponse> getList() {
		return list;
	}

	public void setList(List<ScheduleResponse> list) {
		this.list = list;
	}
	
	
	
}
