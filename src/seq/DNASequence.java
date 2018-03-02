package seq;

import java.util.ArrayList;

public class DNASequence extends Sequence {
	
	public AminoAcidSequence translate(DNASequence seq) {
		TranslateTable table = new TranslateTable();
		ArrayList<AminoAcidSequence> outList = new ArrayList<AminoAcidSequence>();
		for (int i = 0, l = seq.getSeq().length(); i < l; i++) {
			Character base = seq.getSeq().charAt(i);
			AminoAcidSequence translation = table.baseToAA.get(base);
			outList.add(translation);
		}
	}
	
	public DNASequence(String string) {
		super(string);
	}
}
