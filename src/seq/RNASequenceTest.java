package seq;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.is;


import org.junit.jupiter.api.Test;

class RNASequenceTest {
	
	@Test
	void testSeqType() {
		RNASequence testSeq = new RNASequence("AUG");
		assertEquals(testSeq.getSeqType(), "RNA");
	}

	@Test
	void testBaseCheck() {
		@SuppressWarnings("unused")
		RNASequence testSeq = new RNASequence("AUCG");
		
		try {
			new RNASequence("AUCGT");
	        fail("Expected an RuntimeException to be thrown");
		} catch (RuntimeException exc) {
	        assertThat(exc.getMessage(), is("Trying to create RNA sequence containing non-RNA Characters"));
	    }
	}

	@Test
	void testTranslation() {
		RNASequence testSeq = new RNASequence("AUGCCUAUUGGAUCCAAAGAGAGGCCAACAUUUUUUGAAAUUUUUAAGACACGCUGCAAC"
				+ "AAAGCAGAUUUAGGACCAAUAAGUCUUAAUUGGUUUGAAGAACUUUCUUCAGAAGCUCCA"
				+ "CCCUAUAAUUCUGAACCUGCAGAAGAAUCUGAACAUAAAAACAACAAUUACGAACCAAAC"
				+ "CUAUUUAAAACUCCACAAAGGAAACCAUCUUAUAAUCAGCUGGCUUCAACUCCAAUAAUA"
				+ "UUCAAAGAGCAAGGGCUGACUCUGCCGCUGUACCAAUCUCCUGUAAAAGAAUUAGAUAAA"
				+ "UUCAAAUUAGACUUAGGAAGGAAUGUUCCCAAUAGUAGACAUAAAAGUCUUCGCACAGUG"
				+ "AAAACUAAAAUGGAUCAAGCAGAUGAUGUUUCCUGUCCACUUCUAAAUUCUUGUCUUAGU"
				+ "GAAAGUCCUGUUGUUCUACAAUGUACACAUGUAACACCACAAAGAGAUAAGUCAGUGGUA"
				+ "UGUGGGAGUUUGUUUCAUACACCAAAGUUUGUGAAGGGUCGUCAGACACCAAAACAUAUU"
				+ "UCUGAAAGUCUAGGAGCUGAGGUGGAUCCUGAUAUGUCUUGGUCAAGUUCUUUAGCUACA"
				+ "CCACCCACCCUUAGUUCUACUGUGCUCAUAGUCAGAAAUGAAGAAGCAUCUGAAACUGUA"
				+ "UUUCCUCAUGAUACUACUGCUAAUGUGAAAAGCUAUUUUUCCAAUCAUGAUGAAAGUCUG"
				+ "AAGAAAAAUGAUAGAUUUAUCGCUUCUGUGACAGACAGUGAAAACACAAAUCAAAGAGAA"
				+ "GCUGCAAGUCAUGGAUUUGGAAAAACAUCAGGGAAUUCAUUUAAAGUAAAUAGCUGCAAA"
				+ "GACCACAUUGGAAAGUCAAUGCCAAAUGUCCUAGAAGAUGAAGUAUAUGAAACAGUUGUA"
				+ "GAUACCUCUGAAGAAGAUAGUUUUUCAUUAUGUUUUUCUAAAUGUAGAACAAAAAAUCUA"
				+ "CAAAAAGUAAGAACUAGCAAGACUAGGAAAAAAAUUUUCCAUGAAGCAAACGCUGAUGAA"
				+ "UGUGAAAAAUCUAAAAACCAAGUGAAAGAAAAAUACUCAUUUGUAUCUGAAGUGGAACCA"
				+ "AAUGAUACUGAUCCAUUAGAUUCAAAUGUAGCAAAUCAGAAGCCCUUUGAGAGUGGAAGU"
				+ "GACAAAAUCUCCAAGGAAGUUGUACCGUCUUUGGCCUGUGAAUGGUCUCAACUAACCCUU"
				+ "UCAGGUCUAAAUGGAGCCCAGAUGGAGAAAAUACCCCUAUUGCAUAUUUCUUCAUGUGAC"
				+ "CAAAAUAUUUCAGAAAAAGACCUAUUAGACACAGAGAACAAAAGAAAGAAAGAUUUUCUU"
				+ "ACUUCAGAGAAUUCUUUGCCACGUAUUUCUAGCCUACCAAAAUCAGAGAAGCCAUUAAAU"
				+ "GAGGAAACAGUGGUAAAUAAGAGAGAUGAAGAGCAGCAUCUUGAAUCUCAUACAGACUGC"
				+ "AUUCUUGCAGUAAAGCAGGCAAUAUCUGGAACUUCUCCAGUGGCUUCUUCAUUUCAGGGU"
				+ "AUCAAAAAGUCUAUAUUCAGAAUAAGAGAAUCACCUAAAGAGACUUUCAAUGCAAGUUUU"
				+ "UCAGGUCAUAUGACUGAUCCAAACUUUAAAAAAGAAACUGAAGCCUCUGAAAGUGGACUG"
				+ "GAAAUACAUACUGUUUGCUCACAGAAGGAGGACUCCUUAUGUCCAAAUUUAAUUGAUAAU"
				+ "GGAAGCUGGCCAGCCACCACCACACAGAAUUCUGUAGCUUUGAAGAAUGCAGGUUUAAUA"
				+ "UCCACUUUGAAAAAGAAAACAAAUAAGUUUAUUUAUGCUAUACAUGAUGAAACAUCUUAU"
				+ "AAAGGAAAAAAAAUACCGAAAGACCAAAAAUCAGAACUAAUUAACUGUUCAGCCCAGUUU"
				+ "GAAGCAAAUGCUUUUGAAGCACCACUUACAUUUGCAAAUGCUGAUUCAGGUUUAUUGCAU"
				+ "UCUUCUGUGAAAAGAAGCUGUUCACAGAAUGAUUCUGAAGAACCAACUUUGUCCUUAACU"
				+ "AGCUCUUUUGGGACAAUUCUGAGGAAAUGUUCUAGAAAUGAAACAUGUUCUAAUAAUACA"
				+ "GUAAUCUCUCAGGAUCUUGAUUAUAAAGAAGCAAAAUGUAAUAAGGAAAAACUACAGUUA"
				+ "UUUAUUACCCCAGAAGCUGAUUCUCUGUCAUGCCUGCAGGAAGGACAGUGUGAAAAUGAU"
				+ "CCAAAAAGCAAAAAAGUUUCAGAUAUAAAAGAAGAGGUCUUGGCUGCAGCAUGUCACCCA"
				+ "GUACAACAUUCAAAAGUGGAAUACAGUGAUACUGACUUUCAAUCCCAGAAAAGUCUUUUA"
				+ "UAUGAUCAUGAAAAUGCCAGCACUCUUAUUUUAACUCCUACUUCCAAGGAUGUUCUGUCA"
				+ "AACCUAGUCAUGAUUUCUAGAGGCAAAGAAUCAUACAAAAUGUCAGACAAGCUCAAAGGU"
				+ "AACAAUUAUGAAUCUGAUGUUGAAUUAACCAAAAAUAUUCCCAUGGAAAAGAAUCAAGAU"
				+ "GUAUGUGCUUUAAAUGAAAAUUAUAAAAACGUUGAGCUGUUGCCACCUGAAAAAUACAUG"
				+ "AGAGUAGCAUCACCUUCAAGAAAGGUACAAUUCAACCAAAACACAAAUCUAAGAGUAAUC"
				+ "CAAAAAAAUCAAGAAGAAACUACUUCAAUUUCAAAAAUAACUGUCAAUCCAGACUCUGAA"
				+ "GAACUUUUCUCAGACAAUGAGAAUAAUUUUGUCUUCCAAGUAGCUAAUGAAAGGAAUAAU"
				+ "CUUGCUUUAGGAAAUACUAAGGAACUUCAUGAAACAGACUUGACUUGUGUAAACGAACCC"
				+ "AUUUUCAAGAACUCUACCAUGGUUUUAUAUGGAGACACAGGUGAUAAACAAGCAACCCAA"
				+ "GUGUCAAUUAAAAAAGAUUUGGUUUAUGUUCUUGCAGAGGAGAACAAAAAUAGUGUAAAG"
				+ "CAGCAUAUAAAAAUGACUCUAGGUCAAGAUUUAAAAUCGGACAUCUCCUUGAAUAUAGAU"
				+ "AAAAUACCAGAAAAAAAUAAUGAUUACAUGAACAAAUGGGCAGGACUCUUAGGUCCAAUU"
				+ "UCAAAUCACAGUUUUGGAGGUAGCUUCAGAACAGCUUCAAAUAAGGAAAUCAAGCUCUCU"
				+ "GAACAUAACAUUAAGAAGAGCAAAAUGUUCUUCAAAGAUAUUGAAGAACAAUAUCCUACU"
				+ "AGUUUAGCUUGUGUUGAAAUUGUAAAUACCUUGGCAUUAGAUAAUCAAAAGAAACUGAGC"
				+ "AAGCCUCAGUCAAUUAAUACUGUAUCUGCACAUUUACAGAGUAGUGUAGUUGUUUCUGAU"
				+ "UGUAAAAAUAGUCAUAUAACCCCUCAGAUGUUAUUUUCCAAGCAGGAUUUUAAUUCAAAC"
				+ "CAUAAUUUAACACCUAGCCAAAAGGCAGAAAUUACAGAACUUUCUACUAUAUUAGAAGAA"
				+ "UCAGGAAGUCAGUUUGAAUUUACUCAGUUUAGAAAACCAAGCUACAUAUUGCAGAAGAGU"
				+ "ACAUUUGAAGUGCCUGAAAACCAGAUGACUAUCUUAAAGACCACUUCUGAGGAAUGCAGA"
				+ "GAUGCUGAUCUUCAUGUCAUAAUGAAUGCCCCAUCGAUUGGUCAGGUAGACAGCAGCAAG"
				+ "CAAUUUGAAGGUACAGUUGAAAUUAAACGGAAGUUUGCUGGCCUGUUGAAAAAUGACUGU"
				+ "AACAAAAGUGCUUCUGGUUAUUUAACAGAUGAAAAUGAAGUGGGGUUUAGGGGCUUUUAU"
				+ "UCUGCUCAUGGCACAAAACUGAAUGUUUCUACUGAAGCUCUGCAAAAAGCUGUGAAACUG"
				+ "UUUAGUGAUAUUGAGAAUAUUAGUGAGGAAACUUCUGCAGAGGUACAUCCAAUAAGUUUA"
				+ "UCUUCAAGUAAAUGUCAUGAUUCUGUUGUUUCAAUGUUUAAGAUAGAAAAUCAUAAUGAU"
				+ "AAAACUGUAAGUGAAAAAAAUAAUAAAUGCCAACUGAUAUUACAAAAUAAUAUUGAAAUG"
				+ "ACUACUGGCACUUUUGUUGAAGAAAUUACUGAAAAUUACAAGAGAAAUACUGAAAAUGAA"
				+ "GAUAACAAAUAUACUGCUGCCAGUAGAAAUUCUCAUAACUUAGAAUUUGAUGGCAGUGAU"
				+ "UCAAGUAAAAAUGAUACUGUUUGUAUUCAUAAAGAUGAAACGGACUUGCUAUUUACUGAU"
				+ "CAGCACAACAUAUGUCUUAAAUUAUCUGGCCAGUUUAUGAAGGAGGGAAACACUCAGAUU"
				+ "AAAGAAGAUUUGUCAGAUUUAACUUUUUUGGAAGUUGCGAAAGCUCAAGAAGCAUGUCAU"
				+ "GGUAAUACUUCAAAUAAAGAACAGUUAACUGCUACUAAAACGGAGCAAAAUAUAAAAGAU"
				+ "UUUGAGACUUCUGAUACAUUUUUUCAGACUGCAAGUGGGAAAAAUAUUAGUGUCGCCAAA"
				+ "GAGUCAUUUAAUAAAAUUGUAAAUUUCUUUGAUCAGAAACCAGAAGAAUUGCAUAACUUU"
				+ "UCCUUAAAUUCUGAAUUACAUUCUGACAUAAGAAAGAACAAAAUGGACAUUCUAAGUUAU"
				+ "GAGGAAACAGACAUAGUUAAACACAAAAUACUGAAAGAAAGUGUCCCAGUUGGUACUGGA"
				+ "AAUCAACUAGUGACCUUCCAGGGACAACCCGAACGUGAUGAAAAGAUCAAAGAACCUACU"
				+ "CUAUUGGGUUUUCAUACAGCUAGCGGGAAAAAAGUUAAAAUUGCAAAGGAAUCUUUGGAC"
				+ "AAAGUGAAAAACCUUUUUGAUGAAAAAGAGCAAGGUACUAGUGAAAUCACCAGUUUUAGC"
				+ "CAUCAAUGGGCAAAGACCCUAAAGUACAGAGAGGCCUGUAAAGACCUUGAAUUAGCAUGU"
				+ "GAGACCAUUGAGAUCACAGCUGCCCCAAAGUGUAAAGAAAUGCAGAAUUCUCUCAAUAAU"
				+ "GAUAAAAACCUUGUUUCUAUUGAGACUGUGGUGCCACCUAAGCUCUUAAGUGAUAAUUUA"
				+ "UGUAGACAAACUGAAAAUCUCAAAACAUCAAAAAGUAUCUUUUUGAAAGUUAAAGUACAU"
				+ "GAAAAUGUAGAAAAAGAAACAGCAAAAAGUCCUGCAACUUGUUACACAAAUCAGUCCCCU"
				+ "UAUUCAGUCAUUGAAAAUUCAGCCUUAGCUUUUUACACAAGUUGUAGUAGAAAAACUUCU"
				+ "GUGAGUCAGACUUCAUUACUUGAAGCAAAAAAAUGGCUUAGAGAAGGAAUAUUUGAUGGU"
				+ "CAACCAGAAAGAAUAAAUACUGCAGAUUAUGUAGGAAAUUAUUUGUAUGAAAAUAAUUCA"
				+ "AACAGUACUAUAGCUGAAAAUGACAAAAAUCAUCUCUCCGAAAAACAAGAUACUUAUUUA"
				+ "AGUAACAGUAGCAUGUCUAACAGCUAUUCCUACCAUUCUGAUGAGGUAUAUAAUGAUUCA"
				+ "GGAUAUCUCUCAAAAAAUAAACUUGAUUCUGGUAUUGAGCCAGUAUUGAAGAAUGUUGAA"
				+ "GAUCAAAAAAACACUAGUUUUUCCAAAGUAAUAUCCAAUGUAAAAGAUGCAAAUGCAUAC"
				+ "CCACAAACUGUAAAUGAAGAUAUUUGCGUUGAGGAACUUGUGACUAGCUCUUCACCCUGC"
				+ "AAAAAUAAAAAUGCAGCCAUUAAAUUGUCCAUAUCUAAUAGUAAUAAUUUUGAGGUAGGG"
				+ "CCACCUGCAUUUAGGAUAGCCAGUGGUAAAAUCGUUUGUGUUUCACAUGAAACAAUUAAA"
				+ "AAAGUGAAAGACAUAUUUACAGACAGUUUCAGUAAAGUAAUUAAGGAAAACAACGAGAAU"
				+ "AAAUCAAAAAUUUGCCAAACGAAAAUUAUGGCAGGUUGUUACGAGGCAUUGGAUGAUUCA"
				+ "GAGGAUAUUCUUCAUAACUCUCUAGAUAAUGAUGAAUGUAGCACGCAUUCACAUAAGGUU"
				+ "UUUGCUGACAUUCAGAGUGAAGAAAUUUUACAACAUAACCAAAAUAUGUCUGGAUUGGAG"
				+ "AAAGUUUCUAAAAUAUCACCUUGUGAUGUUAGUUUGGAAACUUCAGAUAUAUGUAAAUGU"
				+ "AGUAUAGGGAAGCUUCAUAAGUCAGUCUCAUCUGCAAAUACUUGUGGGAUUUUUAGCACA"
				+ "GCAAGUGGAAAAUCUGUCCAGGUAUCAGAUGCUUCAUUACAAAACGCAAGACAAGUGUUU"
				+ "UCUGAAAUAGAAGAUAGUACCAAGCAAGUCUUUUCCAAAGUAUUGUUUAAAAGUAACGAA"
				+ "CAUUCAGACCAGCUCACAAGAGAAGAAAAUACUGCUAUACGUACUCCAGAACAUUUAAUA"
				+ "UCCCAAAAAGGCUUUUCAUAUAAUGUGGUAAAUUCAUCUGCUUUCUCUGGAUUUAGUACA"
				+ "GCAAGUGGAAAGCAAGUUUCCAUUUUAGAAAGUUCCUUACACAAAGUUAAGGGAGUGUUA"
				+ "GAGGAAUUUGAUUUAAUCAGAACUGAGCAUAGUCUUCACUAUUCACCUACGUCUAGACAA"
				+ "AAUGUAUCAAAAAUACUUCCUCGUGUUGAUAAGAGAAACCCAGAGCACUGUGUAAACUCA"
				+ "GAAAUGGAAAAAACCUGCAGUAAAGAAUUUAAAUUAUCAAAUAACUUAAAUGUUGAAGGU"
				+ "GGUUCUUCAGAAAAUAAUCACUCUAUUAAAGUUUCUCCAUAUCUCUCUCAAUUUCAACAA"
				+ "GACAAACAACAGUUGGUAUUAGGAACCAAAGUGUCACUUGUUGAGAACAUUCAUGUUUUG"
				+ "GGAAAAGAACAGGCUUCACCUAAAAACGUAAAAAUGGAAAUUGGUAAAACUGAAACUUUU"
				+ "UCUGAUGUUCCUGUGAAAACAAAUAUAGAAGUUUGUUCUACUUACUCCAAAGAUUCAGAA"
				+ "AACUACUUUGAAACAGAAGCAGUAGAAAUUGCUAAAGCUUUUAUGGAAGAUGAUGAACUG"
				+ "ACAGAUUCUAAACUGCCAAGUCAUGCCACACAUUCUCUUUUUACAUGUCCCGAAAAUGAG"
				+ "GAAAUGGUUUUGUCAAAUUCAAGAAUUGGAAAAAGAAGAGGAGAGCCCCUUAUCUUAGUG"
				+ "GGAGAACCCUCAAUCAAAAGAAACUUAUUAAAUGAAUUUGACAGGAUAAUAGAAAAUCAA"
				+ "GAAAAAUCCUUAAAGGCUUCAAAAAGCACUCCAGAUGGCACAAUAAAAGAUCGAAGAUUG"
				+ "UUUAUGCAUCAUGUUUCUUUAGAGCCGAUUACCUGUGUACCCUUUCGCACAACUAAGGAA"
				+ "CGUCAAGAGAUACAGAAUCCAAAUUUUACCGCACCUGGUCAAGAAUUUCUGUCUAAAUCU"
				+ "CAUUUGUAUGAACAUCUGACUUUGGAAAAAUCUUCAAGCAAUUUAGCAGUUUCAGGACAU"
				+ "CCAUUUUAUCAAGUUUCUGCUACAAGAAAUGAAAAAAUGAGACACUUGAUUACUACAGGC"
				+ "AGACCAACCAAAGUCUUUGUUCCACCUUUUAAAACUAAAUCACAUUUUCACAGAGUUGAA"
				+ "CAGUGUGUUAGGAAUAUUAACUUGGAGGAAAACAGACAAAAGCAAAACAUUGAUGGACAU"
				+ "GGCUCUGAUGAUAGUAAAAAUAAGAUUAAUGACAAUGAGAUUCAUCAGUUUAACAAAAAC"
				+ "AACUCCAAUCAAGCAGUAGCUGUAACUUUCACAAAGUGUGAAGAAGAACCUUUAGAUUUA"
				+ "AUUACAAGUCUUCAGAAUGCCAGAGAUAUACAGGAUAUGCGAAUUAAGAAGAAACAAAGG"
				+ "CAACGCGUCUUUCCACAGCCAGGCAGUCUGUAUCUUGCAAAAACAUCCACUCUGCCUCGA"
				+ "AUCUCUCUGAAAGCAGCAGUAGGAGGCCAAGUUCCCUCUGCGUGUUCUCAUAAACAGCUG"
				+ "UAUACGUAUGGCGUUUCUAAACAUUGCAUAAAAAUUAACAGCAAAAAUGCAGAGUCUUUU"
				+ "CAGUUUCACACUGAAGAUUAUUUUGGUAAGGAAAGUUUAUGGACUGGAAAAGGAAUACAG"
				+ "UUGGCUGAUGGUGGAUGGCUCAUACCCUCCAAUGAUGGAAAGGCUGGAAAAGAAGAAUUU"
				+ "UAUAGGGCUCUGUGUGACACUCCAGGUGUGGAUCCAAAGCUUAUUUCUAGAAUUUGGGUU"
				+ "UAUAAUCACUAUAGAUGGAUCAUAUGGAAACUGGCAGCUAUGGAAUGUGCCUUUCCUAAG"
				+ "GAAUUUGCUAAUAGAUGCCUAAGCCCAGAAAGGGUGCUUCUUCAACUAAAAUACAGAUAU"
				+ "GAUACGGAAAUUGAUAGAAGCAGAAGAUCGGCUAUAAAAAAGAUAAUGGAAAGGGAUGAC"
				+ "ACAGCUGCAAAAACACUUGUUCUCUGUGUUUCUGACAUAAUUUCAUUGAGCGCAAAUAUA"
				+ "UCUGAAACUUCUAGCAAUAAAACUAGUAGUGCAGAUACCCAAAAAGUGGCCAUUAUUGAA"
				+ "CUUACAGAUGGGUGGUAUGCUGUUAAGGCCCAGUUAGAUCCUCCCCUCUUAGCUGUCUUA"
				+ "AAGAAUGGCAGACUGACAGUUGGUCAGAAGAUUAUUCUUCAUGGAGCAGAACUGGUGGGC"
				+ "UCUCCUGAUGCCUGUACACCUCUUGAAGCCCCAGAAUCUCUUAUGUUAAAGAUUUCUGCU"
				+ "AACAGUACUCGGCCUGCUCGCUGGUAUACCAAACUUGGAUUCUUUCCUGACCCUAGACCU"
				+ "UUUCCUCUGCCCUUAUCAUCGCUUUUCAGUGAUGGAGGAAAUGUUGGUUGUGUUGAUGUA"
				+ "AUUAUUCAAAGAGCAUACCCUAUACAGUGGAUGGAGAAGACAUCAUCUGGAUUAUACAUA"
				+ "UUUCGCAAUGAAAGAGAGGAAGAAAAGGAAGCAGCAAAAUAUGUGGAGGCCCAACAAAAG"
				+ "AGACUAGAAGCCUUAUUCACUAAAAUUCAGGAGGAAUUUGAAGAACAUGAAGAAAACACA"
				+ "ACAAAACCAUAUUUACCAUCACGUGCACUAACAAGACAGCAAGUUCGUGCUUUGCAAGAU"
				+ "GGUGCAGAGCUUUAUGAAGCAGUGAAGAAUGCAGCAGACCCAGCUUACCUUGAGGGUUAU"
				+ "UUCAGUGAAGAGCAGUUAAGAGCCUUGAAUAAUCACAGGCAAAUGUUGAAUGAUAAGAAA"
				+ "CAAGCUCAGAUCCAGUUGGAAAUUAGGAAGGCCAUGGAAUCUGCUGAACAAAAGGAACAA"
				+ "GGUUUAUCAAGGGAUGUCACAACCGUGUGGAAGUUGCGUAUUGUAAGCUAUUCAAAAAAA"
				+ "GAAAAAGAUUCAGUUAUACUGAGUAUUUGGCGUCCAUCAUCAGAUUUAUAUUCUCUGUUA"
				+ "ACAGAAGGAAAGAGAUACAGAAUUUAUCAUCUUGCAACUUCAAAAUCUAAAAGUAAAUCU"
				+ "GAAAGAGCUAACAUACAGUUAGCAGCGACAAAAAAAACUCAGUAUCAACAACUACCGGUU"
				+ "UCAGAUGAAAUUUUAUUUCAGAUUUACCAGCCACGGGAGCCCCUUCACUUCAGCAAAUUU"
				+ "UUAGAUCCAGACUUUCAGCCAUCUUGUUCUGAGGUGGACCUAAUAGGAUUUGUCGUUUCU"
				+ "GUUGUGAAAAAAACAGGACUUGCCCCUUUCGUCUAUUUGUCAGACGAAUGUUACAAUUUA"
				+ "CUGGCAAUAAAGUUUUGGAUAGACCUUAAUGAGGACAUUAUUAAGCCUCAUAUGUUAAUU"
				+ "GCUGCAAGCAACCUCCAGUGGCGACCAGAAUCCAAAUCAGGCCUUCUUACUUUAUUUGCU"
				+ "GGAGAUUUUUCUGUGUUUUCUGCUAGUCCAAAAGAGGGCCACUUUCAAGAGACAUUCAAC"
				+ "AAAAUGAAAAAUACUGUUGAGAAUAUUGACAUACUUUGCAAUGAAGCAGAAAACAAGCUU"
				+ "AUGCAUAUACUGCAUGCAAAUGAUCCCAAGUGGUCCACCCCAACUAAAGACUGUACUUCA"
				+ "GGGCCGUACACUGCUCAAAUCAUUCCUGGUACAGGAAACAAGCUUCUGAUGUCUUCUCCU"
				+ "AAUUGUGAGAUAUAUUAUCAAAGUCCUUUAUCACUUUGUAUGGCCAAAAGGAAGUCUGUU"
				+ "UCCACACCUGUCUCAGCCCAGAUGACUUCAAAGUCUUGUAAAGGGGAGAAAGAGAUUGAU"
				+ "GACCAAAAGAACUGCAAAAAGAGAAGAGCCUUGGAUUUCUUGAGUAGACUGCCUUUACCU"
				+ "CCACCUGUUAGUCCCAUUUGUACAUUUGUUUCUCCGGCUGCACAGAAGGCAUUUCAGCCA"
				+ "CCAAGGAGUUGUGGCACCAAAUACGAAACACCCAUAAAGAAAAAAGAACUGAAUUCUCCU"
				+ "CAGAUGACUCCAUUUAAAAAAUUCAAUGAAAUUUCUCUUUUGGAAAGUAAUUCAAUAGCU"
				+ "GACGAAGAACUUGCAUUGAUAAAUACCCAAGCUCUUUUGUCUGGUUCAACAGGAGAAAAA"
				+ "CAAUUUAUAUCUGUCAGUGAAUCCACUAGGACUGCUCCCACCAGUUCAGAAGAUUAUCUC"
				+ "AGACUGAAACGACGUUGUACUACAUCUCUGAUCAAAGAACAGGAGAGUUCCCAGGCCAGU"
				+ "ACGGAAGAAUGUGAGAAAAAUAAGCAGGACACAAUUACAACUAAAAAAUAUAUCUAA");
		AminoAcidSequence testTrans = new AminoAcidSequence(
				"MPIGSKERPTFFEIFKTRCNKADLGPISLNWFEELSSEAPPYNSEPAEESEHKNNNYEPN"
						+ "LFKTPQRKPSYNQLASTPIIFKEQGLTLPLYQSPVKELDKFKLDLGRNVPNSRHKSLRTV"
						+ "KTKMDQADDVSCPLLNSCLSESPVVLQCTHVTPQRDKSVVCGSLFHTPKFVKGRQTPKHI"
						+ "SESLGAEVDPDMSWSSSLATPPTLSSTVLIVRNEEASETVFPHDTTANVKSYFSNHDESL"
						+ "KKNDRFIASVTDSENTNQREAASHGFGKTSGNSFKVNSCKDHIGKSMPNVLEDEVYETVV"
						+ "DTSEEDSFSLCFSKCRTKNLQKVRTSKTRKKIFHEANADECEKSKNQVKEKYSFVSEVEP"
						+ "NDTDPLDSNVANQKPFESGSDKISKEVVPSLACEWSQLTLSGLNGAQMEKIPLLHISSCD"
						+ "QNISEKDLLDTENKRKKDFLTSENSLPRISSLPKSEKPLNEETVVNKRDEEQHLESHTDC"
						+ "ILAVKQAISGTSPVASSFQGIKKSIFRIRESPKETFNASFSGHMTDPNFKKETEASESGL"
						+ "EIHTVCSQKEDSLCPNLIDNGSWPATTTQNSVALKNAGLISTLKKKTNKFIYAIHDETSY"
						+ "KGKKIPKDQKSELINCSAQFEANAFEAPLTFANADSGLLHSSVKRSCSQNDSEEPTLSLT"
						+ "SSFGTILRKCSRNETCSNNTVISQDLDYKEAKCNKEKLQLFITPEADSLSCLQEGQCEND"
						+ "PKSKKVSDIKEEVLAAACHPVQHSKVEYSDTDFQSQKSLLYDHENASTLILTPTSKDVLS"
						+ "NLVMISRGKESYKMSDKLKGNNYESDVELTKNIPMEKNQDVCALNENYKNVELLPPEKYM"
						+ "RVASPSRKVQFNQNTNLRVIQKNQEETTSISKITVNPDSEELFSDNENNFVFQVANERNN"
						+ "LALGNTKELHETDLTCVNEPIFKNSTMVLYGDTGDKQATQVSIKKDLVYVLAEENKNSVK"
						+ "QHIKMTLGQDLKSDISLNIDKIPEKNNDYMNKWAGLLGPISNHSFGGSFRTASNKEIKLS"
						+ "EHNIKKSKMFFKDIEEQYPTSLACVEIVNTLALDNQKKLSKPQSINTVSAHLQSSVVVSD"
						+ "CKNSHITPQMLFSKQDFNSNHNLTPSQKAEITELSTILEESGSQFEFTQFRKPSYILQKS"
						+ "TFEVPENQMTILKTTSEECRDADLHVIMNAPSIGQVDSSKQFEGTVEIKRKFAGLLKNDC"
						+ "NKSASGYLTDENEVGFRGFYSAHGTKLNVSTEALQKAVKLFSDIENISEETSAEVHPISL"
						+ "SSSKCHDSVVSMFKIENHNDKTVSEKNNKCQLILQNNIEMTTGTFVEEITENYKRNTENE"
						+ "DNKYTAASRNSHNLEFDGSDSSKNDTVCIHKDETDLLFTDQHNICLKLSGQFMKEGNTQI"
						+ "KEDLSDLTFLEVAKAQEACHGNTSNKEQLTATKTEQNIKDFETSDTFFQTASGKNISVAK"
						+ "ESFNKIVNFFDQKPEELHNFSLNSELHSDIRKNKMDILSYEETDIVKHKILKESVPVGTG"
						+ "NQLVTFQGQPERDEKIKEPTLLGFHTASGKKVKIAKESLDKVKNLFDEKEQGTSEITSFS"
						+ "HQWAKTLKYREACKDLELACETIEITAAPKCKEMQNSLNNDKNLVSIETVVPPKLLSDNL"
						+ "CRQTENLKTSKSIFLKVKVHENVEKETAKSPATCYTNQSPYSVIENSALAFYTSCSRKTS"
						+ "VSQTSLLEAKKWLREGIFDGQPERINTADYVGNYLYENNSNSTIAENDKNHLSEKQDTYL"
						+ "SNSSMSNSYSYHSDEVYNDSGYLSKNKLDSGIEPVLKNVEDQKNTSFSKVISNVKDANAY"
						+ "PQTVNEDICVEELVTSSSPCKNKNAAIKLSISNSNNFEVGPPAFRIASGKIVCVSHETIK"
						+ "KVKDIFTDSFSKVIKENNENKSKICQTKIMAGCYEALDDSEDILHNSLDNDECSTHSHKV"
						+ "FADIQSEEILQHNQNMSGLEKVSKISPCDVSLETSDICKCSIGKLHKSVSSANTCGIFST"
						+ "ASGKSVQVSDASLQNARQVFSEIEDSTKQVFSKVLFKSNEHSDQLTREENTAIRTPEHLI"
						+ "SQKGFSYNVVNSSAFSGFSTASGKQVSILESSLHKVKGVLEEFDLIRTEHSLHYSPTSRQ"
						+ "NVSKILPRVDKRNPEHCVNSEMEKTCSKEFKLSNNLNVEGGSSENNHSIKVSPYLSQFQQ"
						+ "DKQQLVLGTKVSLVENIHVLGKEQASPKNVKMEIGKTETFSDVPVKTNIEVCSTYSKDSE"
						+ "NYFETEAVEIAKAFMEDDELTDSKLPSHATHSLFTCPENEEMVLSNSRIGKRRGEPLILV"
						+ "GEPSIKRNLLNEFDRIIENQEKSLKASKSTPDGTIKDRRLFMHHVSLEPITCVPFRTTKE"
						+ "RQEIQNPNFTAPGQEFLSKSHLYEHLTLEKSSSNLAVSGHPFYQVSATRNEKMRHLITTG"
						+ "RPTKVFVPPFKTKSHFHRVEQCVRNINLEENRQKQNIDGHGSDDSKNKINDNEIHQFNKN"
						+ "NSNQAVAVTFTKCEEEPLDLITSLQNARDIQDMRIKKKQRQRVFPQPGSLYLAKTSTLPR"
						+ "ISLKAAVGGQVPSACSHKQLYTYGVSKHCIKINSKNAESFQFHTEDYFGKESLWTGKGIQ"
						+ "LADGGWLIPSNDGKAGKEEFYRALCDTPGVDPKLISRIWVYNHYRWIIWKLAAMECAFPK"
						+ "EFANRCLSPERVLLQLKYRYDTEIDRSRRSAIKKIMERDDTAAKTLVLCVSDIISLSANI"
						+ "SETSSNKTSSADTQKVAIIELTDGWYAVKAQLDPPLLAVLKNGRLTVGQKIILHGAELVG"
						+ "SPDACTPLEAPESLMLKISANSTRPARWYTKLGFFPDPRPFPLPLSSLFSDGGNVGCVDV"
						+ "IIQRAYPIQWMEKTSSGLYIFRNEREEEKEAAKYVEAQQKRLEALFTKIQEEFEEHEENT"
						+ "TKPYLPSRALTRQQVRALQDGAELYEAVKNAADPAYLEGYFSEEQLRALNNHRQMLNDKK"
						+ "QAQIQLEIRKAMESAEQKEQGLSRDVTTVWKLRIVSYSKKEKDSVILSIWRPSSDLYSLL"
						+ "TEGKRYRIYHLATSKSKSKSERANIQLAATKKTQYQQLPVSDEILFQIYQPREPLHFSKF"
						+ "LDPDFQPSCSEVDLIGFVVSVVKKTGLAPFVYLSDECYNLLAIKFWIDLNEDIIKPHMLI"
						+ "AASNLQWRPESKSGLLTLFAGDFSVFSASPKEGHFQETFNKMKNTVENIDILCNEAENKL"
						+ "MHILHANDPKWSTPTKDCTSGPYTAQIIPGTGNKLLMSSPNCEIYYQSPLSLCMAKRKSV"
						+ "STPVSAQMTSKSCKGEKEIDDQKNCKKRRALDFLSRLPLPPPVSPICTFVSPAAQKAFQP"
						+ "PRSCGTKYETPIKKKELNSPQMTPFKKFNEISLLESNSIADEELALINTQALLSGSTGEK"
						+ "QFISVSESTRTAPTSSEDYLRLKRRCTTSLIKEQESSQASTEECEKNKQDTITTKKYI*");
		assertEquals(testSeq.translate().getSeq(), testTrans.getSeq());
		assertEquals(testSeq.translate(), testTrans);
	}

}
