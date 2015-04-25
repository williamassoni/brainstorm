package com.brainstorm.converter;

import com.brainstorm.dao.idea.Idea;

public class IdeaConverter {
	private static final String NEW_LINE= "\n";
	
	public static String convertIdeaToString(Idea id){
		StringBuilder ideiaString = new StringBuilder();
		
		ideiaString.append("Codigo:").append(id.getCdIdea()).append(NEW_LINE);
		ideiaString.append("Description:").append(id.getDescription()).append(NEW_LINE);
		
		return ideiaString.toString();
	}
}