/* ========================================================================== */
/*	PROGRAM Internet Service Provider

    AUTHOR: Yuri Khechoyan & Jessie Wilkins
    COURSE NUMBER: CIS 210
    COURSE SECTION NUMBER: 01
    INSTRUCTOR NAME: Dr. Tian
    PROJECT NUMBER: 3 
    DUE DATE: 09/08/2016

SUMMARY

	This program is used to simulate a customer buying an 
	Internet Service subscription package. 
	Each package is different. User will be asked to choose
	a subscription package and enter it into the program.
	Then user will be asked how many hours they have used
	the Internet service. Program will then calculate the
	price that user must pay at the end of the month.
	Program will let user know of the savings based on their 
	current package and hours of usage.

INPUT

The input for this program will be Doubles (package prices), 
Ints (hours used).
Doubles will refer to the US Dollar (USD)

OUTPUT

The input values are echoprinted at the end. 
A multiplication operation will occur to
Calculate how much user has to pay at the
end of the month. Then the program will remind user
of any savings (whether they should upgrade their
current subscription package)

ASSUMPTIONS
- Purchase prices are in the US Dollar unit (double, greater than 1)
- If whole number is entered, it will be converted into a double

*/

			/* MAIN FUNCTION */

import java.util.Scanner; 									//Imports scanner function for user input

public class InternetServiceProvider {
	public static void main(String[] args){
		
			
		//Variables
		double packageSavings;								//Savings from upgrade
		int hoursUsed;										//amount of hours consumed
		char packageLetter;									//input for what package user has
		double packBCalculation;							//Variable used to store package A calculation
		double userPack;									//Variable used to store total
		final double PACKAGE_A_MONTHLY_RATE = 9.95;			//price of package A
		final double PACKAGE_B_MONTHLY_RATE = 13.95;		//price of package B
		final double PACKAGE_C_MONTHLY_RATE = 19.95;		//price of package C
		final double PACKAGE_A_HOURLY_RATE = 2.0;			//package A Over-age fee
		final double PACKAGE_B_HOURLY_RATE = 1.0;			//package B Over-age fee					
		final double PACKAGE_A_BASE_HOUR = 10;				//max hour usage for package A 
		final double PACKAGE_B_BASE_HOUR = 20;				//max hour usage for package B
			
		//Create a new Scanner Object for User Input - input
		Scanner input = new Scanner(System.in);
			
			
			//******************************************
			//*				 START OF PROGRAM          *
			//******************************************
		
		//This prints out the command	
		System.out.println("Please enter the letter of your Package: ");
		
		//Receive package letter input from user
		packageLetter = input.next().trim().charAt(0);
		
		//While loop that checks if user entered a valid letter
		while(packageLetter != 'A' && packageLetter != 'a' && packageLetter != 'B' && packageLetter != 'b' && packageLetter != 'C' && packageLetter != 'c'){	
			//This prints the command to enter a valid letter
			System.out.println("That is not a Package. Please choose A, B, or C.");
			//Receive package letter input from user
			packageLetter = input.next().trim().charAt(0);
		} //closes while statement
		
		//Ask for hours user consumed
		System.out.println("Please enter the number of hours used: ");
		
		//Receive the amount of hours used for package and store into hoursUsed
		hoursUsed = input.nextInt();
		
		//While loop that checks if hours are less than zero
		while(hoursUsed < 0) {
			
			//Notify user that input was invalid
			System.out.println("This is not a valid amount. Please enter a positive number:");
			
			//Receive the amount of hours used for package and re-store into hoursUsed
			hoursUsed = input.nextInt();
		}//End of while statement
		
				//*******************************************
				//	PACKAGE FUNCTIONS BASED ON USER INPUT	*
				//*******************************************
		
		//'if' condition in which package A is selected
		if(packageLetter == 'A'|| packageLetter == 'a') {
			//Beginning of nested if statement for hoursUsed
			if(hoursUsed <= 10) {
				//Assign Package A rate to userPack
				userPack = PACKAGE_A_MONTHLY_RATE;
			}//End of nested if statement
			
			//Beginning of second nested if statement
			else {
				//Calculate total cost for Package A and re-store amount into userPack
				userPack = PACKAGE_A_MONTHLY_RATE + ((hoursUsed-PACKAGE_A_BASE_HOUR)*PACKAGE_A_HOURLY_RATE);
			}//Ending of second nested if statement
			
		}//Ending of if statement
		
		//'if' condition in which package B is selected
		else if(packageLetter == 'B' || packageLetter == 'b') {
			//This checks if the hours are less than the base hours of the package
			if(hoursUsed <= 20) {
				//Assign Package B rate to userPack
				userPack = PACKAGE_B_MONTHLY_RATE;
			}//This ends the if statement
			
			
			//Calculate total cost for Package B and re-store amount into userPack
			else {
				userPack= PACKAGE_B_MONTHLY_RATE + ((hoursUsed-PACKAGE_B_BASE_HOUR) * PACKAGE_B_HOURLY_RATE);
			}//Ending of else statement
			
		}//Ending of else if statement
		
		
		//If other conditions are satisfied, then the rate of package C is assigned to the variable
		else {
			userPack = PACKAGE_C_MONTHLY_RATE;
		}//Ending of else statement
		
				
			//**********************************
			//*			SWITCH STATEMENT       *
			//**********************************
		
		//Beginning of switch statement - packageLetter
		switch(packageLetter){
		
			//When packageLetter is 'A'
			case 'A':
		
				//Execute same code as user input 'a'
			
			//When packageLetter is 'a'
			case 'a':
				//Prints the total cost of package A
				System.out.printf("Total cost is $%.2f\n", userPack);
				
				//This assigns package B monthly price to the variable if the amount of hours used is less than or equal to 20
				if(hoursUsed <= 20) {
					packBCalculation = PACKAGE_B_MONTHLY_RATE;
				}//Ending if statement
				
				//This calculates the total cost of package B for all other conditions
				else {
					packBCalculation = PACKAGE_B_MONTHLY_RATE + ((hoursUsed-PACKAGE_B_BASE_HOUR) * PACKAGE_B_HOURLY_RATE);
				}//This ends the else statement
				
				//This starts the if statement if the package B cost is less than the user-entered package and the package C cost
				if(packBCalculation < userPack && packBCalculation < PACKAGE_C_MONTHLY_RATE) {
					//This calculates the savings of package B relative to the the user entered package
					packageSavings = userPack - packBCalculation;
					//This prints out the savings when switching to package B if the savings are above 0
					if(packageSavings > 0) {
						System.out.printf("Customer A can save $%.2f if he purchases package B\n", packageSavings);
					}//Ends the if statement
					
				}//Ends the if statement
				
				//This performs the else statement if other conditions are satisfied
				else {
					//This calculates the savings of switching to package C
					packageSavings = userPack - PACKAGE_C_MONTHLY_RATE;
					//This prints the savings of switching package C if the savings are above zero
					if(packageSavings > 0) {
						
						System.out.printf("Customer A can save $%.2f if he purchases package C\n", packageSavings);
					}//This ends the else statement
					
				}//This ends the else statement
				break;
				
			//When packageLetter is 'B'
			case 'B':
				
				//Execute same code as user input 'b'
				
			//When packageLetter is 'b'
			case 'b':
				//This outputs the total price for package B
				System.out.printf("Total cost is $%.2f\n", userPack);
				//This calculates the savings of switching to package C
				packageSavings = userPack - PACKAGE_C_MONTHLY_RATE;
				//This prints out the price of switching to package if the savings is greater than 0
				if(packageSavings > 0) {
					System.out.printf("Customer A can save $%.2f if he purchases package C\n", packageSavings);
				}//This ends the else statement
				break;
				
			//When all other cases are false (in other words, when packageLetter is C)
			default:
				//This prints out the total of package C
				System.out.printf("Total cost is $%.2f\n", userPack);
				//This breaks from the case
				break;
		}//Closes entire Switch statement
		
		//Prints out the ending message
		System.out.print("Good bye");
		//Closes the scanner object to prevent data leaks
		input.close();
	}//Closes Main function
	
}//This ends the InternetServiceProvider class