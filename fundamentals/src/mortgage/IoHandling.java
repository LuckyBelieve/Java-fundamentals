package mortgage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoHandling {
    public static String Reversing(String line) {
        List<Character> reversedLine = new ArrayList<>();
        for (int i = line.length() - 1; i >= 0; i--) {
            char c = line.charAt(i);
            reversedLine.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : reversedLine) {
            sb.append(c);
        }
        return (String.valueOf(sb));
    }

    public static void main(String[] args) {
        String fileInput = "input.txt";
        String fileOutput = "output.txt";
        List<String> lines = new ArrayList<>();
        try {
            File outputFile = new File(fileOutput);
            if (outputFile.createNewFile()) {
                System.out.println("The file Output created");
            } else {
                System.out.println("The output file already exists");
            }
            FileWriter writer = new FileWriter(outputFile);
            BufferedWriter buff = new BufferedWriter(writer);
            BufferedReader in = new BufferedReader(new FileReader(fileInput));
            String str;
            while ((str = in.readLine()) != null) {
                lines.add(str);
            }
            for (String line : lines) {
                String reversed = Reversing(line);
                System.out.println(reversed);
                buff.write(reversed);
                buff.newLine();
            }
            buff.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("exception:" + e);
        }
    }
}
