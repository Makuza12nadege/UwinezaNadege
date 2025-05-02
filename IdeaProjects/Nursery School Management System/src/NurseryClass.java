import java.util.ArrayList;

public abstract class NurseryClass {
    protected String classId;
    protected String className;
    protected int maxCapacity;
    protected Teacher assignedTeacher;
    protected ArrayList<Student> students = new ArrayList<>();
    protected ArrayList<String> activities = new ArrayList<>();
    protected String classProgress = "No progress yet.";

    public NurseryClass(String classId, String className, int maxCapacity) {
        this.classId = classId;
        this.className = className;
        this.maxCapacity = maxCapacity;
    }

    public abstract boolean enrollStudent(Student student);
    public abstract void trackProgress();
    public abstract void conductActivity(String activityName);
    public abstract void generateClassReport();

    public void assignTeacher(Teacher teacher) {
        this.assignedTeacher = teacher;
        teacher.setAssignedClass(this);
    }

    public boolean isFull() {
        return students.size() >= maxCapacity;
    }

    public boolean studentExists(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) return true;
        }
        return false;
    }
}
