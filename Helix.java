
/*
 * Protein Synthesis is the process of generating proteins from information coded in our genes. It is a multi step process, whereby the input DNA string is transcribed to produce messenger RNA (mRNA), then the mRNA is translated to produce amino acids. The concatenation of the resulting amino acids results in the protein.

General rules for Protein Synthesis:

* DNA input string consists of A, C, T, and G, mRNA string consists of A, C, U, and G
* A base pair (character in the DNA) is transcribed into mRNA according to the following rules: A → A, T → U, C → C, G → G
* A gene's length must be a multiple of 3
* A triplet of base pairs in the mRNA is known as a codon
* Translation of mRNA into amino acids begins where the first start codon (AUG) is found
* Translation is terminated upon encountering a stop codon  (UAA, UAG, UGA)
* During translation, each codon, except a stop codon, corresponds to an amino acid (interviewer will provide lookup table)
* The encoded protein string is the concatenation of the encountered amino acids, separated by spaces.
* Invalid DNA results in an empty string
* 
Partial look up table:
codon | amino acid
----- | -------
AUG   | Met
UUU   | Phe
GUA   | Val
UAU   | Tyr
CGU   | Arg
AAG   | Lys

Task: Implement the basic Protein Synthesis algorithm given the above rules

Example:
Input: "ATG TTT GTA TAT TAG"
Output: "Met Phe Val Tyr
Translation is terminated upon encountering a stop codon  (UAA, UAG, UGA)
AUG UUU GUA UAU UAG AUG
AUG UUU GUA UAU UAG
Met Phe Val Tyr 

DNA -  A,C,T,G
       | | | |
mRNA - A,C,U,G

DNA -> mRNA -> Codon -> Amino Acid ?

AUGUUUG
 */
import java.util.HashMap;
import java.util.Map;

class Helix {
    public static String proteinSynthesis(String dna) {
        // Initialize the codon -> amino acid lookup table
        Map<String, String> codonTable = new HashMap<>();
        codonTable.put("AUG", "Met");
        codonTable.put("UUU", "Phe");
        codonTable.put("GUA", "Val");
        codonTable.put("UAU", "Tyr");
        codonTable.put("CGU", "Arg");
        codonTable.put("AAG", "Lys");
        // Add more codons and amino acids here

        // Check if the DNA string is valid
        if (!dna.matches("[ACTG]+")) {
            return "";
        }

        // Check if the DNA string has a valid length
        if (dna.length() % 3 != 0) {
            return "";
        }

        // Transcribe the DNA string to produce the mRNA string
        String mrna = dna.replace('A', 'A').replace('T', 'U').replace('C', 'C').replace('G', 'G');

        // Find the start codon in the mRNA string
        int startCodonIdx = mrna.indexOf("AUG");
        if (startCodonIdx == -1) {
            return "";
        }

        // Translate the mRNA string to produce the encoded protein string
        String protein = "";
        for (int i = startCodonIdx; i < mrna.length(); i += 3) {
            String codon = mrna.substring(i, i + 3);
            if (codonTable.containsKey(codon)) {
                protein += codonTable.get(codon);
            } else if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")) {
                break;
            }
        }
        return protein;
    }

    public static void main(String[] args) {
        System.out.println(Helix.proteinSynthesis("ATGAAG"));
    }
}
// // Test the proteinSynthesis function
// ProteinSynthesis ps = new ProteinSynthesis();
// assert ps.proteinSynthesis("ATGAAG").equals("MetLys");
// assert ps.proteinSynthesis("ATGAUGAACG").equals("MetValArg");
// assert ps.proteinSynthesis("ATGAUGUAG").equals("MetVal");
// assert ps.proteinSynthesis("ATGAUGUAGCGAUGUAG").equals("MetValVal");
