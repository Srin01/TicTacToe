package com.TicTacToe2;

import java.util.Random;
import java.util.Scanner;

public class SinglePlayer
{
    private static final Random RANDOM = new Random();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    void singleplayer()
    {
        {
            Board b = new Board();
            Scanner scanner = new Scanner(System.in);
            System.out.println(ANSI_BLUE  + "Select Mode:\n" + ANSI_GREEN + "1, Easy\n" + ANSI_RED + "2, Hard" + ANSI_RESET);
            int mode = scanner.nextInt();
            if(mode == 1)
            {
                System.out.println("Select turn:\n1, Computer(X) / 2. User(O) : ");

                int choice = scanner.nextInt();

                if(choice == Board.PLAYER_X)
                {
                    Point point = new Point(RANDOM.nextInt(3), RANDOM.nextInt(3));
                    b.placeAMove(point, Board.PLAYER_X);
                    b.displayBoard();
                }
                while (!b.isGameOver())
                {
                    boolean moveOk = true;
                    do
                    {
                        if (!moveOk)
                        {
                            System.out.println("Cell Element is Filled!!!");
                        }
                        System.out.println("Your Move :");
                        Point userMove = new Point(scanner.nextInt()-1, scanner.nextInt()-1);
                        moveOk = b.placeAMove(userMove, Board.PLAYER_O);
                    } while (!moveOk);

                    b.displayBoard();
                    if (b.isGameOver())
                        break;
                    Point point = new Point(RANDOM.nextInt(3), RANDOM.nextInt(3));
                    System.out.println("Computer choose position " + point);

                    b.placeAMove(point, Board.PLAYER_X);
                    b.displayBoard();
                }
                if(b.hasPlayerWon(Board.PLAYER_X))
                    System.out.println(BLUE_BOLD_BRIGHT + "You Lost , Sorry ;(" + ANSI_RESET);
                else if(b.hasPlayerWon(Board.PLAYER_O))
                {
                    System.out.println("You Win !");
                }
                else
                    System.out.println(PURPLE_BOLD_BRIGHT +"Its a Tie!!!!!!!!!!!" + ANSI_RESET);
            }
            else if(mode == 2)
            {
                System.out.println("Select turn:\n1, Computer(X) / 2. User(O) : ");

                int choice = scanner.nextInt();

                if(choice == Board.PLAYER_X)
                {
                    Point point = new Point(RANDOM.nextInt(3), RANDOM.nextInt(3));
                    b.placeAMove(point, Board.PLAYER_X);
                    b.displayBoard();
                }
                while (!b.isGameOver())
                {
                    boolean moveOk = true;
                    do
                    {
                        if(!moveOk)
                        {
                            System.out.println("Cell Element is Filled!!!");
                        }
                        System.out.println("Your Move :");
                        Point userMove = new Point(scanner.nextInt()-1, scanner.nextInt()-1);
                        moveOk = b.placeAMove(userMove, Board.PLAYER_O);
                    }while (!moveOk);

                    b.displayBoard();
                    if(b.isGameOver())
                        break;
                    b.minimax(0, Board.PLAYER_X);
                    System.out.println("Computer choose position " + b.ComputerMove);

                    b.placeAMove(b.ComputerMove, Board.PLAYER_X);
                    b.displayBoard();
                }
                if(b.hasPlayerWon(Board.PLAYER_X))
                    System.out.println(BLUE_BOLD_BRIGHT + "You Lost , Sorry ;(" + ANSI_RESET);
                else if(b.hasPlayerWon(Board.PLAYER_O))
                {
                    System.out.println("You Win !");
                }
                else
                    System.out.println(PURPLE_BOLD_BRIGHT +"Its a Tie!!!!!!!!!!!" + ANSI_RESET);
            }
        }
    }
}
