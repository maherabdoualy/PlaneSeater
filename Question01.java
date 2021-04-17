import java.util.Scanner;

public class Question01 {

    // MAIN
    public static void main(String[] args) {
        char[][] seats = new char [13][6];
        initializeSeats(seats);
        menu(seats);
    }


//METHOD THAT INITIALIZES THE SEATS TO EMPTY
    public static void initializeSeats(char[][] seats){
        for (int i=0; i< seats.length; i++){
            for (int j=0; j<seats[0].length;j++){
                seats[i][j] = '*';
            }
        }
    }


    //METHOD THAT OUTPUTS THE PLANE
    public static void showSeats(char[][] seats){
        System.out.println("\t\tA B C   D E F");
        for (int i = 0; i < seats.length; i++) {
            System.out.println(("Row "+(i+1) + "\t" + seats[i][0] + " " + seats[i][1] + " " + seats[i][2] + "   " + seats[i][3]+
                            " " + seats[i][4]+ " " + seats[i][5])) ;
        }
        System.out.println("*--Available seats");
        System.out.println("X--occupied seats");
     }



//METHOD THAT PICKS THE USER'S SEAT
     public static void assignSeats(char[][] seats){
        //scanners declaration
         Scanner type = new Scanner(System.in);
         Scanner row = new Scanner(System.in);
         Scanner letter = new Scanner(System.in);

//class determination
         System.out.println("Enter ticket type: F (first class);  B (business class); E (economy class): ");
         char typeSeat = type.next().charAt(0);
         int rowNumber=0;

         switch(typeSeat){ // switch to validate the row number in accordance with class
             case 'F':
                 while (rowNumber < 1 || rowNumber > 2) {
                     System.out.println("Enter Row number 1 - 2: ");
                     rowNumber = row.nextInt();
                 }
                 break;

             case 'B':
                 while (rowNumber < 3 || rowNumber > 7) {
                     System.out.println("Enter Row number 3 - 7: ");
                     rowNumber = row.nextInt();
                 }
                 break;

             case 'E':
                 while (rowNumber< 7 || rowNumber>13) {
                     System.out.println("Enter Row number 7 - 13: ");
                     rowNumber = row.nextInt();
                 }
                 break;

             default:
                 System.out.println("Your input was incorrect. Let's try again.");
                 assignSeats(seats);
         }

         System.out.println("Enter seat number (A - F): ");
         char seatLetter = letter.next().charAt(0);

         switch(seatLetter){ // switch to check if the seat is free, then replace
             case 'A':
                if(seats[rowNumber-1][0] == 'X'){ System.out.println("This seat is already taken! Try again."); assignSeats(seats);}
                else seats[rowNumber-1][0] = 'X';
                 break;
             case 'B':
                 if(seats[rowNumber-1][1] == 'X'){ System.out.println("This seat is already taken! Try again."); assignSeats(seats);}
                 else seats[rowNumber-1][1] = 'X';
                 break;
             case 'C':
                 if(seats[rowNumber-1][2] == 'X'){ System.out.println("This seat is already taken! Try again."); assignSeats(seats);}
                 else seats[rowNumber-1][2] = 'X';
                 break;
             case 'D':
                 if(seats[rowNumber-1][3] == 'X'){ System.out.println("This seat is already taken! Try again."); assignSeats(seats);}
                 else seats[rowNumber-1][3] = 'X';
                 break;
             case 'E':
                 if(seats[rowNumber-1][4] == 'X'){ System.out.println("This seat is already taken! Try again."); assignSeats(seats);}
                 else seats[rowNumber-1][4] = 'X';
                 break;
             case 'F':
                 if(seats[rowNumber-1][5] == 'X'){ System.out.println("This seat is already taken! Try again."); assignSeats(seats);}
                 else seats[rowNumber-1][5] = 'X';
                 break;

             default:
                 System.out.println("Your input was incorrect. Let's try again.");
                 assignSeats(seats);
         }
         System.out.println("Your seat was reserved.\n\n");
    }

    public static void menu(char [][] seats){
        char choice = 'Y';
        Scanner input = new Scanner(System.in);
        while (choice == 'Y'){
            System.out.println("This program assigns seats for a commercial airplane.");
            System.out.println("The current seat assignments is as follows.\n");
            showSeats(seats);
            System.out.println("\n");
            System.out.println("Rows 1 and 2 are for first class passengers.");
            System.out.println("Rows 3 through 7 are for business class passengers.");
            System.out.println("Rows 8 through 13 are for economy class passengers");
            System.out.println("Reserve a seat: 'Y' (yes) or 'N' (no): ");
             choice = input.next().charAt(0);
             if ( choice == 'Y') assignSeats(seats);
             else if (choice == 'N') continue;
             else{
                 System.out.println("Invalid input. Try again.");
                 menu(seats);
             }
        }
    }
    }







