package com.brainstorm.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * class responsible by create base and  initial scrits sql
 * 
 * */
public class SQLiteHelper extends SQLiteOpenHelper{
	private String[] scriptSQLCreate;
	private String scriptSQLDelete;
	
	public SQLiteHelper(Context context, String nomeBanco, int versaoBanco,String[] scriptSQLCreate,String scriptSQLDelete) {
		super(context, nomeBanco, null, versaoBanco);
		this.scriptSQLCreate = scriptSQLCreate;
		this.scriptSQLDelete = scriptSQLDelete;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		int qtdeScript = scriptSQLCreate.length;
		
		for (int i = 0; i < qtdeScript; i++) {
			db.execSQL(scriptSQLCreate[i]);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(scriptSQLDelete);
		onCreate(db);
	}
}