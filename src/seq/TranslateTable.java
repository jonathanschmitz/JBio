package seq;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TranslateTable {
	private static String tablePath = TranslateTable.class.getResource("../StaticFiles/CodonTable.csv").getFile();
	public static final Map<Sequence, AminoAcidSequence> baseToAA;
	static {
		baseToAA = new HashMap<Sequence, AminoAcidSequence>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(tablePath));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineSplit = line.split(",");
				String codon = lineSplit[0];
				String aa = lineSplit[1];
				baseToAA.put(new Sequence(codon), new AminoAcidSequence(aa));
				if (codon.contains("T")) {
					String uCodon = codon.replace('T', 'U');
					baseToAA.put(new Sequence(uCodon), new AminoAcidSequence(aa));
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AminoAcidSequence translate(String codon) {
		AminoAcidSequence aa = baseToAA.get(new Sequence(codon));
		return aa;
	}

	public static void main(String[] args) {
		TranslateTable table = new TranslateTable();
	}
}
