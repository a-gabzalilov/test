public class Main {

    public static void main(String[] args) {
        //double[] c = {1, 2, 3, 4, 5, 6, 1, 3, 7, 4};
        //double[] c = {1, 2, 3, 4, 6, 6, 1, 3, 7, 4};
        double[] c = {4, -2, -3, 1, 2, 3};
        //double[] c = {-4, -5, -6, -4, -4, 0};
        //double[] c = {2, 3, 4, 0, 0, 0};
        //double[] c = {0, 0, 0, 3, 7, 4, 5};
        //double[] c ={0, 0, 2};
        System.out.println(FirstTask.DO(c));

        //int n = 12345;
        int n = 1234984;
        System.out.println(SecondTask.DO(n));

        /*Double[] data = {3.0, 1.0, 1.0, 2.0, 2.0, 1.0};
        int number_of_groups = 2;*/

        /*Double[] data = {4.0, 8.0, 8.0, 4.0};
        int number_of_groups = 2;*/

        /*Double[] data = {6.0, 8.0, 7.0, 9.0, 7.0, 7.0, 1.0};
        int number_of_groups = 3;*/

        /*Double[] data = {0.0, 0.0, 1.0, -1.0, 0.0};
        int number_of_groups = 3;*/

        /*Double[] data = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        int number_of_groups = 6;*/

        /*Double[] data = {-179d, 234d, 11d, 44d, 5d, 50d, 0d, 55d, 501d, -446d};
        int number_of_groups = 5;*/

        /*Double[] data = {-1d, -1d, 1d, 1d};
        int number_of_groups = 2;*/

        /*Double[] data = {8d, 6d, 5d, 3d, -1d, -2d, -4d};
        int number_of_groups = 3;*/

        Double[] data = {10d, 9d, 9d, 8d};
        int number_of_groups = 3;

        /*Double[] data = {10d, 9d, 9d, 8d};
        int number_of_groups = 2;*/
        System.out.println(ThirdTask.DO(data, number_of_groups));
    }
}
