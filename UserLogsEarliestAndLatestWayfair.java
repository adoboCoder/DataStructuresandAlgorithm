import java.util.*;

public class UserLogsEarliestAndLatestWayfair {

public static void main(String[] args) {

    List<List<String>> logs = new ArrayList<>();
    List<String> log = new ArrayList<>(Arrays.asList("58523", "user_1", "resource_1"));
    logs.add(log);
    log = new ArrayList<>(Arrays.asList("62314", "user_2", "resource_2"));
    logs.add(log);
    log = new ArrayList<>(Arrays.asList("54001", "user_1", "resource_3"));
    logs.add(log);
    log = new ArrayList<>(Arrays.asList("200", "user_6", "resource_5"));
    logs.add(log);
    log = new ArrayList<>(Arrays.asList("215", "user_6", "resource_4"));
    logs.add(log);
    System.out.println(getUserLogs(logs));

}

public static List<UserLog> getUserLogs(List<List<String>> userLogs){

    HashMap<String, List<Integer>> logs = new HashMap<>();

    for(List<String> strings: userLogs){
        String userId = strings.get(1);
        if(logs.containsKey(userId)){
            logs.get(userId).add(Integer.parseInt(strings.get(0)));
        }
        else{
            List<Integer> log = new ArrayList<>();
            log.add(Integer.parseInt(strings.get(0)));
            logs.put(userId, log);
        }
    }

    List<UserLog> result = new ArrayList<>();

    for(Map.Entry<String, List<Integer>> entry: logs.entrySet()){
        UserLog userLog = new UserLog();
        userLog.userId = entry.getKey();
        userLog.logTimes = getEarliestAndLatest(entry.getValue());
        result.add(userLog);
    }

    return result;
}

public static List<Integer> getEarliestAndLatest(List<Integer> logTimes){
    Collections.sort(logTimes);
    return new ArrayList<Integer>(Arrays.asList(logTimes.get(0), logTimes.get(logTimes.size() - 1)));
}
}

class UserLog {

String userId;

List<Integer> logTimes;

@Override
public String toString() {
    return "UserLog{" +
            "userId='" + userId + '\'' +
            ", logTimes=" + logTimes +
            '}';
}
}