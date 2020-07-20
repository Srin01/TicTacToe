package com.TicTacToe2;

import java.util.Random;
import java.util.Scanner;

public class MultiPlayer
{
    private static final Random RANDOM = new Random();

    void multiPlayer()
    {
        Board b = new Board();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select turn:\n1, Player1(X) / 2. Player2 (O) : ");

        int choice = scanner.nextInt();

        if (choice == Board.PLAYER_X)
        {

            while (!b.isGameOver())
            {
                boolean moveOk = true;
                do
                {
                    if (!moveOk)
                    {
                        System.out.println("Cell Element is Filled!!!");
                    }
                    System.out.println("Player1 move :");
                    Point userMove = new Point(scanner.nextInt() - 1, scanner.nextInt() - 1);
                    moveOk = b.placeAMove(userMove, Board.PLAYER_X);
                } while (!moveOk);
                b.displayBoard();
                if (b.isGameOver())
                    break;
                do
                {
                    if (!moveOk)
                    {
                        System.out.println("Cell Element is Filled!!!");
                    }
                    System.out.println("Player2 move :");
                    Point userMove = new Point(scanner.nextInt() - 1, scanner.nextInt() - 1);
                    moveOk = b.placeAMove(userMove, Board.PLAYER_O);
                } while (!moveOk);
                b.displayBoard();
            }

            if (b.hasPlayerWon(Board.PLAYER_X))
                System.out.println("Player1 Won!!! ");
            else if (b.hasPlayerWon(Board.PLAYER_O))
            {
                System.out.println("Player2 Won !");
            } else
                System.out.println("Its a Tie!!!!!!!!!!!");
        }
        else
        {
            while (!b.isGameOver())
            {
                boolean moveOk = true;
                do
                {
                    if (!moveOk)
                    {
                        System.out.println("Cell Element is Filled!!!");
                    }
                    System.out.println("Player1 move :");
                    Point userMove = new Point(scanner.nextInt() - 1, scanner.nextInt() - 1);
                    moveOk = b.placeAMove(userMove, Board.PLAYER_O);
                } while (!moveOk);
                b.displayBoard();
                if (b.isGameOver())
                    break;
                do
                {
                    if (!moveOk)
                    {
                        System.out.println("Cell Element is Filled!!!");
                    }
                    System.out.println("Player2 move :");
                    Point userMove = new Point(scanner.nextInt() - 1, scanner.nextInt() - 1);
                    moveOk = b.placeAMove(userMove, Board.PLAYER_X);
                } while (!moveOk);
                b.displayBoard();
            }

            if (b.hasPlayerWon(Board.PLAYER_X))
                System.out.println("Player1 Won!!! ");
            else if (b.hasPlayerWon(Board.PLAYER_O))
            {
                System.out.println("Player2 Won !");
            } else
                System.out.println("Its a Tie!!!!!!!!!!!");
        }
    }

}
