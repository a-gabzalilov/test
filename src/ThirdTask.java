import java.util.Arrays;
import java.util.Collections;

public class ThirdTask {


    static String DO(Double[] data, int number_of_groups){
        String str;
        Arrays.sort(data, Collections.reverseOrder());
        int max_sum = 0;
        int number_of_zeros = 0;
        for (double i: data) {
            if (i == 0)
                number_of_zeros++;
            max_sum += i;
        }
        if (max_sum % number_of_groups != 0)
            str = "Couldn't find the result";
        else
        {
            max_sum /= number_of_groups;
            ArrayHolder arrayHolder = new ArrayHolder();
            if (number_of_zeros == 0)
                arrayHolder = new ArrayHolder(max_sum, data, number_of_groups);
            else
                arrayHolder = new ArrayHolder(max_sum, data, number_of_groups, number_of_zeros);
            str = arrayHolder.print_result();
        }
        return str;
    }
}
