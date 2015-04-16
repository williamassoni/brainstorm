package com.brainstorm;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.brainstorm.controller.IdeaController;
import com.brainstorm.dao.idea.Idea;

public class IdeaActivity extends Activity {
	private IdeaController controller;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		controller = new IdeaController(this);
		
		Idea ideia = new Idea();
		ideia.setDescription("COMER PASTEL");
		
		controller.save(ideia);
		controller.findAllIdea();
		setContentView(R.layout.activity_idea);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.idea, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
