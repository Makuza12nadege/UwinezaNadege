public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String guardianName;
    private NurseryClass registeredClass;

    public Student(String studentId, String studentName, int age, String guardianName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.guardianName = guardianName;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getAge() {
        return age;
    }

    public void setRegisteredClass(NurseryClass registeredClass) {
        this.registeredClass = registeredClass;
    }
}
