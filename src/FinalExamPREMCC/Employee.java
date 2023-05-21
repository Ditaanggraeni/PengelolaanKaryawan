package FinalExamPREMCC;

public class Employee {
    //Encapsulation Getter and Setter
    private String name;
    private String job;
    private Double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void TampilData(){
            System.out.println("Name   	     : " + getName());
            System.out.println("Job    	     : " + getJob());
            System.out.println("Salary 	     : " + getSalary());
    }
}
