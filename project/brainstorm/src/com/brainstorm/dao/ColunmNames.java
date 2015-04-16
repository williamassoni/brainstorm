package com.brainstorm.dao;


public abstract class ColunmNames {
	public static final String[] TABLE_IDEA_COLUNMS = new String[]{TableIdea.CD_IDEA.getColunmName(),TableIdea.DESCRIPTION.getColunmName()};
	
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
