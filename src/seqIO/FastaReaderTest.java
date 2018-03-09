package seqIO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import seq.SeqCollection;
import seq.Sequence;

class FastaReaderTest {

	@Test
	void testReader() {
		String testPath = FastaReaderTest.class.getResource("../StaticFiles/test.fasta").getFile();
		SeqCollection seqs = FastaReader.read(testPath);
		assertEquals(seqs.get("sp|P01308|INS_HUMAN").getSeq(),
				"MALWMRLLPLLALLALWGPDPAAAFVNQHLCGSHLVEALYLVCGERGFFYTPKTRREAED"
						+ "LQVGQVELGGGPGAGSLQPLALEGSLQKRGIVEQCCTSICSLYQLENYCN");
		assertNotEquals(seqs.get("sp|P01308|INS_HUMAN").getSeq(),
				"MALWMURLLPLLALLALWGPDPAAAFVNQHLCGSHLVEALYLVCGERGFFYTPKTRREAED"
						+ "LQVGQVELGGGPGAGSLQPLALEGSLQKRGIVEQCCTSICSLYQLENYCN");
		assertEquals(5, seqs.length());
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("sp|P01308|INS_HUMAN");
		testList.add("sp|P02088|HBB1_MOUSE");
		testList.add("sp|P02091|HBB1_RAT");
		testList.add("sp|P69891|HBG1_HUMAN");
		testList.add("sp|P69892|HBG2_HUMAN");
		assertEquals(testList, seqs.getIdList());
	}

	@Test
	void testIterator() {
		String testPath = FastaReaderTest.class.getResource("../StaticFiles/test.fasta").getFile();
		SeqCollection seqs = FastaReader.read(testPath);
		Iterator<Sequence> iter = seqs.iterator();
		assertEquals(iter.next().getId(), "sp|P01308|INS_HUMAN");
	}

}
