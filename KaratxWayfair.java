import java.util.*;
class KaratxWayfair{
    public static List<List<String>> badgeAccessBreaches(String[][] logs) {
        Set<String> entryWithoutExit = new HashSet<>(); // look up for each log that has an entrance and no exit 
        Set<String> exitWithoutEntry = new HashSet<>(); // look up for each log that has an exit and no entry
        List<List<String>> breaches = new ArrayList<>();
    
        Set<String> legallySeen = new HashSet<>();
        for(String[] log: logs) {
            String record = log[0]+log[1];
            if(log[1] == "enter") { // entrance
                if(entryWithoutExit.contains(record) || exitWithoutEntry.contains(log[0]+"exit")) { // then go ahead they are already enlisted as breachers
                    continue;
                } else { // illegal entry when the previous one is also an entrance
                    if(!legallySeen.contains(record)) { 
                        legallySeen.add(record); // legal entrance
                    } else { // means previous one was also for entrance
                        // this is entry followed by an entry
                        // illegal
                        entryWithoutExit.add(record);
                    }
                }
                
            } else { // exit
                // for every exit check if there is an entry in either of the frauds. We are looking for the name than the type of activity
                if(entryWithoutExit.contains(log[0]+"enter") || exitWithoutEntry.contains(record)) // then go ahead they are already enlisted as breachers
                    continue;
    
                if(legallySeen.contains(log[0]+"enter")) {
                    /* 
                     * legallySeen.put(log[0]+"enter", 1); // legal exit
                     * or remove what's legally in there. We don't need it anymore. We're finding faults and it's in no way fault.
                     */
                    legallySeen.remove(log[0]+"enter");
                } else {// if not it's a breach of exit without and entrance
                    // illegal exit without entry
                    exitWithoutEntry.add(record); // we don't care about it to be as a legal one. So no entry into the legallySeen
                }
            }
        }
        
        breaches.add(new ArrayList<String>(entryWithoutExit));
        breaches.add(new ArrayList<String>(exitWithoutEntry));
        return breaches;
    }
}
