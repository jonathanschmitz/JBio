package seqIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import seq.Sequence;
import seq.Utils;

public class FastaReader {
	private static ArrayList<Sequence> read(String fastaPath) {
		ArrayList<Sequence> seqs = new ArrayList<Sequence>();
		String key = "";
		ArrayList<Sequence> tmpList = new ArrayList<Sequence>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fastaPath));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.charAt(0) == '>') {
					if (!key.isEmpty()) {
						saveSeq(key, tmpList);
						tmpList = new ArrayList<Sequence>();
					}
					key = line.split(" ")[0].substring(1);
				} else {
					tmpList.add(new Sequence(line.trim()));
				}
			}
			saveSeq(key, tmpList);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return seqs;
	}
	
	private static void saveSeq(String key, ArrayList<Sequence> seqList) {
		System.out.println(key);
		Sequence seq = Utils.join(seqList);
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
		for (Sequence seq: seqs) {
			System.out.println(seq.getId() + ": " + seq.getSeq());
		}
	}
}