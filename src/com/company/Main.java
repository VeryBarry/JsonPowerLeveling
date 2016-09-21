package com.company;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static final String FILE_NAME = "SaveFile.json";
    static LevelingService levelingService = new LevelingService();


    public static void main(String[] args) {



        boolean keepRunning = true;


        while(keepRunning = true) {
            System.out.println("Welcome to the not so freebie leveling service.");
            System.out.println("watchu want foo?");
            String command = commandSystem();
            if(command == "/exit"){
                keepRunning = false;
            }


        }
    }
    static String commandSystem(){
        String line = scanner.nextLine();
        if (line.startsWith("/")){
            switch (line) {
                case "/change":
                    System.out.println("OK, let's do this. What do you want to change?");
                    System.out.println("/change current level\n/change desired level\n/change player class\n/change player server\n ");
                    break;
                case "/help":
                    System.out.println("Your options are: /save /load /change /exit");
                    break;
                case "/exit":
                    System.out.println("Exiting now...");
                    System.exit(0);
                    break;
                case "/save":
                    saveFile();
                    System.out.println("File Saved.");
                    break;
                case "/load":
                    loadFile();
                    System.out.println("File Loaded.");
                    break;
                case "/change current level":
                    System.out.println("What is your current level?");
                    String input1 = scanner.nextLine();
                    int intOfInput1 = Integer.valueOf(input1);
                    levelingService.setCurrentLevel(intOfInput1);
                    System.out.printf("Current level set to %s", intOfInput1);
                    break;
                case "/change desired level":
                    System.out.println("What is your level do you want to beeee?");
                    String input2 = scanner.nextLine();
                    int intOfinput2 = Integer.valueOf(input2);
                    levelingService.setDesiredLevel(intOfinput2);
                    System.out.printf("Desired level set to %s", intOfinput2);
                    break;
                case "/change player class":
                    System.out.println("What is your player's class?\n");
                    String input3 = scanner.nextLine();
                    levelingService.setPlayerClass(input3);
                    System.out.printf("Player class set to %s\n", input3);
                    break;
                case "/change player server":
                    System.out.println("What server are you on?");
                    String input4 = scanner.nextLine();
                    levelingService.setPlayerServer(input4);
                    System.out.printf("Server set to %s\n", input4);
                    break;
                default:
                    System.out.println("Ah ah ah, you didn't say the magic word.");
            }
            line = scanner.nextLine();
        }
        return line;
    }

    static void saveFile()  {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(levelingService);
        File f = new File("SaveGame.json");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        }catch (Exception e) {
            System.out.println("Couldn't save to file!");
        }
    }
    static void loadFile() {
        File f = new File(FILE_NAME);
        try{
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] contents = new char[fileSize];
            fr.read(contents, 0, fileSize);
            JsonParser parser = new JsonParser();
            levelingService = parser.parse(contents, LevelingService.class);
        } catch (Exception e) {
            System.out.println("Couldn't load file!");
        }
    }
}
