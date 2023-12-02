package org.mrityunjoy24;

import org.mrityunjoy24.commands.CommandInvoker;
import org.mrityunjoy24.config.AppConfig;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        AppConfig appConfig = new AppConfig();
        CommandInvoker commandInvoker = appConfig.getCommandInvoker();

        File file = new File("src/main/java/org/mrityunjoy24/input1.txt");

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            try {
                String data = sc.nextLine();

                List<String> tokens = List.of(data.split(" "));

                String response = commandInvoker.getCommandByName(tokens.get(0)).execute(tokens);
                System.out.println(response);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}