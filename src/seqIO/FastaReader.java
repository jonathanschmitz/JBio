package seqIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import seq.Sequence;
import seq.Utils;

public class FastaReader {
	private static Map<String, Sequence> read(String fastaPath) {
		Map<String, Sequence> seqMap = new HashMap<String, Sequence>();
		List<String> keys = new ArrayList<String>();
		String key = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fastaPath));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.charAt(0) == '>') {
					if (!key.isEmpty()) {
						// save the previous entry!

					}
					key = line.split(" ")[0].substring(1);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return seqMap;
	}
	
	void saveSeq(String key, ArrayList<Sequence> seqList, Map<String, Sequence> map) {
		Sequence seq = Utils.join(seqList);
		map.put(key, seq);
	}

	public static void main(String[] args) {

		String[] args2 = { "/Users/jonathanschmitz/stuff/java-test/test.fasta" };
		if (args.length != 1) {
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