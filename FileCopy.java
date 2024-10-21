import java.io.*;

public class FileCopy {
    public static void main(String[] args){
        try{
            FileInputStream fis = new FileInputStream("input.txt");
            FileOutputStream fos = new FileOutputStream("output.txt");
            int c;
            while((c = fis.read()) != -1){
                fos.write(c);
            }
            fis.close();
            fos.close();
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
}
