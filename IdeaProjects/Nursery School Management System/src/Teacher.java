public class Teacher {
    private String teacherId;
    private String teacherName;
    private String teacherRole;
    private NurseryClass assignedClass;

    public Teacher(String teacherId, String teacherName, String teacherRole) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherRole = teacherRole;
    }

    public String getTeacherRole() {
        return teacherRole;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setAssignedClass(NurseryClass assignedClass) {
        this.assignedClass = assignedClass;
    }
}
