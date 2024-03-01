package HW3_150121052;

import java.util.Scanner;

public class pro1_150121052 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to image printer program.");
		System.out.print("Please enter your sequence: ");
		String seq = input.next();
		int length = seq.length() ;
	    char a = 0; 
	    int b = 0 ; 
	    int i = 0 ; 
	    char c ;
		for(int i1 = 0;i1  < length; i1++) {
			a = seq.charAt(i);	
			if(a>='1'&& a<='9') {
				
					b = i + 1;
					c = seq.charAt(b);
					switch(c) { //this calculates how many stars, space, next line to print
						case 's':
							for(int k = 0; k < (a-'0'-1); k++)
								System.out.print("*");
							break;
						case 'b':
							for(int k = 0; k < (a -'0'-1) ; k++)
								System.out.print(" ");
							break;
						case 'n':
							for(int k = 0; k < (a -'0'-1); k++)
								System.out.println();
							break;
							}}
				if(a == 's') { //this print the star
					System.out.print("*"); 
				}
				if(a == 'n') {
					System.out.println();//this print the next line
				}
				if(a == 'b') {// this print the space
					System.out.print(" ");				 
				}
				i++;
				
						
					 
					
						
						
						
		}

	}

}
