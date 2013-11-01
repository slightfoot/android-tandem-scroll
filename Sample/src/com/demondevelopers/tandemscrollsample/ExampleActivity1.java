package com.demondevelopers.tandemscrollsample;

import com.demondevelopers.tandemscroll.TandemScrollView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;


public class ExampleActivity1 extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.example1);
		
		TandemScrollView scroll1 = (TandemScrollView)findViewById(R.id.scroll1);
		createSampleData(scroll1, 1);
		
		TandemScrollView scroll2 = (TandemScrollView)findViewById(R.id.scroll2);
		createSampleData(scroll2, 2);
		
		scroll1.registerTandemListener(scroll2);
		scroll2.registerTandemListener(scroll1);
	}
	
	public void createSampleData(TandemScrollView scroll, int list)
	{
		LayoutInflater inflater = getLayoutInflater();
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		for(int i = 0; i < 25; i++){
			TextView text = (TextView)inflater.inflate(android.R
				.layout.simple_list_item_1, scroll, false);
			text.setText(getString(R.string.entry_name, list, i));
			layout.addView(text);
		}
		scroll.addView(layout);
	}
}
