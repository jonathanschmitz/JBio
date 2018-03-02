package seq;

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
}
