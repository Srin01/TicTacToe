package com.TicTacToe2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SinglePlayer
{
    public static int playerScore = 0;
    private static final Random RANDOM = new Random();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    int singleplayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        {
            Music music = new Music();
            Board b = new Board();
            Scanner scanner = new Scanner(System.in);
            System.out.println(ANSI_BLUE  + "                       Select Mode:\n" + ANSI_GREEN + "                       1. Easy\n" + ANSI_RED + "                       2, Hard" + ANSI_RESET);
            int mode = scanner.nextInt();
            if(mode == 1)
            {
                System.out.println(ANSI_BLUE + "                       Select turn:\n"+ ANSI_GREEN + "                       1. Computer(X) \n "+ ANSI_RED + "                      2. User(O) : " + ANSI_RESET);
                music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\music_zapsplat_game_music_action_retro_8_bit_repeating_016 (online-audio-converter.com).wav");
                int choice = scanner.nextInt();

                if(choice == Board.PLAYER_X)
                {
                    Point point = new Point(RANDOM.nextInt(3), RANDOM.nextInt(3));
                    b.placeAMove(point, Board.PLAYER_X);
                    b.displayBoard();
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\zapsplat_multimedia_button_click_fast_plastic_49161 (online-audio-converter.com).wav");
                }
                while (!b.isGameOver())
                {
                    boolean moveOk = true;
                    do
                    {
                        if (!moveOk)
                        {
                            System.out.println("                        Cell Element is Filled!!!");
                            music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\leisure_retro_arcade_game_incorrect_error_tone (online-audio-converter.com).wav");
                        }
                        System.out.println(ANSI_GREEN + "                       Your Move :" + ANSI_RESET);
                        Point userMove = new Point(scanner.nextInt()-1, scanner.nextInt()-1);
                        moveOk = b.placeAMove(userMove, Board.PLAYER_O);
                    } while (!moveOk);
                    clrscr();
                    b.displayBoard();
                    if (b.isGameOver())
                        break;
                    Point point = new Point(RANDOM.nextInt(3), RANDOM.nextInt(3));
                    System.out.println("                        Computer choose position " + point);

                    b.placeAMove(point, Board.PLAYER_X);
                    b.displayBoard();
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\zapsplat_multimedia_button_click_fast_plastic_49161 (online-audio-converter.com).wav");
                }
                if(b.hasPlayerWon(Board.PLAYER_X))
                {
                    System.out.println(BLUE_BOLD_BRIGHT + "                     You Lost , Sorry ;(" + ANSI_RESET);
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\lost.wav");
                }
                else if(b.hasPlayerWon(Board.PLAYER_O))
                {
                    System.out.println("                        You Win !");
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\arcade-climb_tone_002 (online-audio-converter.com).wav");
                    playerScore++;
                    return playerScore;
                }
                else
                {
                    System.out.println(PURPLE_BOLD_BRIGHT + "                        Its a Tie!!!!!!!!!!!" + ANSI_RESET);
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\tie.wav");
                }
            }
            else if(mode == 2)
            {
                System.out.println("                        Select turn:\n1,                        Computer(X)\n                        2. User(O) : ");
                music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\music_zapsplat_before_the_storm_125 (online-audio-converter.com).wav");

                int choice = scanner.nextInt();

                if(choice == Board.PLAYER_X)
                {
                    Point point = new Point(RANDOM.nextInt(3), RANDOM.nextInt(3));
                    b.placeAMove(point, Board.PLAYER_X);
                    b.displayBoard();
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\zapsplat_multimedia_button_click_fast_plastic_49161 (online-audio-converter.com).wav");
                }
                while (!b.isGameOver())
                {
                    boolean moveOk = true;
                    do
                    {
                        if(!moveOk)
                        {
                            System.out.println("                        Cell Element is Filled!!!");
                            music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\leisure_retro_arcade_game_incorrect_error_tone (online-audio-converter.com).wav");
                        }
                        System.out.println("                        Your Move :");
                        Point userMove = new Point(scanner.nextInt()-1, scanner.nextInt()-1);
                        moveOk = b.placeAMove(userMove, Board.PLAYER_O);
                    }while (!moveOk);
                    clrscr();
                    b.displayBoard();
                    if(b.isGameOver())
                        break;
                    b.minimax(0, Board.PLAYER_X);
                    System.out.println("                        Computer choose position " + b.ComputerMove);

                    b.placeAMove(b.ComputerMove, Board.PLAYER_X);
                    b.displayBoard();
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\zapsplat_multimedia_button_click_fast_plastic_49161 (online-audio-converter.com).wav");
                }
                if(b.hasPlayerWon(Board.PLAYER_X))
                {
                    System.out.println(BLUE_BOLD_BRIGHT + "                     You Lost , Sorry ;(" + ANSI_RESET);
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\lost.wav");
                }
                else if(b.hasPlayerWon(Board.PLAYER_O))
                {
                    System.out.println("                        You Win !");
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\arcade-climb_tone_002 (online-audio-converter.com).wav");
                    playerScore ++;
                    return playerScore;
                }
                else
                {
                    System.out.println(PURPLE_BOLD_BRIGHT + "                        Its a Tie!!!!!!!!!!!" + ANSI_RESET);
                    music.playMusic("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\tie.wav");
                }
            }
        }
        return playerScore;
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
