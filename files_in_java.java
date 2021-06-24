import java.io.*;

public class files_in_java {

    public static void main(String[] args) {
        try {
            File file = new File("testDoc.txt");
            FileInputStream f = new FileInputStream(file);

            System.out.println("File Content goes here ");
            int r = 0;

            while ((r = f.read()) != -1) {
                System.out.print((char) r);
            }
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
