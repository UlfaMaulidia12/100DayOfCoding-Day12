package ProgramUnderscore;

import java.util.Scanner;

public class Pajak {
    public static void main(String[] args) {
        char ulangi;

        try (Scanner input = new Scanner(System.in)) {
            do {
                System.out.println("=== Program Angka ===");

                int angka = getInput("Masukkan angka: ");

                System.out.println("======================================="); // Garis pemisah

                if (angka < 0) {
                    System.out.println("Angka tidak valid. Masukkan angka positif.");
                } else {
                    System.out.println("Angka yang Anda masukkan: " + angka);
                    System.out.println("Pilihan operasi matematika:");
                    System.out.println("1. Kuadrat");
                    System.out.println("2. Akar Kuadrat");
                    System.out.print("Pilih operasi (1/2): ");
                    int pilihan = input.nextInt();

                    if (pilihan == 1) {
                        int kuadrat = calculateSquare(angka);
                        System.out.println("Kuadrat angka: " + kuadrat);
                    } else if (pilihan == 2) {
                        if (angka >= 0) {
                            double akarKuadrat = calculateSquareRoot(angka);
                            System.out.println("Akar kuadrat angka: " + akarKuadrat);
                        } else {
                            System.out.println("Akar kuadrat tidak valid untuk angka negatif.");
                        }
                    } else {
                        System.out.println("Operasi tidak valid. Silakan pilih 1 atau 2.");
                    }
                }

                System.out.println("======================================="); // Garis pemisah

                ulangi = getYesNoInput("Ingin memasukkan angka lagi? (Y/N): ");
            } while (ulangi == 'Y' || ulangi == 'y');
        }

        System.out.println("Terima kasih!");
    }

    private static int getInput(String message) {
        int angka = 0;
        boolean valid = false;
        
        try (Scanner input = new Scanner(System.in)) {
            while (!valid) {
                try {
                    System.out.print(message);
                    angka = input.nextInt();
                    valid = true;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Input tidak valid. Masukkan angka bulat yang benar.");
                    input.nextLine(); // Bersihkan buffer input
                }
            }
        }
        
        return angka;
    }

    private static int calculateSquare(int angka) {
        return angka * angka;
    }

    private static double calculateSquareRoot(int angka) {
        return Math.sqrt(angka);
    }

    private static char getYesNoInput(String message) {
        char response;
        
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.print(message);
                response = input.next().charAt(0);
                if (response == 'Y' || response == 'y' || response == 'N' || response == 'n') {
                    break;
                } else {
                    System.out.println("Pilihan tidak valid. Masukkan 'Y' atau 'N'.");
                }
            }
        }
        
        return response;
    }
}
