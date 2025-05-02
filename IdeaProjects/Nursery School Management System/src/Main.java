import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NurseryClass babyClass = new BabyClass("BC101");

        System.out.println("Enter Teacher Details:");
        System.out.print("ID: ");
        String tid = scanner.nextLine();
        System.out.print("Name: ");
        String tname = scanner.nextLine();
        System.out.print("Role: ");
        String trole = scanner.nextLine();
        Teacher teacher = new Teacher(tid, tname, trole);
        babyClass.assignTeacher(teacher);

        for (int i = 0; i < 2; i++) {
            System.out.println("\nEnter Student " + (i + 1) + " Details:");
            System.out.print("ID: ");
            String sid = scanner.nextLine();
            System.out.print("Name: ");
            String sname = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // consume newline
            System.out.print("Guardian Name: ");
            String guardian = scanner.nextLine();

            Student s = new Student(sid, sname, age, guardian);
            if (babyClass.enrollStudent(s)) {
                System.out.println("Enrolled successfully!");
            } else {
                System.out.println("Enrollment failed! Check age, ID duplication, or class capacity.");
            }
        }

        babyClass.conductActivity("Finger Painting");
        babyClass.trackProgress();
        babyClass.generateClassReport();

        scanner.close();
    }
}
