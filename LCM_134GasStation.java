class LCM_134GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;

        for(int i = 0; i < gas.length; i++){
            sumGas += gas[i];
            sumCost += cost[i];
            tank = tank + gas[i] - cost[i];
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return sumGas < sumCost ? -1 : start;
    }
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {1,2,3,4,5};
        System.out.println(LCM_134GasStation.canCompleteCircuit(gas, cost));
    }
}