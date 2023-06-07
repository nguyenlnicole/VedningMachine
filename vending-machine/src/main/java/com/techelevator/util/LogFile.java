package com.techelevator.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class LogFile {
    public static void log(String message) {


        PrintWriter writer;
            try {
                writer = new PrintWriter(new FileOutputStream("src/main/resources/Log.txt", true));
                writer.println(message);

                writer.close();
            } catch (FileNotFoundException e) {
                throw new LogException(e.getLocalizedMessage());
            }
        }
    }

