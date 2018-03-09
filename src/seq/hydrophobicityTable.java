package seq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class hydrophobicityTable {
	private static String tablePath = TranslateTable.class.getResource("../StaticFiles/hydrophobicity.csv").getFile();
	public static final Map<Character, Float> hydroTable;
	static {
		hydroTable = new HashMap<Character, Float>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(tablePath));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineSplit = line.split(",");
				Character aa = lineSplit[0].charAt(0);
				Float hydro = Float.parseFloat(lineSplit[1]);
				hydroTable.put(aa, hydro);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Float get(Character aa) {
		return hydroTable.get(aa);
	}
}
