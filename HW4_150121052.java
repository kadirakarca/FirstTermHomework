package hw4_150121052;

import java.util.Scanner;
 // ı use 6 method for each operation 
// change case method change letter for example if they are upper letter it change the lower letter
// updatelettercount method count the letter on string
//updatewordcount method count the word on string
//static method bond the updatelettercount and updatewordcount
// countoccourence method count the how many time be on the sentence
// encryption method is kinda parola occur system
public class HW4_150121052 {
	public static String changeCase(String str) {
		System.out.print("Please enter an input String: ");
		Scanner input = new Scanner(System.in);
		String sent = input.nextLine();	
		int length = sent.length();
		char a ;
		char b = 0 ;
		for(int i =0 ;i<length;i++) {
			a = sent.charAt(i);
			if((a<'Z' && a>'A')||(a<'z'&& a>'a')) {
				if(Character.isUpperCase(a))
					b = Character.toLowerCase(a); 
				else
					b = Character.toUpperCase(a);
				str += b;}
			else
				str+=a;
		}
		return str;
		
	}
	
	public static int updateLetterCount(int count, String str) {
		int length = str.length();
		char a = 0 ;
		for(int i = 0;i<length;i++) {
			a = str.charAt(i);
			if(a==' ')
				continue;
			count++;}
			return count;				
	}  
	public static int updateWordCount(int count, String str) {
		int length = str.length();
		char a = 0;
		for(int i = 0;i<length;i++) {
			a = str.charAt(i);
			if(a==' ')
				count++;
		}
		return count+1;	
	}
	public static void printStat (int wordCount, int letterCount) {
		System.out.println("The number of letters: "+wordCount);
		System.out.println("The number of words: "+letterCount);
	}
	public static int countOccurences (String[] sentence, String word) {
		int count = 0;
		for(int i =0; i<sentence.length;i++) {
			if(sentence[i].equals(word))
				count++;
		}
		System.out.println(word + " appears "+ count +  " time(s) in the sentence.");
			return count;
		
	}
	public static String encryption (String str, int pattern) {
		String upperstr = str.toUpperCase();
		System.out.println("Source: " + upperstr);
		String spaceless = "";
		char a ;
		for(int i = 0;i<upperstr.length();i++) {
			a = upperstr.charAt(i);
			if(a==' ');
			else
				spaceless += a;
		}
		int w =0 ;
		String parola = "";
		int length = spaceless.length();
		char [][] c = new char[pattern][length];
		for(int j = 0; j<spaceless.length();j++) {
							
				if(w==pattern-1) {
					for(w = pattern-1;w>=0;w--) {
						c[w][j] = spaceless.charAt(j);
						if(j!=length-1)		
							j++;}}	
				else 
					c[w][j] = spaceless.charAt(j);		
				w++;
		}
		
		for(int az = 0;az<pattern;az++) {
			for(int qz = 0;qz<length;qz++) {
				if(c[az][qz] != 0 )
				
					parola += c[az][qz];
				
			}
		}
		return parola;		
		}	
	public static void main(String[] args) {
		boolean loop = true;
		while(loop) {
		System.out.println("Menu:  \n"
				+ "1. Change Case \n"
				+ "2. Count occurrences \n"
				+ "3. Encryption \n"
				+ "4. Statistics \n"
				+ "5. Exit ");
		Scanner input = new Scanner(System.in);
		int menu = input.nextInt();
		switch(menu) {
			case 1:
				System.out.print(changeCase(""));
				break;
			case 3:
				System.out.print("Please enter an input String: ");
				Scanner input3 = new Scanner(System.in);
				String str = input3.nextLine();
				System.out.print("Enter an integer pattern: ");
				int pattern = input3.nextInt();
				System.out.println(encryption(str,pattern));
				break;
				
			case 4: 
				System.out.print("Please enter an input String: ");
				Scanner input4 = new Scanner(System.in);
				String str1 = input4.nextLine();				
				int wordCount = updateLetterCount(0,str1);
				int letterCount = updateWordCount(0,str1);
				printStat(wordCount,letterCount);
				break;
			case 2:
				System.out.println("Please  enter  an  input  sentence: ");
				Scanner input2 = new Scanner(System.in);
				String sent = input2.nextLine();
				int length = sent.length();
				String lowsent = sent.toLowerCase();
				char a = 0;
				int space = 0;
				for(int i = 0;i<length;i++) {
					a = lowsent.charAt(i);
					if(a==' ')
						space++;}
				String[] sentence = new String[space];
				char k ;
				String words = "";
				int w = 0;
				for(int j = 0; j<length; j++) {
					k = sent.charAt(j);
						if(k==' ') {
							
							sentence[w] = words;
							words = "";
							w++;
						}
						else
						words += k;
				}
				System.out.print("Please enter an input word: ");
				String word = input2.next();
				countOccurences(sentence,word);
				break;
			case 5:
				loop=false;
		}
		}
		System.out.println("Program ends. Bye :) ");
		
	}
}
