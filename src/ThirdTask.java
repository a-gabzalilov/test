import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThirdTask {

    private static List<ArrayList<Double>> First_Fitting(Double[] data, int max_sum, int number_of_groups){
        List<ArrayList<Double>> res = new ArrayList<>();
        for (int i=0; i<number_of_groups; i++){
            ArrayList<Double> col = new ArrayList<>(number_of_groups);
            res.add(col);
        }
        boolean placed = false;
        for (double data_el: data)
        {
            for (ArrayList<Double> res_row: res){
                double row_sum = 0;
                for (double res_col: res_row)
                    row_sum += res_col;
                if (row_sum + data_el <= max_sum){
                    res_row.add(data_el);
                    placed = true;
                    break;
                }
            }
            if (placed)
                placed = false;
            else
                return null;
        }
        return res;
    }

    static String DO(Double[] data, int number_of_groups){
        String str;
        Arrays.sort(data, Collections.reverseOrder());
        int max_sum = 0;
        for (double i: data) {
            max_sum += i;
        }
        if (max_sum % number_of_groups != 0)
            str = "Couldn't find the result";
        else
        {
            max_sum /= number_of_groups;
            List<ArrayList<Double>> res = First_Fitting(data, max_sum, number_of_groups);
            if (res != null)
                str = res.toString();
            else
                str = "Couldn't find the result";
        }
        return str;
    }
}
