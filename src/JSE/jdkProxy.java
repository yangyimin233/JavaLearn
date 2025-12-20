package JSE;

import java.lang.reflect.Proxy;

import static java.lang.reflect.Proxy.newProxyInstance;

public class jdkProxy {

    // 这里来学一下这个 jdk的动态代理技术
    // 首先：什么是动态代理？

    // 在 运行时 创建一个 代理对象，这个对象可以像目标对象一样调用方法，但它会先执行一些 额外的操作，比如 日志、权限验证、事务管理 等等
    // 且这个代理对象 并不需要在编译时提前创建，它是在程序运行时动态生成的。


    // 对比常见容易理解的静态代理
    // 比如我们要代理一个目标对象，比如要他的某个方法 method()
    // 定义一个接口 , 然后让目标对象实现这个接口,也就是接口里面声明 method() 方法
    // 然后定义一个 代理类 也实现这个接口( 实际上这里我觉得不实现也行)
    // 重点： 代理类 持有 目标对象 的引用
    // 换句话说 代理类里面 有一个 成员变量 指向 目标对象(接口)

    // 代理对象 里面的 method() 方法
    // 实际上写的 是 调用 目标对象 的 method() 方法
    // 但是可以前后包装

    // 这个就是静态代理，其代理类 是在 编译时 就已经写好了
    // jdk动态代理 则是运行时动态生成 代理类 的字节码

    // 1. 比如我们要代理student类的学生对象的一些方法，首先需要 定义一个接口 StudentService（这个接口中要声明我们想要代理的方法） ，让 student类 实现 这个接口，因为 jdk动态代理 只能 代理 实现了接口的类
    // 并且最后你这个代理对象所调用的方法一定是，这个目标对象实现的 接口 中声明的这个方法


    // 2. 然后 创建一个 实现 InvocationHandler接口的类 StudentInvocationHandler，这个类 负责处理 方法调用的逻辑， 这个实现类写法相对比较固定
    //   这个类 里面有一个成员变量 指向 目标对象 一般都是 Object target
    //   然后 就是构造方法，传入 目标对象
    //   最后 重写 invoke() 方法，这个方法会在每次调用 代理对象 的方法时 被执行
    //   你就可以在这里 环绕包装 原本目标对象的方法

    // 3. 然后我们就可以在其他地方 使用 Proxy.newProxyInstance() 方法来创建 代理对象
    // 这个函数需要三个参数
    // 第一个 是 类加载器，通常使用 目标对象的类加载器，一般固定
    // 第二个 是 目标对象实现的接口数组，一般也是固定
    // 第三个 是 上面创建的 处理器对象
    // 不过你也要先实例化 这个处理器对象，传入 目标对象



    public static void main(String[] args) {

        // 上面的1，2 步骤已经做了

        // 3. 创建 代理对象
//        student student = new student(1001); // 创建一个学生对象

        StudentService student = new student(1001); // 创建一个学生对象，注意gpt说必须用接口类型接收
        // 但实际上，我发现 用 实现类类型接收 也是可以的

        StudentInvocationHandler handler = new StudentInvocationHandler(student); // 创建一个处理器，传入目标对象

        // 使用 Proxy 类的 newProxyInstance 方法创建代理对象
        StudentService proxyInstance = (StudentService) Proxy.newProxyInstance(
            student.getClass().getClassLoader(), // 使用目标对象的类加载器
            student.getClass().getInterfaces(), // 目标对象实现的接口，这里目标对象可能实现了 多个接口，所以用这个方法比较通用

                // 当然你也可以直接写死接口数组
//                new Class<?>[] { StudentService.class },

            handler // 处理器
        );

        // 通过代理对象调用方法
        System.out.println("Student ID: " + proxyInstance.getId());
        proxyInstance.setId(2002);
        System.out.println("Updated Student ID: " + proxyInstance.getId());


    }



    // 最后总结一下：

    // 使用jdk实现动态代理

    // 1. 针对你想代理的目标对象 中的方法，把这些方法声明到一个接口里面，让目标类实现 这个接口
    // 2. 创建 处理器类，实现 InvocationHandler接口，着重重写 invoke() 方法，在这个方法中编写 代理逻辑

    // 3. 然后在你想要代理的地方开始生成代理对象
    // 创建/或者拿一个目标对象
    // 然后 用处理器类的构造函数 创建一个 处理器对象，传入 目标对象
    // 通过 Proxy.newProxyInstance() 方法 创建 代理对象
    // 入口参数 ：类加载器，接口数组，处理器对象




}
