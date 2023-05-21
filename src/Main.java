import FinalExamPREMCC.Manager;
import FinalExamPREMCC.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Manager manager = new Manager();

        System.out.println("  Selamat Datang Di Aplikasi Pengelolaan Karyawan PT ABC");
        int pilihMenu;
        Boolean loopPilihan = true;
        while (loopPilihan) {
            menu.DaftarMenu();
            Scanner in = new Scanner(System.in);
            System.out.print("Masukkan pilihan anda : ");
            pilihMenu = in.nextInt();
            System.out.println("==========================================================");
            switch (pilihMenu) {
                case 1:
                    manager.AddEmployee();
                    System.out.println("Data berhasil disimpan!");
                    menu.Wait();
                    break;
                case 2:
                    manager.ViewEmployee();
                    System.out.println("===================================================================================================");
                    menu.Wait();
                    break;
                case 3:
                    manager.SearchByName();
                    menu.Wait();
                    break;
                case 4:
                    manager.SearchByJob();
                    System.out.println("===================================================================================================");
                    menu.Wait();
                    break;
                case 0:
                    menu.Foot();
                    loopPilihan =false;
                    break;
            }
        }
    }
}