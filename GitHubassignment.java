import java.util.Scanner;

class GitHubassignment {
    private String nameOfEmp;
    private int empId;
    private double basicSalary;
    private double grossSalary;

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name of Employee: ");
        nameOfEmp = scanner.nextLine();
        System.out.print("Enter Employee ID: ");
        empId = scanner.nextInt();
        System.out.print("Enter Basic Salary: ");
        basicSalary = scanner.nextDouble();
        calculateGrossSalary();
    }

    private void calculateGrossSalary() {
        double hra = 0.25 * basicSalary;
        double da = 0.40 * basicSalary;
        grossSalary = basicSalary + hra + da;
    }

    public void displayConsonantEmployees() {
        if (!nameOfEmp.isEmpty() && !isVowel(nameOfEmp.charAt(0))) {
            System.out.println("Name: " + nameOfEmp + ", Gross Salary: " + grossSalary);
        }
    }

    public void displayEmployeesInRange() {
        if (empId >= 101 && empId <= 150) {
            System.out.println("Employee ID: " + empId + ", Gross Salary: " + grossSalary);
        }
    }

    public boolean isSalaryBelow(double limit) {
        return grossSalary < limit;
    }

    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();
        GitHubassignment[] employees = new GitHubassignment[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            employees[i] = new GitHubassignment();
            employees[i].input();
        }

        System.out.println("\nEmployees whose name starts with a consonant:");
        for (GitHubassignment employee : employees) {
            employee.displayConsonantEmployees();
        }

        System.out.println("\nEmployees with ID between 101 and 150:");
        for (GitHubassignment employee : employees) {
            employee.displayEmployeesInRange();
        }

        int count = 0;
        for (GitHubassignment employee : employees) {
            if (employee.isSalaryBelow(35000)) {
                count++;
            }
        }
        System.out.println("\nTotal number of employees with Gross Salary less than 35000: " + count);
    }
}