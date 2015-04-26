package com.brainstorm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.brainstorm.controller.IdeaController;
import com.brainstorm.dao.idea.Idea;

public class CadIdeaActivity extends Activity {
	private IdeaController controller;
	private Button btSaveIdea;
	private Idea newIdea;
	private Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cad_idea);
		
		this.controller = new IdeaController(this);
		this.btSaveIdea = (Button) findViewById(R.id.btSaveIdea);
		this.newIdea = new Idea();
		settingListners();
	}

	private void settingListners() {
		this.btSaveIdea.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				saveIdea();
				startActivity(new Intent(context,ListIdeaActivity.class));
			}
         });
	}

	private void saveIdea(){
		this.newIdea.setDescription("COMER PASTEL ");
		this.controller.save(newIdea);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cad_idea, menu);
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
