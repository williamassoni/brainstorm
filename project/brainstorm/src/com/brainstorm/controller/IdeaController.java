package com.brainstorm.controller;

import java.util.List;

import android.content.Context;

import com.brainstorm.dao.idea.Idea;
import com.brainstorm.dao.idea.IdeaRepository;

public class IdeaController {
	private IdeaRepository repository;
	
	public IdeaController(Context context){
		this.repository = new IdeaRepository(context);
	}
	
	/**
	 * save or update new idea.
	 * 
	 * return the key to entity IDEA
	 * */
	public long save(Idea idea){
		if(idea.getCdIdea() == null){
			return this.repository.insert(idea);
		}
		
		return this.repository.update(idea);
	}
	
	/**
	 * return all ideia 
	 * */
	public List<Idea> findAllIdea(){
		return this.repository.findAllIdea();
	}
	
}
