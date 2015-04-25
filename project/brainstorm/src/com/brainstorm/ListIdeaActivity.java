package com.brainstorm;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.brainstorm.controller.IdeaController;
import com.brainstorm.converter.IdeaConverter;
import com.brainstorm.dao.idea.Idea;
import com.brainstorm.view.IdeaListAdapter;

public class ListIdeaActivity extends Activity {
	private IdeaController controller;
	private ListView listView ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_idea);
		
		initializeObjects();
		refreshView();
		settingListners();
	}

	private void initializeObjects() {
		this.controller = new IdeaController(this);
		this.listView = (ListView) findViewById(R.id.ideaList);
	}
	
	private void refreshView(){
		this.listView.setAdapter(new IdeaListAdapter(this,controller.findAllIdea()));		
	}

	private void settingListners() {
		this.listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				Idea idea = (Idea) listView.getAdapter().getItem(position);
				Toast.makeText(getApplicationContext(),IdeaConverter.convertIdeaToString(idea),Toast.LENGTH_LONG).show();
			}
		});
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