package seq;

import java.util.ArrayList;

public class Utils {
	/**
	 * @param seqList A list of Sequence objects to join
	 * @return A Sequence object containing the joined sequences
	 */
	public static Sequence join(ArrayList<Sequence> seqList) {
		StringBuilder builder = new StringBuilder();
		for (Sequence seq : seqList)
			builder.append(seq.getSeq());
		Sequence outseq = new Sequence(builder.toString());
		return outseq;
	}

//	TODO This is what I want: 
//	public static <T extends Sequence> T joinT(ArrayList<T> seqList) {
//		StringBuilder builder = new StringBuilder();
//		for (Sequence seq : seqList)
//			builder.append(seq.getSeq());
//		T outseq = new T(builder.toString());
//		return outseq;
//	}
//  But it does not seem possible: https://stackoverflow.com/questions/12093541/cannot-instantiate-generic-data-type-in-class

}
