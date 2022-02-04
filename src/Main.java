public class Main {

    public static void main(String[] args) {
        //double[] c = {1, 2, 3, 4, 5, 6, 1, 3, 7, 4};
        double[] c = {1, 2, 3, 4, 6, 6, 1, 3, 7, 4};
        System.out.println(FirstTask.DO(c));

        //int n = 12345;
        int n = 1234984;
        System.out.println(SecondTask.DO(n));

        //Double[] data = {3.0, 1.0, 1.0, 2.0, 2.0, 1.0};
        //Double[] data = {4.0, 8.0, 8.0, 4.0};
        Double[] data = {6.0, 8.0, 7.0, 9.0, 7.0, 7.0, 1.0};
        int number_of_groups = 2;
        System.out.println(ThirdTask.DO(data, number_of_groups));
    }
}
