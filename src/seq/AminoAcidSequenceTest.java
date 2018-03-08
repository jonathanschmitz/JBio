package seq;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.is;


import org.junit.jupiter.api.Test;

import seqIO.FastaReader;

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
	
	@Test
	void hydrophobTest() {
		String testPath = AminoAcidSequenceTest.class.getResource("../StaticFiles/P05130.fasta").getFile();
		AminoAcidSequence testSeq = new AminoAcidSequence(FastaReader.readSingleSeq(testPath));
		assertEquals(testSeq.hydrophobicity(), -0.5166, 0.0001);
	}
	
	@Test
	void hydroWindowTest() {
		String testPath = AminoAcidSequenceTest.class.getResource("../StaticFiles/P5131.fasta").getFile();
		AminoAcidSequence testSeq = new AminoAcidSequence(FastaReader.readSingleSeq(testPath));
		assertArrayEquals(testSeq.hydrophobicityWindow(), new float[] {4.5f, 4.026f}, 0.001f);
		
	}

}
