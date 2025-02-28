import java.io.*;
import java.util.Scanner;

public class FileStorage {
    private static final String FILE_NAME = "account_data.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your account name: ");
        String name = scanner.nextLine();
        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();

        saveAccountToFile(name, balance);
        System.out.println("Saved account to file!");
        scanner.close();
    }

    private static void saveAccountToFile(String name, double balance) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(name + "," + balance);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
