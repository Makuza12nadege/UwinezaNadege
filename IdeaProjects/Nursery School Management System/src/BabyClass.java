public class BabyClass extends NurseryClass {
    public BabyClass(String classId) {
        super(classId, "Baby Class", 15);
    }

    @Override
    public boolean enrollStudent(Student student) {
        if (isFull() || student.getAge() < 2 || student.getAge() > 3 || studentExists(student.getStudentId())) {
            return false;
        }
        students.add(student);
        student.setRegisteredClass(this);
        return true;
    }

    @Override
    public void trackProgress() {
        classProgress = "Motor skills and play-based learning progressing well.";
    }

    @Override
    public void conductActivity(String activityName) {
        activities.add(activityName);
        System.out.println("Conducted: " + activityName);
    }

    @Override
    public void generateClassReport() {
        System.out.println("\n--- Baby Class Report ---");
        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.getTeacherName() : "None"));
        System.out.println("Total Students: " + students.size());
        System.out.println("Activities: " + activities);
        System.out.println("Progress: " + classProgress);
    }

    @Override
    public void assignTeacher(Teacher teacher) {
        if (!teacher.getTeacherRole().equalsIgnoreCase("Early Childhood Educator")) {
            System.out.println("Only Early Childhood Educators can teach Baby Class.");
            return;
        }
        super.assignTeacher(teacher);
    }
}
