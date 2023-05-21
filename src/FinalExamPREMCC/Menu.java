package FinalExamPREMCC;

public class Menu extends Output{
    //implement abstract method
    @Override
    public void DaftarMenu() {
        System.out.println("=======================Daftar Menu========================");
        System.out.println("1. Tambah data karyawan");
        System.out.println("2. Lihat data karyawan");
        System.out.println("3. Cari data karyawan berdasarkan nama karyawan");
        System.out.println("4. Cari data karyawan berdasarkan job");
        System.out.println("0. Keluar");
        System.out.println("==========================================================");
    }

    @Override
    public void Foot() {
        System.out.println("\t\t\t\t\t  Thank You! ");
        System.out.println("\t\t\t\tFor Using This Program :)");
        System.out.println("=================Copyright © 2023 PT ABC==================");
    }
}
