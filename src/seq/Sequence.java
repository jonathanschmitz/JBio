package seq;

import java.util.ArrayList;
import java.util.Arrays;

public class Sequence {
	private Integer length;
	private String seq;

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
	
	public Sequence(String seq) {
		this.setSeq(seq);
		this.setLength(seq.length());
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
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
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.getSeq().hashCode();
	}
}