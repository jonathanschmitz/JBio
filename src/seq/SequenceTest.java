package seq;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SequenceTest {
	
	@Test
	void testCreate() {
		String seqStr = "AUGTGTGCTAT";
		String seqId =  "seqId";
		Sequence testSeq =  new Sequence(seqStr, seqId);
		assertEquals(testSeq.getId(), seqId);
		assertEquals(testSeq.getSeq(), seqStr);
		assertFalse(testSeq == new Sequence("AUGTGTGCTA"));
	}

	@Test
	void testLength() {
		String seqString = "ATCGTCGTCG";
		int stringLen = seqString.length();
		Sequence seq = new Sequence(seqString);
		int seqLen = seq.getLength();
		assertEquals(stringLen, seqLen);
	}

}
