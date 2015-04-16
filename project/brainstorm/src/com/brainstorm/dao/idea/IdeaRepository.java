package com.brainstorm.dao.idea;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.brainstorm.dao.ColunmNames;
import com.brainstorm.dao.ColunmNames.TableIdea;
import com.brainstorm.dao.SQLiteHelper;

public class IdeaRepository {
	private SQLiteHelper dbHelper;
	private SQLiteDatabase db;
	
	private static final String SCRIPT_DATABASE_DELETE="DROP TABLE IF EXISTS IDEA";
	private static final String[] SCRIPT_DATABASE_CREATE=new String[]{
		"create table IDEA(cdidea integer primary key autoincrement,description text);",
	};
	private static final String DATABASE_NAME = "brainstorm";
	private static final int VERSION = 3;
	
	public IdeaRepository(Context ctx){
		dbHelper = new SQLiteHelper(ctx, DATABASE_NAME, VERSION, SCRIPT_DATABASE_CREATE, SCRIPT_DATABASE_DELETE);
		db = dbHelper.getWritableDatabase();
	}
	
	public long save(Idea idea){
		Long id = idea.getCdIdea();
		
		if(id==null ||id ==0){
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
	
	public List<Idea> findAllIdea() {
		Cursor c = db.query("IDEA", ColunmNames.TABLE_IDEA_COLUNMS,null, null, null, null, null,null);
		List<Idea> ideaList = new ArrayList<Idea>();
		
		if(c.moveToFirst()){
			do {
				Idea idea = new Idea();
				idea.setCdIdea(c.getLong(c.getColumnIndex(TableIdea.CD_IDEA.getColunmName())));
				idea.setDescription(c.getString(c.getColumnIndex(TableIdea.DESCRIPTION.getColunmName())));

				ideaList.add(idea);
			} while (c.moveToNext());
		}
		
		return ideaList;
	}
}