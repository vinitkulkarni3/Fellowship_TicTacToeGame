package com.tictactoemain;

import java.util.Scanner;

public class TicTacToeMain 
{
    public static char board[] = new char[10]; //Array of Character size 10
    
    //Creating TicTacToe Board
    public static char[] createBoard()
    {
        for(int i=1; i<board.length; i++)
        {
            board[i] = ' '; //Intialize each elements with Empty Space
        }
        return board;
    }
    
    //Choose the X or O letter 
    public static void chooseLetter()
    {
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Choose small letter 'x' or 'o' : ");
        char userInput = scanInput.next().charAt(0); //taking input from user
        if(userInput == 'x' || userInput == 'o')
        {
            userInput = ( userInput == 'x')? 'x' : 'o';  //checking the condition
        }
        else
        {
            System.out.println("\n!!!Select x or o only!!!\n");
        }
        System.out.println("Selected letter is -> "+userInput);
    }
    
    //display the board
    public static void displayBoard()
    {
        System.out.print(board[1]+"|"+board[2]+"|"+board[3]+"|");
        System.out.println();
        System.out.print(board[4]+"|"+board[5]+"|"+board[6]+"|");
        System.out.println();
        System.out.print(board[7]+"|"+board[8]+"|"+board[9]+"|");
        System.out.println();
    }
    
    //Main Method
    public static void main(String[] args) 
    {
        System.out.println("+-+-+ WELCOME TO TIC TAC TOE GAME +-+-+");
        
        char storeBoard[] = createBoard(); //Calling the Create Board
        chooseLetter(); //choose the values x and o
        displayBoard();
    }
}
