import java.util.Scanner;
/**
 * Kelas CalculatorRefactored merupakan implementasi kalkulator sederhana
 * yang dapat melakukan operasi aritmatika dasar (penjumlahan, pengurangan,
 * perkalian, dan pembagian) melalui antarmuka konsol.
 */
public class Calculator {
    /**
     * Method utama yang menjalankan program kalkulator.
     * Method ini mengatur alur program dengan meminta input dari pengguna,
     * melakukan perhitungan, dan menampilkan hasilnya.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kalkulator Sederhana");
        System.out.print("Masukkan angka pertama: ");
        double a = inputAngka(scanner);

        System.out.print("Masukkan operasi (+, -, *, /): ");
        String op = inputOperator(scanner);

        System.out.print("Masukkan angka kedua: ");
        double b = inputAngka(scanner);

        double result = 0;
        if (op.equals("+")) {
            result = a + b;
        } else if (op.equals("-")) {
            result = a - b;
        } else if (op.equals("*")) {
            result = a * b;
        } else if (op.equals("/")) {
            if (b != 0) {
                result = a / b;
            } else {
                errorBagiNol();
                return;
            }
        } else {
            exception();
            return;
        }

        hasilAKhir(result);
        scanner.close();
    }

    /**
     * Menampilkan pesan error ketika terjadi pembagian dengan nol.
     */
    private static void errorBagiNol() {
        System.out.println("Error: Pembagian dengan nol!");
    }

    /**
     * Menampilkan pesan error ketika operasi yang dimasukkan tidak valid.
     */
    private static void exception() {
        System.out.println("Operasi tidak valid!");
    }

    /**
     * Menampilkan hasil perhitungan ke layar.
     *
     * @param result Hasil perhitungan yang akan ditampilkan
     */
    private static void hasilAKhir(double result) {
        System.out.println("Hasil: " + result);
    }

    /**
     * Membaca input operator aritmatika dari pengguna.
     *
     * @param scanner Objek Scanner untuk membaca input
     * @return String berupa operator aritmatika (+, -, *, /)
     */
    private static String inputOperator(Scanner scanner) {
        String op = scanner.next();
        return op;
    }

    /**
     * Membaca input angka dari pengguna.
     *
     * @param scanner Objek Scanner untuk membaca input
     * @return double Angka yang dimasukkan pengguna
     */
    private static double inputAngka(Scanner scanner) {
        double a = scanner.nextDouble();
        return a;
    }
}