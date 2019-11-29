package Exercise;

public class Employee {
    private String maritalStatus;
    private String firstName;
    private String lastName;
    private long salary;

    public Employee(String firstName, String lastName, String maritalStatus, long salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.maritalStatus = maritalStatus;
    }

    public String getName(){
        return firstName + ' ' + lastName;
    }

    public boolean isMarried(){
        return maritalStatus.equals("married");
    }

    public long getSalary() {
        return salary;
    }
}
