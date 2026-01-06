package class005;

import java.util.Arrays;

/**
 * @className: FindNumber
 * @description:
 * @author: Yang Naihua
 * @create: 2026-01-05 18:53
 **/
public class FindNumber {

    public static void main(String[] args) {

        int N = 1000;
        int V = 100000;
        int testTimes = 10000;

        System.out.println("----start------");
        for (int i = 1; i <= testTimes; i++) {
            int length = (int) (N * Math.random());
            int number = (int) (V * Math.random());
            int[] originArray = randomArray(length, number);
            Arrays.sort(originArray);

            if (find(originArray, number) != findNumber(originArray, number)) {
                System.err.println("--ERROR---");
            }
        }
        System.out.println("----end------");
    }

    /**
     * @description: 产生随机长度的数组
     * @method randomArray
     * @date 2026-01-05 18:57:57
     * @author Yang Naihua
     */
    public static int[] randomArray(int length, int v) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int) (Math.random() * v) + 1;
        }
        return result;
    }


    /**
     * @description: 正常找到
     * @method find
     * @date 2026-01-05 19:20:57
     * @author Yang Naihua
     */
    public static boolean find(int[] array, int number) {
        for (int arr : array) {
            if (arr == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean findNumber(int[] array, int number) {
        if (array == null || array.length < 1) {
            return false;
        }
        int l = 0;
        int r = array.length - 1;
        int m = 0;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (array[m] == number) {
                return true;
            } else if (array[m] > number) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}