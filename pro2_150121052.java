package HW3_150121052;

import java.util.Scanner;

public class pro2_150121052 {

	public static void main(String[] args) {
		 System.out.println("Please enter an integer number:");
		 Scanner input = new Scanner(System.in);
		 int num = input.nextInt();
		 int a1 = 0;
		 int a2 = 1;
		 int sum = 0;
		 if(num==2) 
			 System.out.println(a2);//this command give the second number
		 else if (num==1) 
			 System.out.println(a1);//this command give the first number
		 
		 else 
			 for(int i = 0; i< num-2; i++) {//this loop calculate the value of number
				 sum = 4*a2-a1;
				 a1=a2;
				 a2=sum;
			 }
		 	System.out.println(sum);
			 

	}

}
