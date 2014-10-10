/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler.pkg23;

import static java.lang.Math.sqrt;
import java.util.Arrays;

/**
 *
 * @author s-xuch
 */
public class Euler23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int max = 28123;
        int[] abundantnums = abundantnums(max);
        int[] summable = tester(max, abundantnums);
        Arrays.sort(summable);
        int sum = subtractor(summable);
        System.out.println(sum);
    }

    public static int subtractor(int[] file) {
        double y = 28123 * 28124 / 2;
        for (int x = 0; x < file.length; x++) {
            y = y - file[x];
        }
        int sum = (int) y;
        return sum;
    }

    public static int[] tester(int max, int[] abundantnums) {
        boolean[] buffer = new boolean[max];
        int[] file = new int[max];

        int counter = 0;
        for (int x = 0; x < abundantnums.length && abundantnums[x] < max; x++) {
            for (int y = x; y < abundantnums.length && abundantnums[y] < max && abundantnums[x] + abundantnums[y] < max; y++) {
                buffer[abundantnums[x] + abundantnums[y]] = true;
            }

        }
        for (int x = counter = 0; counter < buffer.length; counter++) {
            if (buffer[counter]) {
                file[x] = counter;
                x++;
            }
        }
//        while(counter<)
        return file;
    }

    public static int[] abundantnums(int max) {
        int x = 6;
        int y = 0;
        int[] file = new int[max / 2];
        while (x < max) {
            if ((divisorsum(x) - x) > x) {
                file[y] = x;
                y++;
            }
            x++;
        }
        return file;
    }

    public static int divisorsum(int x) {
        int sum, divisor;
        int y = 0;
        int[] file = new int[(int) Math.sqrt(x) + 50];
        sum = 0;
        divisor = 1;
        do {
            if (x % divisor == 0) {

                sum = sum + 2;
                file[y] = divisor;
                file[y + 1] = x / divisor;

                y = y + 2;
            }
            divisor++;
        } while (divisor < x / divisor);
        sum = 0;
        if (Math.floor(sqrt(x)) == sqrt(x)) {
            sum = (int) (-sqrt(x));

        }
        y = 0;
        while (y < file.length) {
            sum = file[y] + sum;
            y++;
        }
        return sum;
    }
}
