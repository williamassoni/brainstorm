package com.brainstorm.dao.idea;

import java.io.Serializable;

public class Idea implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer cdIdea;
	private String description;

	public Integer getCdIdea() {
		return cdIdea;
	}

	public void setCdIdea(Integer cdIdea) {
		this.cdIdea = cdIdea;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}