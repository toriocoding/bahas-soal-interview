import java.util.Scanner;

/**
 * Minimum Dice Move
 * Youtube: https://www.youtube.com/watch?v=pX_FIcP8ADM
 *
 * Diberikan sebuah array dices berisikan angka yang merepresentasikan
 * angka yang muncul dari suatu dadu.
 *
 * Pertanyaan: Berapa geseran minimal yang dibutuhkan untuk menyamakan
 * angka yang muncul pada setiap dadu.
 *
 * Batasan:
 * 1 <= panjang(dices) <= 10^5
 * 1 <= D(i) <= 6
 *
 * Format input:
 * N
 * D(0) D(1) D(2) ... D(N-1)
 *
 * Contoh input:
 * 7
 * 4 4 4 3 3 1 1
 *
 * Contoh output:
 * 5
 *
 * Penjelasan:
 * Dibutuhkan 1 geseran untuk mengubah dadu index 0 agar menunjukkan angka 2 (1 -> 6)
 * Dibutuhkan 2 geseran untuk mengubah dadu index 4 agar menunjukkan angka 2 (5 -> 3 -> 2)
 *
 * Gambar pendukung:
 * http://printables.atozteacherstuff.com/wp-content/uploads/2019/08/cube_outline_dice-768x994.png
 */
public class MinimumDiceMove {

    private Scanner scanner;

    public MinimumDiceMove() {
        scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        int[] dices = new int[N];

        for (int i = 0; i < N; i++) {
            dices[i] = scanner.nextInt();
        }
        scanner.nextLine();

        System.out.println(minimumStep(N, dices));
    }

    private int[] doubleSteps = {0, 6, 5, 4, 3, 2, 1};
    private int getStepToChange(int a, int b) {
        if (a == b) return 0;
        if (doubleSteps[a] == b) return 2;
        return 1;
    }

    private int minimumStep(int N, int[] dices) {
        int minStep = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int currentStep = 0;
            for (int j = 0; j < N; j++) {
                currentStep += getStepToChange(dices[j], i);
            }
            minStep = Math.min(minStep, currentStep);
        }
        return minStep;
    }

}
