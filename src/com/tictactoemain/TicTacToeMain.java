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
    
    //Is Index Free
    public static boolean isIndexFree(int index)
    {
        boolean indexFree = false;
        if(board[index] == ' ')
        {
            indexFree = true;
        }
        else
        {
            indexFree = false;
        }
        return indexFree;
    }
    
    //Is Entered Number Is Between 1 to 9
    public static boolean isIndexNumberCorrect(int index)
    {
        boolean indexNumber = false;
        if(index >= 1 && index <= 9)
        {
            indexNumber = true;
        }
        else
        {
           System.out.println("\n!!!Entered Index Not In range!!!\n");
        }
        return indexNumber;
    }
    
    //Insert At Index
    public static void insertAtIndex()
    {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while(n>0)
        {
            System.out.print("Enter the Indix you want to fill :");
            int index = sc.nextInt();
        
            boolean temp1 = isIndexNumberCorrect(index); //Method to check index between 1 to 9
            boolean temp2 = isIndexFree(index); //Method to check index is empty or not
            boolean result = true;
        
            if(temp1 == result && temp2 == result)
            {
                System.out.println("YES INDEX IS FREE");
                board[index] = 'n'; //just checking for index free or not by inserting some value
                break;
            }
            else
            {
                System.out.println("\nIndex Already Is Filled\n");
            }
        }
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
        for(int i=0; i<3; i++) //loop used for debug mode to call indexfree or not three times
            insertAtIndex();
    }
}
