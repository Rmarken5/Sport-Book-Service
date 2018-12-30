package com.book.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TeamResponseList {

	private List<TeamResponse> responseList;

	public List<TeamResponse> getResponseList() {
		return responseList;
	}

	public void setResponseList(List<TeamResponse> responseList) {
		this.responseList = responseList;
	}
	
	
	
}
