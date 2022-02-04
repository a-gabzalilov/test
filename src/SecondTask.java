public class SecondTask {
    static String DO(int n){
        int sum = 0;
        while(n != 0){
            sum += (n % 10);
            n/=10;
        }
        return sum + "";
        //System.out.println(sum);
    }
}
