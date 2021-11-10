import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private ArrayList<Friend> friendList;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        String[] menuItems = new String[10]; // 10, da vi bruger 9 til quit, og index starter med 0
        Menu menu = new Menu("MENU", "Choose option:", menuItems);

        menuItems[1] = "1. Show list of friends";
        menuItems[2] = "2. Enter new friend";
        menuItems[3] = "3. Delete friend";
        menuItems[4] = "4. Save list";
        menuItems[5] = "5. Load list";
        menuItems[9] = "\n9. QUIT";

        menu.printMenu();

        int choice = menu.readChoice(); //Her laver vi metoden om til en variablen som vi kalder for choice som altså er "input"
        boolean checkChoice; //Denne boolean skal jeg bruge til at lave en do while loop fordi den skal blive ved med at spøge hvis man skriver et andet tal end 1,2,3,9.
        // fordi i readChoice() så tjekker den kun om det en integer der bliver indtastet men ikke om det er den rigtige af dem.
        do {
            switch (choice) { //Laver en switch som kontroller brugerens input
                case 1:
                    System.out.println("Showing list of friends:"); //Hvis bruger har skrevet 1 vil den sige dette
                    checkChoice = true;
                    showList();
                    run();
                case 2:
                    System.out.println("Creating new friend..."); // Hvis bruger har skrevet 2 vil den sige dette
                    checkChoice = true;
                    //enterNewFriend();
                    run();
                case 3:
                    System.out.println("You chose 3"); // Hvis bruger har skrevet 3 vil den sige dette
                    checkChoice = true;
                    run();
                case 4:
                    System.out.println("Save list:");
                    saveList();
                case 5:
                    System.out.println("Load list");
                    loadList();
                case 9:
                    System.out.println("Shutting down..."); //Hvis bruger har skrevet 9 vil den sige dette
                    checkChoice = true;
                    break;

                default: // alt andet er forkert input
                    System.out.println("\nInput has to be either 1,2,3 or 9");
                    System.out.println("Try again");
                    menu.printMenu(); //så skal den printe menuen igen
                    choice = menu.readChoice(); //så skal den køre denne metode igen
                    checkChoice = false; // her er den så false fordi så betyder det man har tastet et andet integer end 1,2,3 eller 9.
            }
        } while (!checkChoice); //Den skal blive ved med at loop så længe den er false altså en integer som ikke er 1,2,3 eller 9

    }

    public void showList() {

    }

    //public ArrayList<Friend> enterNewFriend() {
    //}


    public boolean deleteFriend(String friendName) {
        for (Friend friend : friendList) {
            if (friend.getName().equals(friendName)) {
                friendList.remove(friend);
                return true;
            }
        }
        return false;
    }

    public void saveList() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Enter your new friends name:");
            String friendName = scan.nextLine();
            System.out.println("Enter " + friendName + "'s phone number:");
            int friendPhone = scan.nextInt();
            System.out.println("Enter " + friendName + "'s email:");
            String friendEmail = scan.nextLine();

            PrintStream outFile = new PrintStream(new File("friends.txt")); // Laver en ny fil
            Friend friend = new Friend(friendName, friendPhone, friendEmail);
            outFile.println(friend); //Virker ikke på denne måde går jeg ud fra
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file for writing");
        }
    }

    public void loadList() {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("friends.txt"));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);

            }
            scan.close(); // close inputstream to save resources
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}

