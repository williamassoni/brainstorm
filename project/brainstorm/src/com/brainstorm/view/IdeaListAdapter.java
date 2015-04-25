package com.brainstorm.view;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.brainstorm.R;
import com.brainstorm.dao.idea.Idea;

public class IdeaListAdapter extends BaseAdapter{
	private Context context;
	private List<Idea> ideaList;
	
	public IdeaListAdapter(Context contexto, List<Idea> ideaList) {
		this.context = contexto;
		this.ideaList = ideaList;
	}

	public int getCount(){
		return this.ideaList.size();
	}
	
	public Object getItem(int position){
		return this.ideaList.get(position);
	}
	
	public long getItemId(int position){
		return this.ideaList.get(position).getCdIdea();
	}
	
	public View getView(int position,View convertView,ViewGroup parent){
		Idea c = this.ideaList.get(position);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View view = inflater.inflate(R.layout.idea_line, null);
		
		TextView nome = (TextView) view.findViewById(R.id.description);
		nome.setText(c.getDescription());
		
		return view;
	}
}