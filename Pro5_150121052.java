package hw5_150121052;

import java.util.Scanner;
// Kadir AKARCA 150121052
// ı use four different methods 
// first method counts the number of numbers
//second method checks the available of numbers for grid 
//third method converts to integer from string variable
// fourth method converts to binary system from decimal 
// in the main method, ı write the grid firstly
// after that ı update the grid 
// lastly, ı write updated grid
public class Pro5_150121052 {
public static int numberofnumbers(String numbers) {
	int numberofnumbers = 1;
	for(int i = 0;i<numbers.length();i++) {
		if(numbers.charAt(i)=='-') {
			numberofnumbers++;
		}
	}
	return numberofnumbers;
}
public static boolean checkNumber(String numbers,int size) {
	int number;
	boolean sayıkontrol =true;
	for(int i=0;i<size;i++) {
		number=stringToInt(numbers)[i];
		if(number>=Math.pow(2, size)) {
			System.out.println("The "+number+" cannot be represented "+size+"x"+size+" array");
			sayıkontrol = false;
		}
			}
	return sayıkontrol;
}
public static int[] stringToInt(String numbers) {
	int len = numbers.length();
	String a = "" ;
	int b = 0;
	int c  = 0;
	String d = "";
	int[] intnum = new int[numberofnumbers(numbers)];
	for(int i =0;i<=len;i++) {
		 if(i  == len) {
			b = Integer.parseInt(a);
			intnum[c]=b;}
		else if(numbers.charAt(i)== '-') {
			b = Integer.parseInt(a);
			intnum[c]=b;
			c++;
			d="";
			}		
		else
			d += numbers.charAt(i);
			a = d;
	}
	return intnum;
}
public static int[] convertDectoB(int number, int size) {
	int[] arraynum = new int[size];
	for(int i = 0;i<size-1;i++){
		arraynum[i] = number%2;
		number/=2;
	}
	arraynum[size-1] = number;
	int[] reverse = new int[size];
	int b = 0;
	for(int i = size-1;i>=0;i--) {
		reverse[b]=arraynum[i];
		b++;
	}	
	return reverse;
}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String numbers = input.nextLine();
		System.out.print("Enter a number of step: ");
		int step = input.nextInt();
		int number = 0;
		int a = 0;
		int size = numberofnumbers(numbers);
		int [][] multinumber = new int[size][size];
		int deneme = 0;
		boolean sayıkontrol=true;
		
		if(checkNumber(numbers,size) ==true) {
		for(int i = 0;i<size;i++) {
			for(int j = 0;j<size;j++) {
				number = stringToInt(numbers)[i];
				if(number>=Math.pow(2, size)) {
					System.out.println("the "+number+" cannot be represented "+size+"x"+size+" array");
					}
				deneme =convertDectoB(number,size)[j];
				multinumber[i][j] = deneme;
			}
		}
		int indexofarray =0;
		for(int j = 0; j<=size;j++) {
			for(int i  =0;i<=4*size;i++) {
				System.out.print("-");
			}
			System.out.println();
			for(int z=1;z<=4*size+1;z++) {
				if(j==size) {
					break;}
				if(z%4==3) {
					System.out.print(multinumber[j][indexofarray]);
					indexofarray++;}
				else if(z%4==1) {
					System.out.print("|");}
				else 
					System.out.print(" ");
			}
			System.out.println();
			indexofarray=0;
			}
		int numberofstep = 1;
		int[][] lastarray = new int[size][size];
		for(int q =0;q<step;q++) {
			System.out.println("It is converted to the following table after "+(numberofstep)+". step: ");
			numberofstep++;
			int valueofarray = 0;
			int neighbor = 0;
			for(int i =0;i<size;i++) {
				for(int j= 0;j<size;j++) {
					if(multinumber[i][j]==0) {
						if(i==0 && j==0) {
							if(multinumber[0][1]==1 && multinumber[1][1]==1 && multinumber[1][0]==1) {
								valueofarray = 1;}
							lastarray[i][j] = valueofarray;			
						}
						else if (i==0 && j == size-1){
							if(multinumber[i][j-1]==1 && multinumber[i+1][j-1]==1 && multinumber[i+1][j]==1){
								valueofarray = 1;
							}
							else {
							     valueofarray = 0;}
							lastarray[i][j] = valueofarray;			
						}
						else if (i==size-1 && j == size-1) {
							if(multinumber[i][j-1]==1 && multinumber[i-1][j-1]==1 && multinumber[i-1][j]==1) {
								valueofarray = 1;
							}
							else {
							     valueofarray = 0;}
							lastarray[i][j] = valueofarray;	
						}
						else if (i==size-1 && j == 0) {
							if(multinumber[i][j+1]==1 && multinumber[i-1][j+1]==1 && multinumber[i-1][j]==1) {
								valueofarray = 1;}
							else {
							     valueofarray = 0;}
							lastarray[i][j] = valueofarray;	
							}
						else if(i==0) {
							for(int rows =0;rows<=1;rows++) {
								for(int cols =-1;cols<=1;cols++) {
									if(multinumber[i+rows][j+cols]==1){
										neighbor++;
								}}}
									if(neighbor==3) {
										valueofarray=1;}
									else {
										valueofarray=0;}
									lastarray[i][j]=valueofarray;
									neighbor=0;
							}		
						else if(j==0) {
							for(int rows =-1;rows<=1;rows++) {
								for(int cols =0;cols<=1;cols++) {
									if(multinumber[i+rows][j+cols]==1){
										neighbor++;
								}}}
									if(neighbor==3) {
										valueofarray=1;}
									else {
										valueofarray=0;}
									lastarray[i][j]=valueofarray;
									neighbor=0;	
						}
						else if(j==size-1) {
							for(int rows =-1;rows<=1;rows++) {
								for(int cols =-1;cols<=0;cols++) {
									if(multinumber[i+rows][j+cols]==1){
										neighbor++;
								}}}
									if(neighbor==3) {
										valueofarray=1;}
									else {
										valueofarray=0;}
									lastarray[i][j]=valueofarray;
									neighbor=0;	
						}
						else if(i==size-1) {
							for(int rows =-1;rows<=1;rows++) {
								for(int cols =-1;cols<=0;cols++) {
									if(multinumber[i+cols][j+rows]==1){
										neighbor++;
								}}}
									if(neighbor==3) {
										valueofarray=1;}
									else {
										valueofarray=0;}
									lastarray[i][j]=valueofarray;
									neighbor=0;	
						}
						else {
							for(int rows=-1;rows<=1;rows++) {
								for(int cols =-1;cols<=1;cols++) {
									if(multinumber[i+rows][j+cols]==1){
										neighbor++;
									}
								}					
								}
							if(neighbor==3) {
								valueofarray=1;}
							else {
								valueofarray =0;}
								lastarray[i][j] = valueofarray;
								neighbor=0;
							}						
							}
					else if(multinumber[i][j]==1) {
						if(i==0&&j==0) {
							for(int rows =0;rows<=1;rows++) {
								for(int cols =0;cols<=1;cols++) {
									if(multinumber[i+rows][j+cols]==1){
										neighbor++;
							}}}
									if(neighbor==3 || neighbor==4) {
										valueofarray=1;}
									else {
										valueofarray=0;}
									lastarray[i][j]=valueofarray;
									neighbor=0;
								}		
						else if (i==0 && j == size-1){
							for(int rows =0;rows<=1;rows++) {
								for(int cols =-1;cols<=0;cols++) {
									if(multinumber[i+rows][j+cols]==1){
										neighbor++;
							}}}
									if(neighbor==3 || neighbor==4) {
										valueofarray=1;}
									else {
										valueofarray=0;}
									lastarray[i][j]=valueofarray;
									neighbor=0;								
					}
						else if (i==size-1 && j == size-1) {
							for(int rows =-1;rows<=0;rows++) {
								for(int cols =-1;cols<=0;cols++) {
									if(multinumber[i+rows][j+cols]==1){
										neighbor++;
							}}}
									if(neighbor==3 || neighbor==4) {
										valueofarray=1;}
									else {
										valueofarray=0;}
									lastarray[i][j]=valueofarray;
									neighbor=0;
					}
						else if (i==size-1 && j == 0) {
							for(int rows =-1;rows<=0;rows++) {
								for(int cols =0;cols<=1;cols++) {
									if(multinumber[i+rows][j+cols]==1){
										neighbor++;
							}}}
									if(neighbor==3 || neighbor==4) {
										valueofarray=1;}
									else {
										valueofarray=0;}
									lastarray[i][j]=valueofarray;
									neighbor=0;
							}
						else if(i==0) {
							for(int rows =0;rows<=1;rows++) {
								for(int cols =-1;cols<=1;cols++) {
									if(multinumber[i+rows][j+cols]==1){
										neighbor++;
									}
									
									}}
								if(neighbor==3 || neighbor==4) 
									valueofarray=1;
								else 
									valueofarray=0;
								lastarray[i][j]=valueofarray;
								neighbor=0;
						}		
						else if(j==0) {
							for(int rows =-1;rows<=1;rows++) {
								for(int cols =0;cols<=1;cols++) {
									if(multinumber[i+rows][j+cols]==1){
										neighbor++;
							}}}
									if(neighbor==3 || neighbor==4) {
										valueofarray=1;}
									else {
										valueofarray=0;}
									lastarray[i][j]=valueofarray;
									neighbor=0;	
					}
						else if(j==size-1) {
							for(int rows =-1;rows<=1;rows++) {
								for(int cols =-1;cols<=0;cols++) {
									if(multinumber[i+rows][j+cols]==1){
										neighbor++;
							}}}
									if(neighbor==3 || neighbor==4) {
										valueofarray=1;}
									else {
										valueofarray=0;}
								lastarray[i][j]=valueofarray;
								neighbor=0;	
					}
					else if(i==size-1) {
						for(int rows =-1;rows<=0;rows++) {
							for(int cols =-1;cols<=1;cols++) {
								if(multinumber[i+rows][j+cols]==1){
									neighbor++;
							}}}
								if(neighbor==3 || neighbor ==4) {
									valueofarray=1;}
								else {
									valueofarray=0;}
								lastarray[i][j]=valueofarray;
								neighbor=0;	
					}
					else {
						for(int rows=-1;rows<=1;rows++) {
							for(int cols =-1;cols<=1;cols++) {
								if(multinumber[i+rows][j+cols]==1){
									neighbor++;
								}
							}					
							}
						if(neighbor==3 || neighbor==4) {
							valueofarray=1;}
						else {
							valueofarray =0;}
							lastarray[i][j] = valueofarray;
							neighbor=0;
						}										
						}	}
		}
			int indexofarray2 =0;
			for(int j = 0; j<=size;j++) {
				for(int i  =0;i<=4*size;i++) {
					System.out.print("-");
				}
				System.out.println();
				for(int z=1;z<=4*size+1;z++) {
					if(j==size) {
						break;}
					if(z%4==3) {
						System.out.print(lastarray[j][indexofarray2]);
						indexofarray2++;}
					else if(z%4==1) {
						System.out.print("|");}
					else 
						System.out.print(" ");
				}
				System.out.println();
				indexofarray2=0;
				}		
					for(int i=0;i<size;i++) { 
						for(int j=0;j<size;j++) {
							multinumber[i][j] =lastarray[i][j];	}						
						}
					
		}		
		System.out.print("The decimal value for the second table after "+step+" steps: ");
		int decimal=0;
		int power=0;
		for(int i=0;i<size;i++) {
			for(int j=size-1;j>=0;j--) {
				decimal += (int) (lastarray[i][j]*(Math.pow(2,power)));
				power++;
				if(j==0){
					System.out.print(decimal+"-");
					power=0;
					decimal=0;
				}
			}
		}
	
		}
		
		}
		
}

