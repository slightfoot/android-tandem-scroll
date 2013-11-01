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

import java.util.Vector;


public class TandemController
{
	private Vector<TandemListener> mListeners = new Vector<TandemListener>();
	
	private boolean mInDispatch = false;
	
	
	public boolean registerTandemListener(TandemListener listener)
	{
		return mListeners.add(listener);
	}
	
	public boolean unregisterTandemListener(TandemListener listener)
	{
		return mListeners.remove(listener);
	}
	
	public boolean isInDispatch()
	{
		return mInDispatch;
	}
	
	public void dispatchTandemScroll(int x, int y)
	{
		mInDispatch = true;
		for(TandemListener listener : mListeners){
			listener.tandemScroll(x, y);
		}
		mInDispatch = false;
	}
}


interface TandemListener
{
	public boolean registerTandemListener(TandemListener listener);
	public boolean unregisterTandemListener(TandemListener listener);
	public void tandemScroll(int x, int y);
}
