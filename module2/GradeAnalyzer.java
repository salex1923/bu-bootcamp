import java.io.*; 
import java.util.ArrayList;
import java.util.Scanner;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of your file? ");
        String filename = scanner.nextLine();
        System.out.println("File name: " + filename);
        System.out.println("=== Reading File ===");
        scanner.close();

        ArrayList<Integer> scores = new ArrayList<>();
        
        try {
            scores = readScores(filename);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Scores extracted: " + scores);
        System.out.println();
        
        // Average
        double stats = calculateAverage(scores);

        // Min and Max grades
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        for(int i = 0; i < scores.size(); i++) {
            if(scores.get(i) > highest) {
                highest = scores.get(i);
            }

            if(scores.get(i) < lowest) {
                lowest = scores.get(i);
            }
        }

        // Grade Band Count
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;
        
        for(int i=0; i<scores.size(); i++) {
            if(scores.get(i)>=90) {
                countA++;
            } else if(scores.get(i)>=80) {
                countB++;
            } else if(scores.get(i)>=70) {
                countC++;
            } else if(scores.get(i)>=60) {
                countD++;
            } else {
                countF++;
            }
        }

        System.out.println("See output.txt for results!");

        // Step 3: write and print report
        writeReport(scores, stats, highest, lowest, countA, countB, countC, countD, countF, "output.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        String line;
        ArrayList<Integer> scores = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while((line = reader.readLine()) != null) {
                if(line.isEmpty()) {
                    System.out.println("Line is empty, skipping...");
                    continue;
                } else {
                    try {
                        int n = Integer.parseInt(line.trim());
                        scores.add(n);
                    } catch (NumberFormatException e) {
                        System.out.println(line + " is not a number, skipping...");
                        continue;
                    }
                }
            } 
        } catch (IOException e) {
                System.out.println("Error reading file.");
        } 
        if(scores.isEmpty()){
            throw new IllegalArgumentException(filename + " is empty or contains invalid scores.");
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()) {
            return 0.0;
        } else {
            int total = 0;
            for(int i = 0; i < scores.size(); i++) {
                total += scores.get(i);
            }
            return total / scores.size();
        }
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   int A, int B, int C, int D, int F,
                                   String outputFile) {
        // your code here
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("==== Grade Analysis Report ====");
            writer.newLine();
            writer.write("Total scores processed: " + scores.size());
            writer.newLine();
            writer.newLine();
            writer.write(String.format("Average score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score: %d%n", low));
            writer.newLine();
            writer.write("Grade distribution:");
            writer.newLine();
            writer.write(String.format("A (90-100): %d%n", A));
            writer.write(String.format("B (80-89): %d%n", B));
            writer.write(String.format("C (70-79): %d%n", C));
            writer.write(String.format("D (60-69): %d%n", D));
            writer.write(String.format("F (below 60): %d%n", F));
        } catch (IOException e) {
            System.out.println("Nothing to analyze!");
        }
    }
} 
