package seq;

import java.util.ArrayList;

public class Utils {
	public static Sequence join(ArrayList<Sequence> seqList) {
		StringBuilder builder = new StringBuilder();
		for (Sequence seq : seqList)
			builder.append(seq.getSeq());
		Sequence outseq = new Sequence(builder.toString());
		return outseq;
	}
}
// public class Utils {
// public Sequence join(ArrayList<? extends Sequence> seqList, Sequence outseq)
// {
// Class elementType = seqList.get(0).getClass();
// StringBuilder builder = new StringBuilder();
// for (Sequence seq:seqList)
// builder.append(seq.getSeq());
// outseq = new Sequence (builder.toString());
// return outseq;
// }
// }
