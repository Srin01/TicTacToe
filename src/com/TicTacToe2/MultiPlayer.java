package com.TicTacToe2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MultiPlayer
{
    public static int playerScore = 0;
    private static final Random RANDOM = new Random();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";


    int multiPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        Board b = new Board();
        Music music = new Music();
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_BLUE + "                       Select turn:\n" + ANSI_GREEN+"                       1, Player1(X)\n"+ ANSI_RED+"                       2. Player2 (O) : "+ ANSI_RESET);

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
                        System.out.println("                       Cell Element is Filled!!!");
                    }
                    System.out.println("                       Player1 move :");
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
                        System.out.println("                       Cell Element is Filled!!!");
                    }
                    System.out.println("                       Player2 move :");
                    Point userMove = new Point(scanner.nextInt() - 1, scanner.nextInt() - 1);
                    moveOk = b.placeAMove(userMove, Board.PLAYER_O);
                } while (!moveOk);
                b.displayBoard();
            }

            if (b.hasPlayerWon(Board.PLAYER_X))
            {
                System.out.println("                       Player1 Won!!! ");
                music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\arcade-climb_tone_002 (online-audio-converter.com).wav");
                playerScore ++;
                return playerScore;
            }
            else if (b.hasPlayerWon(Board.PLAYER_O))
            {
                System.out.println("                       Player2 Won !");
                music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\arcade-climb_tone_002 (online-audio-converter.com).wav");
                playerScore ++;
                return playerScore;
            } else
            {
                System.out.println("                       Its a Tie!!!!!!!!!!!");
                music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\tie.wav");
            }
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
                    System.out.println("                       Player1 move :");
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\arcade-climb_tone_002 (online-audio-converter.com).wav");
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
                        System.out.println("                       Cell Element is Filled!!!");
                    }
                    System.out.println("                       Player2 move :");
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\arcade-climb_tone_002 (online-audio-converter.com).wav");
                    Point userMove = new Point(scanner.nextInt() - 1, scanner.nextInt() - 1);
                    moveOk = b.placeAMove(userMove, Board.PLAYER_X);
                } while (!moveOk);
                b.displayBoard();
            }

            if (b.hasPlayerWon(Board.PLAYER_X))
            {
                System.out.println("                       Player1 Won!!! ");
                music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\arcade-climb_tone_002 (online-audio-converter.com).wav");
                playerScore ++;
                return playerScore;
            }
            else if (b.hasPlayerWon(Board.PLAYER_O))
            {
                System.out.println("                       Player2 Won !");
                music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\arcade-climb_tone_002 (online-audio-converter.com).wav");
                playerScore++;
                return playerScore;
            } else
            {
                System.out.println("                       Its a Tie!!!!!!!!!!!");
                music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\tie.wav");
            }
        }
        return playerScore;
    }

}
