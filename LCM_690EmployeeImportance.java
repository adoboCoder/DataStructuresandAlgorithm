import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

class LCM690_EmployeeImportance {
    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }

        return helper(map, id);
    }

    private static int helper(Map<Integer, Employee> map, int rootId) {
        Employee root = map.get(rootId);

        int total = root.importance;

        for (int i : root.subordinates) {
            total = total + helper(map, i);
        }
        return total;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = Arrays.asList(2, 3);

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = Arrays.asList();

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = Arrays.asList();

        List<Employee> input = new ArrayList<>();
        input.add(e1);
        input.add(e2);
        input.add(e3);

        System.out.println(LCM690_EmployeeImportance.getImportance(input, 1));
    }
}