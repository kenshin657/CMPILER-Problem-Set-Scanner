import java.io.*;
import java.util.ArrayList;

public class LexicalAnalyzer {
    public static void main(String[] args) {
        /*READ FILE LOCATION*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader0 = null;
        String filePath = null;
        ArrayList<String> lineArray = new ArrayList<>();
        ArrayList<String> lexicals = new ArrayList<>();

        try {
            filePath = reader.readLine();
            reader0 = new BufferedReader(new FileReader(filePath));

            String line = reader0.readLine();
            while (line != null) {
                //System.out.println(line);
                lineArray.add(line);
                line = reader0.readLine();
            }

            reader.close();
            reader0.close();
        } catch (IOException err) {
            err.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter("output.txt");

            for (String s : lineArray) {
                String[] fileLine = s.split(" ");
                String tmp = "";

                for (String value : fileLine) {
                    Token token = new Token(value);
                    //System.out.print(token.lexeme);
                    if (value.equals("\n") || value.equals(""))
                        continue;
                    fw.write(token.tokenType + " ");
                    //System.out.print(token.tokenType + " ");
                }
                fw.write("\n");
                //System.out.println("");

            }

            fw.close();
        }catch (IOException err) {
            err.printStackTrace();
        }



        //Token token = new Token(",DMULTU,");
        //System.out.println(token.tokenType);

    }
}
