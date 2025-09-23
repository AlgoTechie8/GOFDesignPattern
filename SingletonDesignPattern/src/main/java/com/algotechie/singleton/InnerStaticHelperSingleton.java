package com.algotechie.singleton;

// 05. Bill Pugh’s Inner Static Helper (best lazy initialization)
public class InnerStaticHelperSingleton {
	
	private InnerStaticHelperSingleton() {}
	
	private static class Helper{
		private static final InnerStaticHelperSingleton INSTANCE = new InnerStaticHelperSingleton();		
	}
	public static InnerStaticHelperSingleton getInstance() {
		return Helper.INSTANCE;
	}
}
