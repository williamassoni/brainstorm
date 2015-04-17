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
	
	public long insert(Idea idea){
		ContentValues values = new ContentValues();
		values.put(ColunmNames.TableIdea.DESCRIPTION.getColunmName(),idea.getDescription());
		return db.insert("IDEA", "", values);
	}
	
	public int update(Idea idea) {
		ContentValues values = new ContentValues();
		values.put(ColunmNames.TableIdea.DESCRIPTION.getColunmName(),idea.getDescription());
		
		String _id = String.valueOf(idea.getCdIdea());
		String where = ColunmNames.TableIdea.CD_IDEA.getColunmName()+" = ? ";
		String[] whereArgs = new String[]{_id};
		
		return db.update("IDEA", values, where, whereArgs);
	}
	
	public List<Idea> findAllIdea() {
		Cursor cursor = db.query("IDEA", ColunmNames.TABLE_IDEA_COLUNMS,null, null, null, null, null,null);
		List<Idea> ideaList = new ArrayList<Idea>();
		
		if(cursor.moveToFirst()){
			do {
				Idea idea = new Idea();
				idea.setCdIdea(cursor.getLong(findColunmPosition(TableIdea.CD_IDEA,cursor)));
				idea.setDescription(cursor.getString(findColunmPosition(TableIdea.DESCRIPTION,cursor)));

				ideaList.add(idea);
			} while (cursor.moveToNext());
		}
		
		return ideaList;
	}
	
	private int findColunmPosition(TableIdea colunmName,Cursor cursor){
		return cursor.getColumnIndex(colunmName.getColunmName());
	}
	
}