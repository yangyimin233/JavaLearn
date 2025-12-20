package JSE;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 要使用 JDK 动态代理，首先需要创建一个实现 InvocationHandler 接口的类
// 这个是为了处理方法调用的逻辑
// 之后 在运行时 创建 代理对象的 函数时，会用到这个类
public class StudentInvocationHandler implements InvocationHandler {
    private Object target;

    // 构造函数，接受目标对象
    public StudentInvocationHandler(Object target) {
        this.target = target;
    }

    // 每次调用代理方法时，都会执行此方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在调用目标方法之前，做一些增强操作
        System.out.println("Before calling method: " + method.getName());

        // 执行目标对象的实际方法
        Object result = method.invoke(target, args);

        // 在调用目标方法之后，做一些增强操作
        System.out.println("After calling method: " + method.getName());

        // 返回目标方法的执行结果
        return result;
    }

}
