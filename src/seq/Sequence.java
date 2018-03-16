package seq;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jonathanschmitz
 *
 */
/**
 * @author jonathanschmitz
 *
 */
public class Sequence {
	private Integer length;
	private String seq;
	private String id;
	private String seqType = "undef.";

	/**
	 * @return Type of sequence: DNA, RNA, or amino acid
	 */
	public String getSeqType() {
		return seqType;
	}

	/**
	 * @param seqType Set type of sequence to seqType
	 */
	public void setSeqType(String seqType) {
		this.seqType = seqType;
	}

	/**
	 * @return Return number of residues in sequence.
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * @param length Length to set sequence to. Should only be called during construction.
	 */
	private void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * @param seq String to construct Sequence from.
	 */
	public Sequence(String seq) {
		this.setSeq(seq);
		this.setLength(seq.length());
	}

	/**
	 * @param seq String to construct Sequence from
	 * @param id ID to set.
	 */
	public Sequence(String seq, String id) {
		this.setSeq(seq);
		this.setLength(seq.length());
		this.setId(id);
	}

	/**
	 * @return String of sequences' residues.
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq String to set sequence to
	 * 
	 * Only to be called during construction.
	 */
	private void setSeq(String seq) {
		this.seq = seq;
	}

	public static void main(String[] args) {
		ArrayList<Sequence> seqList = new ArrayList<Sequence>(Arrays.asList(new Sequence("A"), new Sequence("B")));
		Sequence outseq = Utils.join(seqList);
		System.out.println(outseq.getSeq());
	}

	@Override
	public boolean equals(Object comp) {
		if (!(comp instanceof Sequence)) {
			return false;
		}
		Sequence seqComp = (Sequence) comp;
		if (this.getSeq().equals(seqComp.getSeq())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.getSeq().hashCode();
	}

	/**
	 * @return ID of sequence
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id Set ID of sequence
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param start Start index of subsequence
	 * @param stop Stop index of subsequence
	 * @return Sequence object representing the subsequence from start to stop.
	 */
	public Sequence getSubseq(int start, int stop) {
		return new Sequence(this.seq.substring(start, stop));
	}

	/**
	 * @param stop Stop index of subsequence
	 * @return Sequence object representing the subsequence from start of the sequence to stop.
	 */
	public Sequence getSubseq(int stop) {
		return this.getSubseq(0, stop);
	}
	
	public String toString() {
		String outSeq = this.seq;
		int outSeqLen = outSeq.length();
		if (outSeqLen > 60) 
			outSeq = outSeq.substring(0, 28) + "..." + outSeq.substring(outSeqLen - 28);
		String outStr = "Seq Obj: " + this.id + ", " + this.seqType + ", " + outSeq;
		return outStr;
	}
}
