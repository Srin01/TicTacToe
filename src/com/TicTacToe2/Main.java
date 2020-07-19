package com.TicTacToe2;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import java.io.FileInputStream;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static final Random RANDOM = new Random();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
	// write your code here
        Music music = new Music();
        //PlayStartingMusic
        music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\starting1.wav");

        Board b = new Board();
        Scanner scanner = new Scanner(System.in);
        b.displayBoard();
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
                        System.out.println("Cell ELement is Filled!!!");
                    }
                    System.out.println("Your Move :");
                    Point userMove = new Point(scanner.nextInt(), scanner.nextInt());
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
                    System.out.println("You Lost , Sorry ;(");
                else if(b.hasPlayerWon(Board.PLAYER_O))
                    System.out.println("You Win !");
                else
                    System.out.println("Its a Tie!!!!!!!!!!!");
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
                        System.out.println("Cell ELement is Filled!!!");
                    }
                    System.out.println("Your Move :");
                    Point userMove = new Point(scanner.nextInt(), scanner.nextInt());
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
                System.out.println("You Lost , Sorry ;(");
            else if(b.hasPlayerWon(Board.PLAYER_O))
                System.out.println("You Win !");
            else
                System.out.println("Its a Tie!!!!!!!!!!!");
        }
    }
}
