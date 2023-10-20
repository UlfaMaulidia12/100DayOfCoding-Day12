package ProgramFloatingNumber;

import java.util.Scanner;

public class PajakTahunandanBulanan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ulangi;

        do {
            System.out.println("=== Kalkulator Pajak ===");
            double pendapatanTahunan = getInput("Masukkan Pendapatan Tahunan: $");
            double tarifPajak = getInput("Masukkan Tarif Pajak Tahunan (%): ");
            double jumlahPajakTahunan = calculateTax(pendapatanTahunan, tarifPajak);
            double jumlahPajakBulanan = jumlahPajakTahunan / 12;

            System.out.println("\n=== Hasil Perhitungan Pajak ===");
            displayResult("Pendapatan Tahunan", pendapatanTahunan);
            displayResult("Tarif Pajak Tahunan", tarifPajak);
            displayResult("Pajak Tahunan", jumlahPajakTahunan);
            displayResult("Pajak Bulanan", jumlahPajakBulanan);

            ulangi = getYesNoInput("Hitung pajak lagi? (Y/N): ");
        } while (ulangi == 'Y' || ulangi == 'y');

        input.close();
        System.out.println("Terima kasih telah menggunakan kalkulator pajak!");
    }

    private static double getInput(String message) {
        double value = 0;
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(message);
                value = input.nextDouble();
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

    private static double calculateTax(double pendapatan, double tarif) {
        return pendapatan * tarif / 100;
    }

    private static void displayResult(String label, double value) {
        System.out.printf("%-20s: $%.2f%n", label, value);
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
