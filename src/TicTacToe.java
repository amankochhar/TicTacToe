
import java.util.Scanner;

public class TicTacToe{ 
		
		public static void main(String[] args){
		
			System.out.println("Please input the string of length 9 ( for eg. xxo_o_xo_ )");
			Scanner scan = new Scanner(System.in);
			String value = scan.nextLine();	
			//System.out.println("Main is working");
			// Saves string for playing
			if(StringSaver(value)==true){
				CompTurn(value);
				//PlayerTurn(value);
			}
			
		}
		
		public static boolean StringSaver(String value){
			//Calls StringChecker
		    //System.out.println("StringSaver Working");
			boolean done = false;
			String values[] = new String[9];
			if(StringChecker(value) == true){
				//System.out.println("Please enter the correct string");
			}
			else{
				// Saving string into the correct format
				int c = 0;
				for(int i = 0; i < 9; i++){
						values[i] = value.substring(c, c+1);
						c++;
				}
				done = true;
			}
			return done;
		}
		
		public static boolean StringChecker (String value){
			//System.out.println("StringChecker Working");
			// Checks length and format of string
			boolean status = false;
			for(int i = 0; i<value.length();i++){
				if(value.charAt(i) == 'x' ||  value.charAt(i) == 'o' ||  value.charAt(i) == '_'){
					//System.out.println("Thank you");
				}
				else{ 
					System.out.println("Please enter a string with only lowercase x, o and _ ( for eg. xxo_o_xo_ )");
					status = true;
					break;
				}
			}
			if(value.length() == 9){
				//System.out.println("Thank you");
			}
			else{
				System.out.println("Please make sure the entered string is 9 characters long ");
				status = true;
			}
			return status;
		}
		
		public static void Printboard(String values){
			//System.out.println("PrintBoard Working");
			System.out.println("Thanks. Now the board looks like: ");
			System.out.println(values.charAt(0)+"|"+values.charAt(1)+"|"+values.charAt(2));
			System.out.println(values.charAt(3)+"|"+values.charAt(4)+"|"+values.charAt(5));
			System.out.println(values.charAt(6)+"|"+values.charAt(7)+"|"+values.charAt(8));
		}
		
		public static boolean WinChecker (String values){
			//System.out.println("WinChecker is working");
			boolean win = false;
			// row 1 check
			if(values.charAt(0) == 'x' && values.charAt(1) == 'x' && values.charAt(2) == 'x'  ||
					values.charAt(0) == 'o' && values.charAt(1) == 'o' && values.charAt(2) == 'o'){
				//System.out.println("Row 1");
				win = true;
			}
			// row 2 check
			if(values.charAt(3) == 'x' && values.charAt(4) == 'x' && values.charAt(5) == 'x'  || 
					values.charAt(3) == 'o' && values.charAt(4) == 'o' && values.charAt(5) == 'o'){
				//System.out.println("Row 2");
			win = true;
			}
			// row 3 check
			if(values.charAt(6) == 'x' && values.charAt(7) == 'x' && values.charAt(8) == 'x'  ||
					values.charAt(6) == 'o' && values.charAt(7) == 'o' && values.charAt(8) == 'o'){
				//System.out.println("Row 3");
			win = true;
			}
			
			// column 1 check
			if(values.charAt(0) == 'x' && values.charAt(3) == 'x' && values.charAt(6) == 'x'  ||
					values.charAt(0) == 'o' && values.charAt(3) == 'o' && values.charAt(6) == 'o'){
				//System.out.println("Column 1");
				win = true;
			}
			// column 2 check
			if(values.charAt(1) == 'x' && values.charAt(4) == 'x' && values.charAt(7) == 'x'  ||
					values.charAt(1) == 'o' && values.charAt(4) == 'o' && values.charAt(7) == 'o'){
				//System.out.println("Column 2");
			win = true;
			}
			// column 3 check
			if(values.charAt(2) == 'x' && values.charAt(5) == 'x' && values.charAt(8) == 'x'  ||
					values.charAt(2) == 'o' && values.charAt(5) == 'o' && values.charAt(8) == 'o'){
				//System.out.println("Column 3");
			win = true;
			}
			// diagnol 1 check
			if(values.charAt(0) == 'x' && values.charAt(4) == 'x' && values.charAt(8) == 'x' ||
			values.charAt(0) == 'o' && values.charAt(4) == 'o' && values.charAt(8) == 'o'){
				//System.out.println("Diagnol 1");
			win = true;
			}
			// diagnol  2 check
			if(values.charAt(2) == 'x' && values.charAt(4) == 'x' && values.charAt(6) == 'x'  ||
			values.charAt(2) == 'o' && values.charAt(4) == 'o' && values.charAt(6) == 'o'){
				//System.out.println("Diagnol 2");
			win = true;
			}
			return win;
		}
		
		public static boolean DrawChecker (String values){
			boolean draw = false;
			String s = "_";
				if(values.contains(s)){
					//System.out.println("Keep playing");
				}
					else{
						draw = true;
					}
			return draw;
		}
		
		public static void PlayerTurn(String values){
			//System.out.println("PlayerTurn is working");
			Printboard(values);
			if(DrawChecker(values) == true){
				System.out.println("It's a Draw");
			}
			else{
			if(WinChecker(values) == true){
				System.out.println("Computer Wins!");
				System.exit(0);
			}
			else{
				//System.out.println("Keep Playing!");
				PlayerMove(values);
			}
		}
	}
		
		public static void PlayerMove(String values){
			//System.out.println("PlayerMove is working");
			Scanner scan = new Scanner(System.in);
			System.out.println("Human player please select a cell number to fill (0-8): ");
			int move = scan.nextInt();
			if(values.charAt(move) == 'x' || values.charAt(move) == 'o'){
				System.out.println("Not a valid move, please try again. Please select a cell to fill: ");
				PlayerMove(values);
			}
			else if(values.charAt(move) == '_'){
				char[] values2 = values.toCharArray();
				values2[move] = 'o';
				values = String.valueOf(values2);
				CompTurn(values);
			}
		}
			
		public static void CompTurn(String values){
			//System.out.println("CompTurn is working");
			int MaMove = 0;
			Printboard(values);
			if(DrawChecker(values) == true){
				System.out.println("It's a Draw");
			}
			else{
			if(WinChecker(values) == true){
				System.out.println("You Win!");
				System.exit(0);
			}
			else{
				//System.out.println("Keep Playing!");
				CompMove(values, MaMove);
			}
		}
	}
		
		public static void CompMove(String values, int MaMove){
			//System.out.println("CompMove is working");
			System.out.print("Computer's Move: ");
			int count = values.length() - values.replace("_", "").length();
			//System.out.println("Count: "+count);
			String match = "_";
			int index = values.indexOf(match);
			int blank[] = new int[count];
			int counter = 0;
			
			while (index >= 0) {  // indexOf returns -1 if no match found
				//System.out.println("index: " +index);
				blank[counter] = index;
				index = values.indexOf(match, index + 1);
			    counter++;
			}
			MoveMaker(values, blank, count, MaMove);
	}
		
		public static boolean MoveMaker(String values, int blank[], int count, int MaMove){
			//System.out.println("MoveMaker is working");
			Boolean SysMove = false;
			int trial;
			String valuesnew, valuesnew2;
			for(int i = 0; i < count; i++){
				trial = blank[i];
				MaMove = trial;
				char[] values2 = values.toCharArray();
				values2[trial] = 'x';
				valuesnew = String.valueOf(values2);
				//System.out.println("trial in for loop x: " +trial);
				
				if(WinChecker(valuesnew) == true){
					//System.out.println("Going to WinChecker through MoveMaker x with valuesnew");
					SysMove = true;
					MaMove = trial;
					//System.out.println("MaMove for x: " +MaMove);
					//System.out.println("True ho gya x");
					System.out.println(MaMove);
					char[] values21 = values.toCharArray();
					values21[MaMove] = 'x';
					values = String.valueOf(values21);				
					PlayerTurn(values);
					break;
				}
			}
			if(SysMove == true){
				System.out.println(MaMove);
				return SysMove;
			}
			else{
			for(int j = 0; j < count; j++){
				trial = blank[j];
				MaMove = trial;
				char[] values3 = values.toCharArray();
				values3[trial] = 'o';
				valuesnew2 = String.valueOf(values3);
				//System.out.println("trial in for loop o: " +trial);
				
				if(WinChecker(valuesnew2) == true){
					//System.out.println("Going to WinChecker through MoveMaker o with valuesnew2");
					SysMove = true;
					MaMove = trial;
					//System.out.println("MaMove for o: " +MaMove);
					//System.out.println("True ho gya o");
					//System.out.println("MaMove o: " +MaMove);
					char[] values2 = values.toCharArray();
					values2[MaMove] = 'x';
					values = String.valueOf(values2);				
					PlayerTurn(values);
					System.out.println(MaMove);
					break;
				}
				else 
					MaMove = blank[0];
				System.out.println(MaMove);
				char[] values2 = values.toCharArray();
				values2[MaMove] = 'x';
				values = String.valueOf(values2);				
				PlayerTurn(values);
				System.out.println(MaMove);
				break;
			}
		}
			return SysMove;
	}
		
}