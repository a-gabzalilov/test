import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayHolder {
    private int max_sum;
    private List<ArrayList<Double>> res;
    private ArrayList<Double> my_array = new ArrayList<>();
    private int number_of_zeros = 0;
    private int number_of_groups;

    public ArrayHolder(){}

    public ArrayHolder(int sum, Double[] dat, int number_of_groups){
        this.max_sum = sum;
        for (Double element : dat) {
            my_array.add(element);
        }
        this.number_of_groups = number_of_groups;
        this.res = new ArrayList<>();
    }

    public ArrayHolder(int sum, Double[] dat, int number_of_groups, int number_of_zeros){
        this.max_sum = sum;
        for (Double element : dat) {
            if (element != 0)
                my_array.add(element);
        }
        this.number_of_groups = number_of_groups;
        this.number_of_zeros = number_of_zeros;
        this.res = new ArrayList<>();
    }

    private boolean if_all_filled(){
        if (res.size()!=number_of_groups)
        {
            if ((number_of_zeros == 0)||(number_of_groups - res.size() > number_of_zeros))
                return false;
            int index = res.size();
            while (number_of_zeros != 0){
                if (index < number_of_groups){
                    ArrayList<Double> ar = new ArrayList<>();
                    ar.add(0.0);
                    res.add(ar);
                    index++;
                }else
                {
                    res.get(res.size()-1).add(0.0);

                }
                number_of_zeros--;
            }
        }
        if (number_of_zeros !=0 ){
            while (number_of_zeros != 0){
                res.get(0).add(0.0);
                number_of_zeros--;
            }
        }
        return true;
    }

    private void make_new_array(ArrayList<Integer> taken){
        taken.sort(Collections.reverseOrder());
        for (int i: taken) {
            my_array.remove(i);
        }
    }

    private void make_output_col(ArrayList<Integer> taken){
        ArrayList<Double> col = new ArrayList<>();
        for (int i: taken){
            col.add(my_array.get(i));
        }
        res.add(col);
    }

    private Double take_positive(Double sum, int current_pos, int current_neg, ArrayList<Integer> taken, boolean entering_point){
        if (my_array.get(current_pos)>0) {
            sum += my_array.get(current_pos);
            taken.add(current_pos);
            int add_number = 1;
            while (sum != max_sum)
            {
                Double new_sum;
                if (sum >= max_sum)
                    new_sum = take_negative(sum, current_pos+add_number, current_neg, taken, false);
                else
                    new_sum = take_positive(sum, current_pos+add_number, current_neg, taken, false);
                if (new_sum == null){
                    if (current_neg + add_number + current_pos >= my_array.size()){
                        taken.remove(taken.size()-1);
                        return null;
                    }
                    add_number++;
                }
                else
                    sum = new_sum;
            }
            if (entering_point){
                make_output_col(taken);
                make_new_array(taken);
            }
            return sum;
        }
        else
            return null;
    }

    private Double take_negative(Double sum, int current_pos, int current_neg, ArrayList<Integer> taken, boolean entering_point){
        //System.out.println(taken);
        if (my_array.get(my_array.size()- current_neg)<0){
            sum += my_array.get(my_array.size()- current_neg);
            taken.add(my_array.size() - current_neg);
            int add_number = 1;
            while (sum != max_sum)
            {
                Double new_sum;
                if (sum >= max_sum)
                    new_sum = take_negative(sum, current_pos, current_neg + add_number, taken, false);
                else
                    new_sum = take_positive(sum, current_pos, current_neg + add_number, taken, false);
                if (new_sum == null){
                    if (current_neg + add_number + current_pos >= my_array.size()) {
                        taken.remove(taken.size()-1);
                        return null;
                    }
                    add_number++;
                }
                else
                    sum = new_sum;
            }
            if (entering_point){
                make_output_col(taken);
                make_new_array(taken);
            }
            return sum;
        }
        else return null;
    }

    public String print_result(){
        while (!my_array.isEmpty()){
            ArrayList<Integer> taken = new ArrayList<>();
            Double check;
            if (my_array.get(0) >= 0)
                check = take_positive(0.0, 0, 1, taken, true);
            else
                check = take_negative(0.0, 0, 1, taken, true);
            if (check == null)
                return "Couldn't find the result";
        }
        if (if_all_filled())
            return res.toString();
        else
            return "Couldn't find the result";
    }
}
