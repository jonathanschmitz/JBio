package seqIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import seq.Sequence;
import seq.Utils;

public class FastaReader {
	private static ArrayList<Sequence> read(String fastaPath) {
		ArrayList<Sequence> seqs = new ArrayList<Sequence>();
		String seqID = "";
		ArrayList<Sequence> tmpList = new ArrayList<Sequence>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fastaPath));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.charAt(0) == '>') {
					if (!seqID.isEmpty()) {
						saveSeq(seqID, tmpList, seqs);
						tmpList = new ArrayList<Sequence>();
					}
					seqID = line.split(" ")[0].substring(1);
				} else {
					tmpList.add(new Sequence(line.trim()));
				}
			}
			saveSeq(seqID, tmpList, seqs);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return seqs;
	}
	
	private static void saveSeq(String key, ArrayList<Sequence> tmpList, ArrayList<Sequence> seqList) {
		Sequence seq = Utils.join(tmpList);
		seq.setId(key);
		seqList.add(seq);
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE: FastaReader <fasta_path>");
		}
		String fastaPath = args[0];
		System.out.println(fastaPath);
		ArrayList<Sequence> seqs = read(fastaPath);
		System.out.println("Found sequences:");
		for (Sequence seq: seqs) {
			System.out.println("\t" + seq.getId() + ": " + seq.getSeq());
		}
	}

	public static Sequence readSingleSeq(String fastaPath) {
		String seqID = "";
		ArrayList<Sequence> tmpList = new ArrayList<Sequence>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fastaPath));
			String line = reader.readLine();
			seqID = line.split(" ")[0].substring(1);
			while ((line = reader.readLine()) != null) {
				tmpList.add(new Sequence(line.trim()));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sequence seq = Utils.join(tmpList);
		seq.setId(seqID);
		return seq;
		
	}
}