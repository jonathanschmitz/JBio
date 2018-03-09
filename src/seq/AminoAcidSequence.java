package seq;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AminoAcidSequence extends Sequence {
	public static final Set<Character> AminoAcids = new HashSet<>(Arrays.asList('A', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'Y', '*', 'U' // Also allow * for stop codons and U
																					// for Selenocystein, these are
																					// somewhat common
	));
	// TODO does this make sense: I don't want to reinitialise this
	public static final hydrophobicityTable hydroTable = new hydrophobicityTable();

	private void checkSeq() {
		Set<Character> stringBases = new HashSet<Character>(AminoAcidSequence.AminoAcids);
		for (Character c : this.getSeq().toCharArray())
			stringBases.add(c);
		if (!stringBases.equals(AminoAcidSequence.AminoAcids))
			throw new java.lang.RuntimeException(
					"Trying to create Amino Acid sequence containing non-Amino Acid Characters");
	}

	public AminoAcidSequence(String string) {
		super(string);
		this.checkSeq();
		this.setSeqType("AminoAcid");
	}

	public AminoAcidSequence(Sequence seq) {
		super(seq.getSeq());
		this.checkSeq();
		this.setSeqType("AminoAcid");
	}

	public float hydrophobicity() {
		float hyd = 0;
		for (Character aminoAcid : this.getSeq().toCharArray()) {
			hyd += hydroTable.get(aminoAcid);
		}
		return hyd / this.getLength();
	}

	public float[] hydrophobicityWindow() {
		return this.hydrophobicityWindow(19);
	}

	public float[] hydrophobicityWindow(int windowSize) {
		int windowNum = this.getLength() - windowSize;
		float[] windows = new float[windowNum + 1];
		for (int i = 0; i <= windowNum; i++) {
			AminoAcidSequence subSeq = new AminoAcidSequence(this.getSubseq(i, i + windowSize));
			windows[i] = subSeq.hydrophobicity();
		}
		return windows;
	}
}
