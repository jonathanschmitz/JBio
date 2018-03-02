package seqIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FastaReader {
    private static List<String> read(String fastaPath) {
        List<String> keys = new ArrayList<String> ();
        try {
          BufferedReader reader = new BufferedReader(new FileReader(fastaPath));
          String line;
          while((line = reader.readLine()) != null) {
              if (line.charAt(0) == '>'){
                  String key = line.split(" ")[0].substring(1);
                  keys.add(key);
              }
          }
          reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keys;
    }


    public static void main(String[] args) {

		String[] args2 = {"/Users/jonathanschmitz/stuff/java-test/test.fasta"};
        if (args.length != 1){
            // System.out.println("USAGE: FastaReader <fasta_path>");
        }
		String fastaPath = args2[0];
		System.out.println(fastaPath);
		List<String> ids = read(fastaPath);
		for (String id : ids) {
			System.out.println(id);
		}
    }
}