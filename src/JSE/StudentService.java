package JSE;

// 定义一个学生服务接口
// 这里是想试一下 jdk动态代理学生对象
// 所以说 我们要先创建一个接口，然后让原本 的 学生类 实现这个接口
public interface StudentService {
    int getId();  // 获取学生学号
    void setId(int id);  // 设置学生学号
}
