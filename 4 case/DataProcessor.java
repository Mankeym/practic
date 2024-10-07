import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DataProcessor {
    private List<String> data;

    public DataProcessor(String fileName) {
        data = new ArrayList<>();
        readDataFromFile(fileName);
    }

    private void readDataFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
          
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        System.out.println(data);
    }

    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor("data.txt");
        processor.processData();
    }

    
    public void processData() {
        data.sort((a, b) -> a.compareTo(b));
        for (String line : data) {
            System.out.println(line);
        }
    }
    
    public void saveDataToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : data) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
                System.err.println("Ошибка записи файла: " + e.getMessage());
        }
    }
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите данные: ");
        String input = scanner.nextLine();
        data.add(input);
        saveDataToFile("data.txt");
    }   

}



