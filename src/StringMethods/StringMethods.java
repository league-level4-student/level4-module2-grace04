package StringMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length()>s2.length())
			return s1;
		else
			return s2;
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		String news = s;
		if(news.contains("underscores"))
			news = news.replace(' ', '_');
		return news;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		char c1 = ' ', c2 = ' ', c3 = ' ';
		s1 = s1.trim();
		String[] n1 = s1.split(" ");
		s2 = s2.trim();
		String[] n2 = s2.split(" ");
		s3 = s3.trim();
		String[] n3 = s3.split(" ");
		c1 = n1[1].charAt(0);
		c2 = n2[1].charAt(0);
		c3 = n3[1].charAt(0);
		System.out.println(c1+" "+c2+" "+c3);
		if(c1<c2&&c1<c3) {
			System.out.println(s1);
			return s1;
		}
		else if(c2<c1&&c2<c3) {
			System.out.println(s2);
			return s2;
		}
		else {
			System.out.println(s3);
			return s3;
		}
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		for(int i=0;i<s.length();i++) {
			if(Character.isDigit(s.charAt(i))) {
				sum += Character.getNumericValue(s.charAt(i));
			}
		}
		return sum;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int count=0;
		while(s.indexOf(substring)!=-1) {
			s = s.substring(s.indexOf(substring)+substring.length());
			count++;
		}
		return count;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		return Utilities.encrypt(s.getBytes(), (byte) key);
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return Utilities.decrypt(s, (byte) key);
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int count = 0;
		String[] n = s.split(" ");
		for(int i=0;i<n.length;i++) {
			if(n[i].endsWith(substring)){
				count++;
			}
		}
		return count;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int l = substring.length();
		int first = s.indexOf(substring) + l;
		int last = s.lastIndexOf(substring);
		String n = s.substring(first, last);
		return n.length();
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String[] arr = s.split("[\\W| ]");
		String n = "";
		for (int i=0;i<arr.length;i++) {
			n += arr[i];
		}
		String revn = "";
		for (int i=n.length()-1;i>-1;i--) {
			revn += n.charAt(i);
		}
		if(revn.equalsIgnoreCase(n)) {
			return true;
		}
		return false;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
