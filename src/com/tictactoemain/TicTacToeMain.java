package com.tictactoemain;

import static java.lang.System.exit;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeMain 
{
    public static char board[] = new char[10]; //Array of Character size 10
    public static int randomNumber;
    public static char user, computer;
    
    //Random number generation
    public static void randomNumber()
    {
        int tmaxDiceValue = 2;
        int tminDiceValue = 1;
        Random trandomValue = new Random();
        int value = trandomValue.nextInt((tmaxDiceValue - tminDiceValue) + 1) + tminDiceValue;
        randomNumber = value;
        System.out.println("randomNumber->"+randomNumber);
    }
    
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
        //assing value to user and computer
        if(userInput == 'x')
        {
            user = 'x';
            computer = 'o';
        }
        else
        {
            user = 'o';
            computer = 'x';
        }
        System.out.println("user selected->"+user);
        System.out.println("computer selected->"+computer);
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
        Scanner scanInput = new Scanner(System.in);
        int n = 1;
        do
        {
            if(randomNumber == 1)
            {
                System.out.print("(user turn)");
                System.out.print("Enter the Indix you want to fill :");
                int index = 0;
                index = scanInput.nextInt();

                boolean numberCorrect = isIndexNumberCorrect(index); //Method to check index between 1 to 9
                boolean indexFree = isIndexFree(index); //Method to check index is empty or not
                boolean result = true; //initalize manual true for cheking boolean return variable values
                if(numberCorrect == result && indexFree == result)
                {
                    board[index] = user;
                    randomNumber = 0;
                    displayWinner();
                    break;
                }
                else
                {
                    System.out.println("\n!!!Index Already Filled & Choose Any Other Index!!!\n");
                }
            }
            else
            {
                System.out.print("(computer turn)");
                System.out.print("Enter the Indix you want to fill :");
                int index = 0;
                index = scanInput.nextInt();
                boolean numberCorrect = isIndexNumberCorrect(index); //Method to check index between 1 to 9
                boolean indexFree = isIndexFree(index); //Method to check index is empty or not
                boolean result = true; //initalize manual true for cheking boolean return variable values
                if(numberCorrect == result && indexFree == result)
                {
                    board[index] = computer;
                    randomNumber = 1;
                    displayWinner();
                    break;
                }
                else
                {
                    System.out.println("!!!\nIndex Already Filled & Choose Any Other Index\n!!!");
                }
            }
        }while(n>0);
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
    
    //counting which player has combination
    public static boolean isWin(char p)
    {
        int flag = 0;
        
        if(board[1] == p && board[2] == p && board[3] == p)
        {
            flag = 1;
        }
        else if(board[4] == p && board[5] == p && board[6] == p)
        {
            flag = 1;
        }
        else if(board[7] == p && board[8] == p && board[9] == p)
        {
            flag = 1;
        }
        else if(board[1] == p && board[4] == p && board[7] == p)
        {
            flag = 1;
        }
        else if(board[2] == p && board[5] == p && board[8] == p)
        {
            flag = 1;
        }
        else if(board[3] == p && board[6] == p && board[9] == p)
        {
            flag = 1;
        }
        else if(board[1] == p && board[5] == p && board[9] == p)
        {
            flag = 1;   
        }
        else if(board[3] == p && board[5] == p && board[7] == p)
        {
            flag = 1;
        }
             /* 1 2 3
                4 5 6
                7 8 9
                
                1 4 7
                2 5 8
                3 6 9
                
                1 5 9
                3 5 7 */

        if(flag == 1)
            return true;
        else
            return false;
    }
    
    //check for winner
    public static void displayWinner()
    {
        Scanner scannerOption = new Scanner(System.in);
        if(isWin(user))
        {
            System.out.println("* * * PLAYER WON * * *");
            displayBoard();
        }
        else if(isWin(computer))
        {
            System.out.println("* * * COMPUTER WON * * *");
            displayBoard();
        }
        else
        {
            System.out.println("* * * TIE * * *");
        }        
    }
    
    //Main Method
    public static void main(String[] args) 
    {
        System.out.println("+-+-+ WELCOME TO TIC TAC TOE GAME +-+-+");
       
        char showBoard[] = createBoard(); //Calling the Create Board
        
        chooseLetter(); //choose the values x and o
        randomNumber(); //generating randomNumber for who has to play first
        
        int n = 1;
        while(n>0)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n[1.INSERT 2.DISPALT 3.EXIT 4.WINNER_DISPLAY]");
            System.out.print("Select the Option : ");
            int option = sc.nextInt();

            switch(option)
            {
                case 1: try
                {
                    insertAtIndex();
                }
                catch(Exception e)
                {
                    System.out.println();
                }    
                break;

                case 2: displayBoard();
                break;

                case 3: exit(0);
                break;
                
                case 4: displayWinner();
                option = 5;
                break;

                default: System.out.println("Error");
                break;
            }
        }
    }
}
