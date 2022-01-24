class LCH_552StudenAttendanceRecordII {
    public static int checkRecord(int n) {
        if(n == 1) return 3;
        if(n == 2) return 8;
        int m = 1000000007;
        int[] absent = new int [n];
        int[] present = new int [n];
        int[] late = new int [n];
        
        present[0] = 1;
        late[0] = 1;
        late[1] = 3;
        absent[0] = 1;
        absent[1] = 2;
        absent[2] = 4;
    
        for(int i = 1; i < n; i++)
        {
            absent[i - 1] %= m;
            present[i - 1] %= m;
            late[i - 1] %= m;
            
            present[i] = ((absent[i - 1] + present[i - 1]) % m + late[i - 1]) % m;        
            if(i > 1){
                late[i] = ((absent[i - 1] + present[i - 1]) % m + (absent[i - 2] + present[i - 2]) % m) % m;
            } 
            if(i > 2){
                absent[i] = ((absent[i - 1] + absent[i - 2]) % m + absent[i - 3]) % m;
            } 
        }
        return ((absent[n - 1] % m + present[n - 1] % m) % m + late[n - 1] % m) % m;
    }
    public static void main(String[] args) {
        System.out.println(LCH_552StudenAttendanceRecordII.checkRecord(1));
        System.out.println(LCH_552StudenAttendanceRecordII.checkRecord(10101));
    }
}