package com.brainstorm.dao.idea;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.brainstorm.dao.ColunmNames;
import com.brainstorm.dao.SQLiteHelper;

public class IdeaRepository {
	private SQLiteHelper dbHelper;
	private SQLiteDatabase db;
	
	private static final String SCRIPT_DATABASE_DELETE="DROP TABLE IF EXISTS carro";
	private static final String[] SCRIPT_DATABASE_CREATE=new String[]{
		"create table IDEA(_id integer primary key autoincrement,description text);",
	};
	private static final String DATABASE_NAME = "brainstorm";
	private static final int VERSION = 0;
	
	public IdeaRepository(Context ctx){
		dbHelper = new SQLiteHelper(ctx, DATABASE_NAME, VERSION, SCRIPT_DATABASE_CREATE, SCRIPT_DATABASE_DELETE);
		db = dbHelper.getWritableDatabase();
	}
	
	public long save(Idea idea){
		long id = idea.getCdIdea();
		
		if(id==0){
			return insertIntoIdea(idea);
		}
		//atualizar(carro);
		return id;
	}
	
	private long insertIntoIdea(Idea idea) {
		ContentValues values = new ContentValues();
		values.put(ColunmNames.TableIdea.DESCRIPTION.getColunmName(),idea.getDescription());
		return db.insert("IDEA", "", values);
	}
}