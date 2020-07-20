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
    public static int playerscore= 0;
    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
	// write your code here
        Music music = new Music();

        //PlayStartingMusic
        music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\starting1.wav");

        Board b = new Board();
        Scanner scanner = new Scanner(System.in);
        b.displayBoard();
        System.out.println( ANSI_PURPLE+"1 Single Player\n" +ANSI_CYAN + "2 Multiplayer" + ANSI_RESET);
        int player = scanner.nextInt();
        if(player == 1)
        {
            SinglePlayer singlePlayer1 = new SinglePlayer();
            singlePlayer1.singleplayer();
        }

        else
        {
            MultiPlayer multiPlayer1 = new MultiPlayer();
            multiPlayer1.multiPlayer();
        }
    }
}
