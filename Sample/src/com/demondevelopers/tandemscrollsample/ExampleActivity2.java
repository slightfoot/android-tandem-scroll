package com.demondevelopers.tandemscrollsample;

import com.demondevelopers.tandemscroll.TandemListView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.app.Activity;


public class ExampleActivity2 extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.example2);
		
		TandemListView list1 = (TandemListView)findViewById(R.id.list1);
		list1.setAdapter(createSampleData(1));
		
		TandemListView list2 = (TandemListView)findViewById(R.id.list2);
		list2.setAdapter(createSampleData(2));
		
		list1.registerTandemListener(list2);
		list2.registerTandemListener(list1);
	}
	
	public ListAdapter createSampleData(int list)
	{
		String[] data = new String[100];
		for(int i = 0; i < 100; i++){
			data[i] = getString(R.string.entry_name, list, i);
		}
		return new ArrayAdapter<String>(this, 
			android.R.layout.simple_list_item_1, data);
	}
}
