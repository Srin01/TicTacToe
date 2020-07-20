package com.TicTacToe2;
import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;

public class Main
{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN

    public static int playerscore;
    public static int highScore;
    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
        Music music = new Music();
        Board b = new Board();
        Scanner scanner = new Scanner(System.in);
        HighScore highScore1 = new HighScore();
        boolean playAgain = true;
        //PlayStartingMusic
        System.out.println( "                        Welcome To TIC_TAC_TOE" );
        System.out.println("                                    1.PlayGame");
        System.out.println("                                    2.Exit");
        int chance = scanner.nextInt();
        if(chance == 1)
        {
            while(playAgain)
            {
                clrscr();
                b.displayBoard();
                highScore = Integer.parseInt(highScore1.displayHighScore());
                System.out.println("                        HighScore Secured is : " + highScore);
                System.out.println( ANSI_PURPLE+"                       1 Single Player\n" +ANSI_CYAN + "                       2 Multiplayer" + ANSI_RESET);
                music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\arcade-climb_tone_002 (online-audio-converter.com).wav");
                int player = scanner.nextInt();
                if(player == 1)
                {
                    SinglePlayer singlePlayer1 = new SinglePlayer();
                    playerscore = singlePlayer1.singleplayer();
                    clrscr();
                    if(playerscore> highScore)
                    {
                        highScore = playerscore;
                        System.out.println(ANSI_CYAN + "                        You secured High Score"+ ANSI_RESET);
                        highScore1.addHighScore(highScore);
                        highScore = Integer.parseInt(highScore1.displayHighScore());
                    }
                    System.out.println(ANSI_PURPLE + "                        Wanna Play Again???? (1 for yes/2 for no)" + ANSI_RESET);
                    int s  = scanner.nextInt();
                    if(s == 1)
                        playAgain = true;
                    else
                        playAgain = false;
                }

                else
                {
                    MultiPlayer multiPlayer1 = new MultiPlayer();
                    playerscore = multiPlayer1.multiPlayer();
                    if(playerscore> highScore)
                    {
                        highScore = playerscore;
                        System.out.println(ANSI_CYAN + "                        You secured High Score"+ ANSI_RESET);
                        highScore1.addHighScore(highScore);
                        highScore = Integer.parseInt(highScore1.displayHighScore());
                    }
                    System.out.println(ANSI_PURPLE + "                        Wanna Play Again???? (1 for yes/2 for no)" + ANSI_RESET);
                    int s  = scanner.nextInt();
                    if(s == 1)
                        playAgain = true;
                    else
                        playAgain = false;
                }
            }
        }
        else
        {
            System.exit(0);
        }

    }
    public static void clrscr()
    {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else
                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {}
    }
}
