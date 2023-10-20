package ProgramLiterals;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class PajakPendapatanTahunan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ulangi;

        do {
            System.out.println("=== Kalkulator Kode Pajak ===");

            int kodePajak1 = getInput("Masukkan Kode Pajak 1: ");
            int persentasePajak1 = getInput("Masukkan Persentase Pajak 1 (%): ");
            int kodePajak2 = getInput("Masukkan Kode Pajak 2: ");
            int persentasePajak2 = getInput("Masukkan Persentase Pajak 2 (%): ");

            System.out.println("\n=== Hasil Perhitungan Pajak ===");

            displayResult("Kode Pajak 1", kodePajak1);
            displayResult("Persentase Pajak 1", persentasePajak1 + "%");
            displayResult("Kode Pajak 2", kodePajak2);
            displayResult("Persentase Pajak 2", persentasePajak2 + "%");

            calculateAndDisplayTax(kodePajak1, persentasePajak1);
            calculateAndDisplayTax(kodePajak2, persentasePajak2);

            ulangi = getYesNoInput("Hitung pajak lagi? (Y/N): ");
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
        System.out.println("Terima kasih telah menggunakan kalkulator pajak!");
    }

    private static int getInput(String message) {
        int value = 0;
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(message);
                value = input.nextInt();
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("Masukkan angka positif.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Pastikan Anda memasukkan angka yang benar.");
                input.nextLine(); // Clear the invalid input.
            }
        }
    }

    private static void displayResult(String label, Object value) {
        System.out.printf("%-20s: %s%n", label, value);
    }

    private static void calculateAndDisplayTax(int kodePajak, int persentasePajak) {
        double pajak = (double) kodePajak * persentasePajak / 100;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedPajak = currencyFormatter.format(pajak);
        displayResult("Pajak Kode " + kodePajak, formattedPajak);
    }

    private static char getYesNoInput(String message) {
        Scanner input = new Scanner(System.in);
        char response;

        while (true) {
            System.out.print(message);
            response = input.next().charAt(0);
            if (response == 'Y' || response == 'y' || response == 'N' || response == 'n') {
                return response;
            } else {
                System.out.println("Pilihan tidak valid. Masukkan 'Y' atau 'N'.");
            }
        }
    }
}
