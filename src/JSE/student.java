package JSE;

public class student implements StudentService {
    // 我来试试java这个类的引用关系

    int id; // 学生的学号

    public student() {
    }

    public student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("Student ID 已被修改" );
    }
}
