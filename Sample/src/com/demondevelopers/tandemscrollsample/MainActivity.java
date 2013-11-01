package com.demondevelopers.tandemscrollsample;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class MainActivity extends PreferenceActivity
{
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.examples);
	}
	
}
