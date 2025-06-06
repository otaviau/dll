import java.util.Scanner;
public class DDLMain {
    public static void main(String[] args) {
        DoubleLinkList20 list = new DoubleLinkList20();
        Scanner sc = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\nMENU DOUBLE LINK LIST MAHASISWA");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Menampilkan data");
            System.out.println("6. Cari mahasiswa berdasarkan NIM");
            System.out.println("7. Tambah data setelah NIM tertentu");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt(); sc.nextLine();
            switch (pilihan) {
                case 1:
                    Mahasiswa20 mhs1 = inputMahasiswa(sc);
                    list.addFirst(mhs1);
                    break;
                case 2:
                    Mahasiswa20 mhs2 = inputMahasiswa(sc);
                    list.addLast(mhs2);
                    break;
                case 3:
                    list.removeFirst();
                    break;
                case 4:
                    list.removeLast();
                    break;
                case 5:
                    list.print();
                    break;
                case 6:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nim = sc.nextLine();
                    Node20 found = list.search(nim);
                    if (found != null) {
                        System.out.println("Data ditemukan:");
                        found.data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;
                case 7:
                    System.out.print("Masukkan NIM yang dicari sebagai posisi sisip: ");
                    String keyNim = sc.nextLine();
                    Mahasiswa20 mhsInsert = inputMahasiswa(sc);
                    list.insertAfter(keyNim, mhsInsert);
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilihan != 0);
        sc.close();
    }

    public static Mahasiswa20 inputMahasiswa(Scanner sc) {
        System.out.print("NIM: ");
        String nim = sc.nextLine();
        System.out.print("Nama: ");
        String nama = sc.nextLine();
        System.out.print("Kelas: ");
        String kelas = sc.nextLine();
        System.out.print("IPK: ");
        double ipk = sc.nextDouble(); sc.nextLine();
        return new Mahasiswa20(nim, nama, kelas, ipk);
    }
}
