package seq;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SequenceTest {

	@Test
	void testLength() {
		String seqString = "ATCGTCGTCG";
		int stringLen = seqString.length();
		Sequence seq = new Sequence(seqString);
		int seqLen = seq.getLength();
		assertEquals(stringLen, seqLen);
	}

}
