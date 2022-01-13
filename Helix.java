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

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Helix {
    public static void main(String[] args) {
        String s = "ATGTTTGTAUAATATTAG";
        String codon = Helix.convertToCodon(s);
        System.out.println(codon);
        System.out.println("");
        String protein = Helix.convertToProtein(codon);
        System.out.println(protein);
    }
    public static String convertToCodon(String s) {
        StringBuilder sb = new StringBuilder();
        if(s == null || s.length() == 0) {
            return "";
        }
        Set<Character> set = new HashSet<>(Arrays.asList('A', 'C', 'T', 'G'));
        
        for(char c : s.toCharArray()) {
            if(!set.contains(c)) return "";
            else {
                if(c == 'A') {
                    sb.append('A');
                }
                else if (c == 'C') {
                    sb.append('C');
                }
                else if (c == 'T') {
                    sb.append('U');
                }
                else if (c == 'G') {
                    sb.append('G');
                }
                
            }
        }
        return sb.toString();
    }

    public static String convertToProtein(String s) {
        if(s.length() % 3 != 0) return "String is not divisble by 3";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i += 3) {
            String codon = s.substring(i, i + 3);
            if(codon.equals("AUG")) {
                sb.append("Met");
                sb.append(" ");
            }
            else if(codon.equals("UUU")) {
                sb.append("Phe");
                sb.append(" ");
            }
            else if(codon.equals("GUA")){
                sb.append("Val");
                sb.append(" ");
            }
            else if(codon.equals("UAU")) {
                sb.append("Tyr");
                sb.append(" ");
            }
            else if(codon.equals("CGU")) {
                sb.append("Arg");
                sb.append(" ");
            }
            else if(codon.equals("AAG")) {
                sb.append("Lys");
                sb.append(" ");
            }
            else if(codon.equals("UAA")) {
                break;
            }
            else if(codon.equals("UAG")) {
                break;
            }
            else if(codon.equals("UGA")) {
                break;
            }
        } 
        return sb.toString().trim();
    }
}
