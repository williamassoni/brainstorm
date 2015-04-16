package com.brainstorm.dao;

import com.brainstorm.dao.idea.Idea;

public abstract class ColunmNames {
	public enum TableIdea{
		CD_IDEA("cdidea"),
		DESCRIPTION("description");
		
		private String description;
		
		TableIdea(String name){
			this.description=name;
		}
		public String getColunmName(){
			return description;
		}
	}
}
