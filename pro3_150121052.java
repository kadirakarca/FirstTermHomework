package HW3_150121052;

import java.util.Scanner;

public class pro3_150121052 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an input string: ");
		String name = input.next();
		int length = name.length();
		int a = 0;
		int j=0;
		if(name.equals("QUİT"))
			System.out.println("OK. Good bye :-)");
		else {
			for(int k = 0;k<length;k++) { //this loop is decrementing the characters in the string
				for(int i=0;i<length;i++) {
					if(i==length-k){
						break;}
					System.out.print(name.charAt(i));}
				for(int c=1;c<=k;c++)  //this loop put the space
					
					System.out.print("  ");
				
				for( j =0;j<length;j++) 
					System.out.print(k<=j?name.charAt(j):""); //this loop is decrementing the leading characters
			System.out.println();
				}
		for(int k = 0;k<length;k++) {
			for(int i=0;i<=k;i++) {//this loop is adding the last characters
				System.out.print(name.charAt(i));}
			
			for(j =length-1;j>=0;j--) // this loop is adding leading characters and put the space
				System.out.print(j<=k?name.charAt(length-1-j):"  ");
			
		System.out.println();
			}	
				
		}	
	}

}
