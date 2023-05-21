package FinalExamPREMCC;

import java.util.Scanner;

public abstract class Output {
    public abstract void DaftarMenu();

    // note : perbedaan abstract dan interface
    // kalo di abstract bisa buat method pake body tp di interface ga bisa bikin method pake body
    public void Wait(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nTekan Enter untuk kembali ke Menu . . .");
        String in = input.nextLine();
    }
    public abstract void Foot();
}
