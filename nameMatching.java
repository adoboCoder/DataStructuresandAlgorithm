import java.util.Arrays;
import java.util.List;

public class nameMatching {
    public static boolean nameMatch(String[] knownAliases, String name) {
        for (String knownAlias : knownAliases) {
            // Check if the known alias is an exact match with the name
            if (knownAlias.equals(name)) {
                return true;
            }

            // Check if the known alias has a middle name and the name does not
            if (knownAlias.split(" ").length == 3 && name.split(" ").length == 2) {
                // Split the known alias and the name into their respective parts
                String[] knownAliasParts = knownAlias.split(" ");
                String[] nameParts = name.split(" ");

                // Check if the first and last names match, ignoring the middle name
                if (knownAliasParts[0].equals(nameParts[0]) && knownAliasParts[2].equals(nameParts[1])) {
                    return true;
                }
            }

            // Check if the known alias has a middle initial and the name does not
            if (knownAlias.split(" ").length == 3 && name.split(" ").length == 2) {
                // Split the known alias and the name into their respective parts
                String[] knownAliasParts = knownAlias.split(" ");
                String[] nameParts = name.split(" ");

                // Check if the first and last names match, ignoring the middle initial
                if (knownAliasParts[0].equals(nameParts[0]) && knownAliasParts[2].equals(nameParts[1])
                        && knownAliasParts[1].length() == 1 && nameParts[1].length() > 1) {
                    return true;
                }
            }

            // Check if the first and last names match, ignoring the middle name or initial
            if (knownAlias.split(" ").length == 3 && name.split(" ").length == 2) {
                // Split the known alias and the name into their respective parts
                String[] knownAliasParts = knownAlias.split(" ");
                String[] nameParts = name.split(" ");

                // Check if the first and last names match, ignoring the middle name or initial
                if (knownAliasParts[0].equals(nameParts[0]) && knownAliasParts[2].equals(nameParts[1])) {
                    return true;
                }
            }

            // Check if the first and last names match, ignoring the middle name or initial,
            // and if the first and middle names are transposed
            if (knownAlias.split(" ").length == 3 && name.split(" ").length == 3) {
                // Split the known alias and the name into their respective parts
                String[] knownAliasParts = knownAlias.split(" ");
                String[] nameParts = name.split(" ");

                // Check if the first and last names match, ignoring the middle name or initial
                if (knownAliasParts[0].equals(nameParts[1]) && knownAliasParts[2].equals(nameParts[2])
                        && knownAliasParts[1].equals(nameParts[0])) {
                    return true;
                }
            }
        }

        // If none of the cases match, return false.
        return false;
    }

    public static void main(String[] args) {
        List<String> knownAliases1 = Arrays.asList("Alphonse Gabriel Capone", "Al Capone");
        String[] array = knownAliases1.toArray(new String[knownAliases1.size()]);
        System.out.println(nameMatch(array, "Alphonse Gabriel Capone")); // should return true
        System.out.println(nameMatch(array, "Al Capone")); // should return true
        System.out.println(nameMatch(array, "Alphonse Francis Capone")); // should return false
        System.out.println();

        List<String> knownAliases2 = Arrays.asList("Alphonse Capone");
        String[] array2 = knownAliases2.toArray(new String[knownAliases2.size()]);
        System.out.println(nameMatch(array2, "Alphonse Gabriel Capone")); // should return true
        System.out.println(nameMatch(array2, "Alphonse Francis Capone")); // should return true
        System.out.println(nameMatch(array2, "Alexander Capone")); // should return false
        System.out.println();
        
        List<String> knownAliases3 = Arrays.asList("Alphonse Gabriel Capone", "Al Capone");
        String[] array3 = knownAliases3.toArray(new String[knownAliases2.size()]);
        System.out.println(nameMatch(array3, "Alphonse Gabriel Capone")); // should return true
        System.out.println(nameMatch(array3, "Al Capone")); // should return true
        System.out.println(nameMatch(array3, "Alphonse Francis Capone'")); // should return false

    }
}