package HitungIPS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Buat input
        Scanner Scan = new Scanner(System.in);

        // Input Nama
        System.out.print("Masukkan namamu: ");
        String nama = Scan.nextLine();

        // Input NIM
        System.out.print("Masukkan NIM-mu: ");
        String NIM = Scan.nextLine();

        // Berapa Matkul
        System.out.println("Berapa matkul? ");
        Integer m = 0;
        if (Scan.hasNextInt()) {
            m = Scan.nextInt();
        }

        // Buat Perhitungan
        String[] arrayMatkul = new String[m]; // Memasukkan ke array
        Integer n = 3;
        Integer totalSKS = 0;
        Integer[][] arrayNilai = new Integer[m][n];
        Integer[] arraySKS = new Integer[m];
        String nilaiHuruf;
        Double nilaiBobot;
        Double nilaiAkhir;
        Double nilaiBobotAkhir;
        Double totalNilaiBobotAkhir = 0.0;

        // Input Mata Kuliah
        System.out.println("Isi Nama matkul: ");
        for (int i = 0; i < m; i++) {
            if (Scan.hasNextLine()) {
                arrayMatkul[i] = Scan.next();
            }

            // Input SKS
            System.out.println("Berapa SKS? ");
            if (Scan.hasNextInt()) {
                arraySKS[i] = Scan.nextInt();
                totalSKS = totalSKS += arraySKS[i];
            }

            // Input Nilai
            System.out.println("Nilai UTS, UAS, Tugas");
            for (int k = 0; k < n; k++) {
                System.out.println("Posisi [" + i + "] [" + k + "]: ");
                if (Scan.hasNextInt()) {
                    arrayNilai[i][k] = Scan.nextInt();
                }
            }
        }

        // Akhir
        for (int i = 0; i < m; i++) {
            System.out.println("Mata kuliah: " + arrayMatkul[i]);
            System.out.println("SKS: " + arraySKS[i]);

            // Perhitungan
            nilaiAkhir = (arrayNilai[i][0] * 0.3) + (arrayNilai[i][1] * 0.3) + (arrayNilai[i][2] * 0.4);

            // Penentuan Nilai Huruf dan NIlai Bobot
            if (nilaiAkhir <= 100 && nilaiAkhir >= 80) {
                nilaiHuruf = "A";
                nilaiBobot = 4.0;
            } else if (nilaiAkhir <= 79 && nilaiAkhir >= 75) {
                nilaiHuruf = "B+";
                nilaiBobot = 3.5;
            } else if (nilaiAkhir <= 74 && nilaiAkhir >= 65) {
                nilaiHuruf = "B";
                nilaiBobot = 3.0;
            } else if (nilaiAkhir <= 64 && nilaiAkhir >= 60) {
                nilaiHuruf = "C+";
                nilaiBobot = 2.5;
            } else if (nilaiAkhir <= 59 && nilaiAkhir >= 50) {
                nilaiHuruf = "C";
                nilaiBobot = 2.0;
            } else if (nilaiAkhir <= 49 && nilaiAkhir >= 45) {
                nilaiHuruf = "D";
                nilaiBobot = 1.5;
            } else {
                nilaiHuruf = "E";
                nilaiBobot = 1.0;
            }

            // Menghitung SKS dengan nilai Bobot
            nilaiBobotAkhir = arraySKS[i] * nilaiBobot;
            totalNilaiBobotAkhir = nilaiBobotAkhir;


            // Output
            System.out.println("Nilai UTS: " + arrayNilai[i][0]);
            System.out.println("Nilai UAS: " + arrayNilai[i][1]);
            System.out.println("Nilai TUGAS: " + arrayNilai[i][2]);
            System.out.println("Nilai Akhir: " + nilaiAkhir);
            System.out.println("Nilai Huruf: " + nilaiHuruf);
            System.out.println("Nilai Bobot: " + nilaiBobot);
            System.out.println("Nilai Bobot Akhir: " + nilaiBobotAkhir);
            System.out.println("");
        }

        // Output
        Double IPS = totalNilaiBobotAkhir / totalSKS;
        System.out.println("\nREKAPITULASI IPS:");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + NIM);
        System.out.println("Total SKS: " + totalSKS);
        System.out.println("Total Nilai Bobot Akhir:" + totalNilaiBobotAkhir);
        System.out.printf("IPS: %.2f", IPS);
    }

    // // Test
    // System.out.println(m);
    // System.out.println(arrayMatkul[0]);
    // System.out.println(arrayNilai[1][0]);
    // System.out.println("Namamu adalah " + nama);
    // System.out.println("NIM: " + NIM);
}