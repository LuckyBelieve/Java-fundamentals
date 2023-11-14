package I0Streams;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferReader {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new BufferedReader(new FileReader("districts.txt")));
        scan.useDelimiter(",");
        while(scan.hasNext()){
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] tokens = line.split(",");

                String districtNo = tokens[0].trim();
                String district = tokens[1].trim();
                String provinceNo = tokens[2].trim();
                String province = tokens[3].trim();

                System.out.println("DistrictNo: " + districtNo);
                System.out.println("District: " + district);
                System.out.println("ProvinceNo: " + provinceNo);
                System.out.println("Province: " + province);
            }
        }
    }
}

