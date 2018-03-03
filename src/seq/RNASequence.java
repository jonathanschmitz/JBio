package seq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RNASequence extends Sequence {

	TranslateTable table = new TranslateTable();
	public static final Set<Character> RNABases = new HashSet<>(Arrays.asList('A', 'C', 'G', 'U'));

	public RNASequence(String seq) {
		super(seq);
		Set<Character> stringBases  = new HashSet<Character>();
		for (Character c: seq.toCharArray())
			stringBases.add(c);
		if (!stringBases.equals(RNASequence.RNABases))
			throw new java.lang.RuntimeException(
					"Trying to create RNA sequence containing non-RNA Characters");
	}

	public AminoAcidSequence translate() {
		ArrayList<Sequence> outList = new ArrayList<Sequence>();
		String sequence = this.getSeq();
		for (int i = 0, l = sequence.length() - 2; i < l; i+=3) {
			String codon = sequence.substring(i, i+3);
			AminoAcidSequence translation = table.translate(codon);
			outList.add(translation);
		}

		// TODO How to avoid this? Or is this OK?
		Sequence transSequence = Utils.join(outList);
		return new AminoAcidSequence(transSequence.getSeq());
	}

}
