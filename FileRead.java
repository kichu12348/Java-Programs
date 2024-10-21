import java.io.*;

public class FileRead {
    public static void main(String args[]){
        try{
            FileReader fr=new FileReader("input.txt");
            BufferedReader br=new BufferedReader(fr);
            String line = "";
            int lineNo=1;
            while (line!=null) {
                line = br.readLine();
                if(line==null) break;
                System.out.println(lineNo + ". " + line);
                lineNo++;
            }
            
            br.close(); 
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
}
