package seq;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.is;


import org.junit.jupiter.api.Test;

class AminoAcidSequenceTest {
	
	@Test
	void testSeqType() {
		AminoAcidSequence testSeq = new AminoAcidSequence("AUG");
		assertEquals(testSeq.getSeqType(), "AminoAcid");
	}

	@Test
	void testBaseCheck() {
		@SuppressWarnings("unused")
		AminoAcidSequence testSeq = new AminoAcidSequence("AUCG");
		
		try {
			new AminoAcidSequence("DLLKY2");
	        fail("Expected an RuntimeException to be thrown");
		} catch (RuntimeException exc) {
	        assertThat(exc.getMessage(), is("Trying to create Amino Acid sequence containing non-Amino Acid Characters"));
	    }
	}

}
