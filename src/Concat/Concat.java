import java.io.*;

public class Concat{
	public static void main(String[] args){
		String str1="AB";
		String str2="CD";
		String str3="ef";
		String str;
		
		str= str1.concat(str2).concat(str3.toUpperCase());
		System.out.println(str);
	}
}
