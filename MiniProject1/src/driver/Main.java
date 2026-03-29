package driver;

import java.util.ArrayList;
import java.util.Scanner;
import model.Mahasiswa;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> daftar = new ArrayList<>();

        System.out.println("=== INPUT DATA MAHASISWA ===");
        System.out.println("Format: Nama;NIM;Nilai");
        System.out.println("Ketik '---' untuk selesai\n");

        while (true) {
            System.out.print("Input: ");
            String baris = input.nextLine();

            if (baris.equals("---")) {
                break;
            }

            try {
                String[] data = baris.split(";");

                String nama = data[0];
                String nim = data[1];
                double nilai = Double.parseDouble(data[2]);

                daftar.add(new Mahasiswa(nama, nim, nilai));

            } catch (Exception e) {
                System.out.println("Format salah! Gunakan: Nama;NIM;Nilai");
            }
        }

        // OUTPUT TABEL
        System.out.println("\n=== DATA MAHASISWA ===");
        System.out.println("--------------------------------------------------");
        System.out.printf("| %-20s | %-10s | %-5s | %-5s |\n", "Nama", "NIM", "Nilai", "Grade");
        System.out.println("--------------------------------------------------");

        for (Mahasiswa m : daftar) {
            System.out.printf("| %-20s | %-10s | %-5.1f | %-5s |\n",
                    m.getNama(),
                    m.getNim(),
                    m.getNilai(),
                    m.getGrade());
        }

        System.out.println("--------------------------------------------------");

        input.close();
    }
}