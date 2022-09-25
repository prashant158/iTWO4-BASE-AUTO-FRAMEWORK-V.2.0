package Practice_Programs;

public class InterviewMinnumber {
/*2  4  5

3  4  7

1  2  9*/
//Maximum number from the array

    public static void main(String[] args) {
// TODO Auto-generated method stub

        int abc[][] = {{2, 4, 5}, {3, 2, 10}, {1, 2, -1}};
        int min = abc[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (abc[i][j] < min)//2
                {
                    min = abc[i][j];
                }
            }
            }
        System.out.println(min);

    }

}
