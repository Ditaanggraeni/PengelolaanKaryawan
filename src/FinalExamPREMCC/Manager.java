package FinalExamPREMCC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* inheritance => class Manager merupakan class turunan dari class employee, sehingga memungkinkan
class employee mewariskan atribut dan methodnya
 */
public class Manager extends Employee{
    public Double allowance; //Penambahan satu atribut yaitu allowance
    List<Manager> employeeList = new ArrayList<>(); //Create list objek

    //Constructor full param, digunakan untuk inisialisasi nilai awal setiap atribut
    public Manager(String name, String job, Double salary, Double allowance) {
        this.setName(name);
        this.setJob(job);
        this.setSalary(salary);
        this.allowance = allowance;
    }

    /*constructor kosong => karena sebelumnya sudah dibuat sebuah constructor full param,
     maka perlu dibuat lagi sebuah constructor kosong untuk membuat objek manager*/
    public Manager() {

    }

    /*Overloading => membuat banyak method dengan nama yang sama dan di kelas yang sama namun berbeda
    bentuk, bisa berbeda parameter atau data typenya */
    public Double CalculateSalary(Double tax, Double salary, Double allowance)
    {
        Double total = (salary + allowance) * tax;
        return total;
    }

    public double CalculateSalary(int bpjs)
    {
        return bpjs;
    }

    public Double CalculateSalary(Double tax, int bpjs, Double salary, Double allowance)
    {
        Double total = salary + allowance;
        Double tot_tax = total * tax;
        Double totalSalary = (total - bpjs) - tot_tax;
        return totalSalary;
    }
    Scanner input = new Scanner(System.in);
    public void AddEmployee(){
        System.out.print("Masukkan nama karyawan : ");
        String name = input.nextLine();
        System.out.print("Masukkan job : ");
        String job = input.nextLine();
        System.out.print("Masukkan salary : ");
        Double salary = Double.valueOf(input.nextLine());
        System.out.print("Masukkan tunjangan : ");
        allowance = Double.valueOf(input.nextLine());
        
        /* proses inisialisasi atribut pada class manager dengan memanfaatkan constructor yang menerima
        4 buah parameter maka saat mengunakan methodnya harus memberikan 4 buah argumen yang kemudian
        disimpan ke variabel karyawan */
        Manager karyawan = new Manager(name, job, salary, allowance);
        employeeList.add(karyawan); // Menambahkan data yang sebelumnya ditampung pada variabel karyawan ke dalam list
    }

    public void ViewEmployee(){
        System.out.println("===================================================================================================");
        System.out.println("Name \t\t Job \t\t Salary \t\t Tunjangan \t\t  Tax \t\t BPJS \t\tTotal Salary");
        System.out.println("---------------------------------------------------------------------------------------------------");
        /* Meanfaatkan conditional statement jika data dalam listnya masih kosong maka akan ditampilkan sebuah pesan
		untuk menambahkan data terlebih dahulu */
        if(employeeList.size() == 0) {
            System.out.println("Data tidak tersedia, silahkan tambahkan data terlebih dahulu!");
        } else {
            for(Manager list : employeeList){
                System.out.println(list.getName() + "\t\t" + list.getJob() + "\t\t" + list.getSalary() + "\t\t" +list.allowance +
                       "\t\t" + CalculateSalary(0.05, list.getSalary(), list.allowance) + " \t\t" + CalculateSalary(50000)+ "\t\t " +CalculateSalary(0.05, 50000, list.getSalary(), list.allowance));
            }
        }
    }

    @Override
    public void TampilData() {
        super.TampilData();
        System.out.println("Tunjangan    : " + allowance);
    }

    public void SearchByName(){
        System.out.print("Masukkan nama karyawan : ");
        String searchName = (input.nextLine());
        System.out.println("===============================");
        Boolean employeeFound = false;
        for (Manager list : employeeList) {
            if (searchName.equals(list.getName())) {
                setName(list.getName());
                setJob(list.getJob());
                setSalary(list.getSalary());
                allowance = list.allowance;
                TampilData();
                System.out.println("Tax          : " + CalculateSalary(0.05, list.getSalary(), list.allowance));
                System.out.println("BPJS         : " + CalculateSalary(500000));
                System.out.println("---------------------------");
                System.out.println("Total Salary : " + CalculateSalary(0.05, 50000, list.getSalary(), allowance));
                System.out.println("===============================");
                employeeFound = true;
                System.out.print("Hapus karyawan [y/t] ? ");
                String del = (input.nextLine());
                System.out.println("===============================");
                if (del.equals("y") || del.equals("Y")){
                    employeeList.remove(list);
                    System.out.println("Data berhasil dihapus!");
                    break;
                } else {
                    System.out.println(" ");
                }
                break;
            }
        }
        if (!employeeFound){
            System.out.println("Data tidak ditemukan!");
        }
    }

    public void SearchByJob(){
        System.out.print("Masukkan Job : ");
        String searchJob = (input.nextLine());
        System.out.println("===================================================================================================");
        System.out.println("Name \t\t Job \t\t Salary \t\t Tunjangan \t\t  Tax \t\t BPJS \t\tTotal Salary");
        System.out.println("---------------------------------------------------------------------------------------------------");
        Boolean jobFound = false;
        for(Manager list : employeeList){
            if (searchJob.equals(list.getJob())) {
                System.out.println(list.getName() + "\t\t" + list.getJob() + "\t\t" + list.getSalary() + "\t\t" + list.allowance +
                "\t\t" + CalculateSalary(0.05, list.getSalary(), list.allowance) + " \t\t" + CalculateSalary(50000) +
                "\t\t " + CalculateSalary(0.05, 50000, list.getSalary(), list.allowance));
                jobFound = true;
            }
        }
        if (!jobFound){
            System.out.println("Job tidak ditemukan!");
        }
    }
}