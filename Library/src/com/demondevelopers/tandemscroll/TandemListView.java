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
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;


public class TandemListView extends ListView implements TandemListener
{
	private TandemController mTandem = new TandemController();
	private OnScrollListener mScrollDelgate;
	
	
	public TandemListView(Context context)
	{
		super(context);
		initView();
	}
	
	public TandemListView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initView();
	}
	
	public TandemListView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		initView();
	}
	
	private void initView()
	{
		super.setOnScrollListener(mScrollOverride);
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
			setSelectionFromTop(x, y);
		}
	}
	
	@Override
	public void setOnScrollListener(OnScrollListener listener)
	{
		mScrollDelgate = listener;
		super.setOnScrollListener(mScrollOverride);
	}
	
	private OnScrollListener mScrollOverride = new OnScrollListener()
	{
		@Override
		public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
		{
			if(getChildCount() > 0){
				View firstChild = getChildAt(0);
				mTandem.dispatchTandemScroll(getFirstVisiblePosition(), 
					((firstChild != null) ? firstChild.getTop() : 0));
			}
			if(mScrollDelgate != null){
				mScrollDelgate.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
			}
		}
		
		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState)
		{
			if(mScrollDelgate != null){
				mScrollDelgate.onScrollStateChanged(view, scrollState);
			}
		}
	};
}
