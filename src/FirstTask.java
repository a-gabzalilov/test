import java.util.Arrays;

public class FirstTask {
    private static double[] sort(double[] m){
        double c;
        for (int i = 0; i < m.length-1; i++){
            if (m[i] >= m[i+1]){
                c = m[i+1];
                m[i+1] = m[i];
                m[i] = c;
            }
        }
        return m;
    }

    static String DO(double[] c){
        double[] max_values = new double[3];
        for (int i = 0; i< c.length; i++){
            if (c[i] >= max_values[0]){
                max_values[0] = c[i];
                max_values = sort(max_values);
            }
        }
        return Arrays.toString(max_values);
        //System.out.println(Arrays.toString(max_values));
    }
}
