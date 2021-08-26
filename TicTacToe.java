import java.util.Scanner;
import java.util.Hashtable;

public class TicTacToe{

public static void main(String[] args) {

    String view = "_ _|_ _|_ _\n_ _|_ _|_ _\n   |   |   ";
    Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>(){{ put(1, 1); put(2, 5); put(3,9); put(4,13); put(5,17); put(6,21); put(7,25); put(8,29); put(9,33);}};
    char player1;
    char player2 = ' ';
    char player = ' ';
    int position, player1_wins=0, player1_loses=0, player2_wins=0, player2_loses=0;
    char answer = ' ';
    
    System.out.println(" \n********* Welcome to TicTacToe game ********* \nEnter player one symbol X or O: ");    

    Scanner input = new Scanner(System.in);
    while(true){
        player1 = input.next().charAt(0);    
        if ((player1 == 'X') || (player1 == 'x')){
            player2 = 'O';
            break;
        }
        else if ((player1 == 'o')||(player1 == 'O')||(player1 == '0')){
            player2 = 'X';
            break;
        }
        else{
            System.out.println("\n***** Please enter a char from 'X' or 'O' *****\n");
            continue;
        }
    }

    System.out.println("\nAlright Player one choice is: " + player1 +"\n\nSo, automatically player two choice is: " + player2);
    System.out.println("Instructions: Each position is identified by numbers 1-9 as below\n");
    System.out.println("_1_|_2_|_3_\n_4_|_5_|_6_\n 7 | 8 | 9 \n\n");
    System.out.println("\n************* Lets Begin the Game *************\n");
    System.out.println("\nEnter the choice of postions in terms of numbers [1-9]\nYou can reset the game anytime by entering choice as [0]\n");

    while(true){
        System.out.println(view);
        if(player == ' ')
            player = player1;
        else if(player == player1)
            player = player2;
        else
            player = player1;
        while(true){
            System.out.println("\nplayer "+player+":");
            position = input.nextInt();
            if(position==0){
                view = "_ _|_ _|_ _\n_ _|_ _|_ _\n   |   |   ";
                System.out.println("Grid view has been reset as below\n" + view);
                continue;
            }
            else if(view.charAt(map.get(position))==' ' && position<=9 && position>0){
                view = view.substring(0,map.get(position)) + player + view.substring(map.get(position)+1);
                break;
            }
            else{
                System.out.println("Error!! requested position is not allowed");
                continue;
            }
        }
        while(true){
            if(check_win(view, player)==1){
                System.out.println("\n******Congratulations, Player "+player+" Wins!!! 1 point to Player "+player+"******\n");
                if (player==player1) {
                	player1_wins++;
                	player2_loses++;
                	}
                else {
                	player2_wins++;
                	player1_loses++;
                }
                System.out.println("\n          Wins   Loses    \nPlayer"+player1+":    "+player1_wins+"     "+player1_loses+"\nPlayer"+player2+":    "+player2_wins+"     "+player2_loses);
                System.out.println("\nWish to play next Game? [Y/N]");                
                answer = input.next().charAt(0);
                if(answer=='Y' || answer=='y'){
                    view = "_ _|_ _|_ _\n_ _|_ _|_ _\n   |   |   ";
                    break;
                }
                else{
                    System.out.println("\n*******Thanks For Playing TicTacToe*********");
                    return;
                }
            }
            else if(check_win(view, player2) == 2)
            {
                System.out.println("*******It's been a tough fight and resulted as a Draw!!! Unfortunately no points to anyone********");
                System.out.println("\n          Wins   Loses    \nPlayer"+player+":    "+player1_wins+"     "+player1_loses+"\nPlayer"+player+":    "+player2_wins+"     "+player2_loses);
                System.out.println("\nWish to play next Game? [Y/N]");                
                answer = input.next().charAt(0);
                if(answer=='Y' || answer=='y'){
                    view = "_ _|_ _|_ _\n_ _|_ _|_ _\n   |   |   ";
                    break;
                }
            }
            else
                break;
        }       
    }    
}
static int check_win(String view, char player){

    if((view.charAt(1)==view.charAt(5) && view.charAt(1)==view.charAt(9) && view.charAt(1)==player && view.charAt(1)!=' ') ||
        (view.charAt(13)==view.charAt(17) && view.charAt(13)==view.charAt(21) && view.charAt(13)==player && view.charAt(13)!=' ')||
        (view.charAt(25)==view.charAt(29) && view.charAt(25)==view.charAt(33) && view.charAt(25)==player && view.charAt(25)!=' ')|| 
        (view.charAt(5)==view.charAt(17) && view.charAt(5)==view.charAt(29) && view.charAt(5)==player && view.charAt(5)!=' ')||
        (view.charAt(9)==view.charAt(21) && view.charAt(9)==view.charAt(33) && view.charAt(9)==player && view.charAt(9)!=' ')||
        (view.charAt(1)==view.charAt(17) && view.charAt(1)==view.charAt(33) && view.charAt(1)==player && view.charAt(1)!=' ')||
        (view.charAt(1)==view.charAt(13) && view.charAt(1)==view.charAt(25) && view.charAt(1)==player && view.charAt(1)!=' ')|| 
        (view.charAt(17)==view.charAt(9) && view.charAt(17)==view.charAt(25) && view.charAt(17)==player && view.charAt(17)!=' '))
        return 1;
    else if(view.charAt(1)!=' ' && view.charAt(5)!=' ' && view.charAt(9)!=' ' && view.charAt(13)!=' ' && view.charAt(17)!=' ' && 
        view.charAt(21)!=' ' && view.charAt(25)!=' ' && view.charAt(29)!=' ' && view.charAt(33)!=' ')
        return 2;
    else
        return 3;
}
}