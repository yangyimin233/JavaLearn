package JSE;

import java.lang.reflect.Field;

public class generics {

    // 这里我们来学习泛型相关的知识点



    public static void main(String[] args) {

        box<Integer> b = new box<>(); // 这里的<>表示类型参数，可以在创建对象时指定具体的类型
        b.setT(123); // 设置整数值
        System.out.println(b.getT()); // 获取并打印整数值

//        b.setT("AAAA"); // 这时候会报错，因为我们指定了Integer类型，对于这个b对象，他里面的T变量 已经是 Integer了 ，不能设置String类型


        Class<?> c = b.getClass(); // 获取b对象中T变量的实际类型
        System.out.println("T的实际类型是: " + c.getName()); // 打印T的实际类型




    }


}


// 一般来说，我们推荐java文件里面只写一个public类，这里为了演示泛型，就不遵守这个规则了
class box<T> {
    // T代表类型参数，可以用任何字母表示，一般用大写字母表示
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}