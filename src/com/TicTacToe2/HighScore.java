package com.TicTacToe2;

import java.io.*;
import java.util.Scanner;

import static com.TicTacToe2.Main.playerscore;

public class HighScore
{
    void addHighScore(int highScore) throws IOException
    {
        String fileName = "Geek.txt";
        try {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(fileName));
            out.write(Integer.toString(highScore));
            out.close();
        }
        catch (IOException e) {
            System.out.println("Exception Occurred" + e);
        }
    }
    String displayHighScore()
    {
            try {
                File myObj = new File("C:\\Users\\srini\\IdeaProjects\\TicTacToe2\\src\\com\\TicTacToe2\\Geek.txt");
                Scanner myReader = new Scanner(myObj);
                    String data = myReader.nextLine();
                    myReader.close();
                    return data;
            } catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return " ";
    }
}
