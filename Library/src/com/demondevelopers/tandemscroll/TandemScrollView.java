/*
Copyright 2013 Demon Developers Ltd

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.demondevelopers.tandemscroll;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;


public class TandemScrollView extends ScrollView implements TandemListener
{
	private TandemController mTandem = new TandemController();
	
	
	public TandemScrollView(Context context)
	{
		super(context);
	}
	
	public TandemScrollView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}
	
	public TandemScrollView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
	}
	
	@Override
	public boolean registerTandemListener(TandemListener listener)
	{
		return mTandem.registerTandemListener(listener);
	}
	
	@Override
	public boolean unregisterTandemListener(TandemListener listener)
	{
		return mTandem.unregisterTandemListener(listener);
	}
	
	@Override
	public void tandemScroll(int x, int y)
	{
		if(!mTandem.isInDispatch()){
			scrollTo(x, y);
		}
	}
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt)
	{
		mTandem.dispatchTandemScroll(l, t);
		super.onScrollChanged(l, t, oldl, oldt);
	}
}
