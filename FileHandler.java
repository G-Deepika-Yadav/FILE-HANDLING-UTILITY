import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileHandler {
    public static void main(String[] args) {
        String filePath = "example.txt";
        writeToFile(filePath, "Hello, World!\nThis is a sample text file.\n");
        System.out.println("Reading from file:");
        List<String> lines = readFromFile(filePath);
        for (String line : lines) {
            System.out.println(line);
        }
        appendToFile(filePath, "This line is appended to the file.\n");
        System.out.println("\nReading from file after modification:");
        lines = readFromFile(filePath);
        for (String line : lines) {
            System.out.println(line);
        }
    }
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    public static List<String> readFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
        return lines;
    }
    public static void appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            System.out.println("Successfully appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }
    }
}