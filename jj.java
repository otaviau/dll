import java.util.Scanner;
public class jj {
    public static void main(String[] args) {
        DoubleLinkList20 list = new DoubleLinkList20();
        Scanner sc = new Scanner(System.in);
        int pilihan;
        do{
            System.out.println("\nMENU DOUBLE LINK LIST MAHASISWA");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Menampilkan data");
            System.out.println("7. Cari mahasiswa berdasarkan NIM");
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
                System.out.println("Masukkan NIM yang dicari: ");
                String nim = sc.nextLine();
                Node20 found = list.search(nim);
                if (found != null) {
                    System.out.println("Data ditemukan:");
                    found.data.tampil();
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
                break;
            case 0:
                System.out.println("Keluar dari program.");
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    } while (pilihan!= 0){
        sc.close();
    }
}
