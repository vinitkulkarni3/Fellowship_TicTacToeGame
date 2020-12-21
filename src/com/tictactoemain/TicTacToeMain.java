package com.tictactoemain;

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
    //Main Method
    public static void main(String[] args) 
    {
        System.out.println("+-+-+ WELCOME TO TIC TAC TOE GAME +-+-+");
        
        char storeBoard[] = createBoard(); //Calling the Create Board
    }
}
