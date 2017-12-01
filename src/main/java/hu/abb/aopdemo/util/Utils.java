package hu.abb.aopdemo.util;

public class Utils {
	public static void sleep(int amount){
		try{
			Thread.sleep(amount);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
