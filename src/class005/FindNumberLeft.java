package class005;

import java.util.Arrays;

/**
 * @className: FindNumber
 * @description:
 * @author: Yang Naihua
 * @create: 2026-01-05 18:53
 **/
public class FindNumberLeft {

    public static void main(String[] args) {

        System.out.println("--start--");
        int N = 100;
        int V = 100;
        int testTimes = 1000;
        int length = (int) (N * Math.random());
        int number = (int) (V * Math.random());

        for (int i = 1; i < testTimes; i++) {
            int[] array = randomArray(length, number);
            Arrays.sort(array);

            if (find(array, number) != findLeft(array, number)) {
                System.err.println("--ERROR!!--");
            }
        }
        System.out.println("--end--");

    }

    public static int[] randomArray(int length, int number) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int) Math.random() * number + 1;
        }
        return result;
    }

    public static int find(int[] array, int number) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] >= number) {
                return i;
            }
        }
        return -1;
    }

    public static int findLeft(int[] array, int number) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int l = 0;
        int right = array.length - 1;
        int m = 0;
        int ans = -1;

        while (l <= right) {
            m = l + ((right - l) >> 1);
            if (array[m] >= number) {
                ans = m;
                right = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}