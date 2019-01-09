package com.book.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PickResponseList {

	private List<PickResponse> pickResponseList;
	
	
	public void setPickResponseList(List<PickResponse> pickResponseList) {
		this.pickResponseList = pickResponseList;
	}
	
	@XmlElement
	public List<PickResponse> getPickResponseList() {
		return pickResponseList;
	}
	
}
