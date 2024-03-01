package hw_150121052;

import java.util.Scanner;

public class hw_150121052 {


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the base of the number system: ");
		int base = input.nextInt();
		System.out.print("Enter the type of the operation: ");
		String operation = input.next() ;
		System.out.print("Enter the input numbers with space: ");
		String number1 = input.next() ;
		String number2 = input.next() ;
		int length1 = number1.length();
		int decimal1 = 0;
		int power = 0;
		while(length1 != 0) {
			decimal1 += Math.pow(base,power)*(number1.charAt(length1-1)- '0');
			power +=1;
			length1  -= 1;
			}	
		int length2= number2.length();
		int power2 = 0;
		int decimal2 = 0;
		while(length2 != 0){
			decimal2 += Math.pow(base,power2)*(number2.charAt(length2-1)-'0');
			power2 +=1;
			length2 -= 1;
		    }
		int solution = 0;
		switch(operation) {
			case "a":
				solution = decimal1 + decimal2;
				break;
			case "m":
				solution = decimal1 * decimal2;
				break;
			case "d":
				if(decimal1>decimal2)
					solution = decimal1 / decimal2;
				else 
					solution = decimal2 /decimal1;
				break;
			case "s":
				 if(decimal1>decimal2)
					solution = decimal1 - decimal2;
				 else 
						solution = decimal2 - decimal1;
				break;
		 }
		 String solution2 = "";
		 while (solution >= base) {
			 solution2 += (solution%base) + "";
			 solution /= base;
		}
		solution2 += solution	 ;
		String lastSolution = "" ;
		int digit = solution2.length()-1;
		while (digit>=0) {
			lastSolution += solution2.charAt(digit);
			digit--;
		
		}
	 System.out.println("The answer is " + lastSolution);
		
		
		
	
	}

}
