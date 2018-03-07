package seq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DNASequence extends Sequence {
	// TODO is this the correct place to define this?
	TranslateTable table = new TranslateTable();
	public static final Set<Character> DNABases = new HashSet<>(Arrays.asList('A', 'C', 'G', 'T'));
	
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
	
	public DNASequence(String string) {
		super(string);
		Set<Character> stringBases  = new HashSet<Character>(DNASequence.DNABases);
		for (Character c: string.toCharArray())
			stringBases.add(c);
		if (!stringBases.equals(DNASequence.DNABases))
			throw new java.lang.RuntimeException(
					"Trying to create DNA sequence containing non-DNA Characters");
		this.setSeqType("DNA");
	}

	public static void main(String[] args) {
		DNASequence seq = new DNASequence("ATGTGA");
		System.out.println(seq.translate().getSeq());
	}
	
}
