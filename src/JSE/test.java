package JSE;

public class test {

    public static void main(String[] args) {


        student s1 = new student(1);
        student s2 = s1;

        s1.setId(33);

        System.out.println(s2.getId());  // 这里说明了，你可以把每个对象的引用传递给另一个对象，这样就可以通过一个对象来修改另一个对象的属性，类似于指针
        // 每个student对象可以理解为一个指针，指向一个内存地址
        // 这里的s1和s2指向同一个对象，所以修改s1的id会影响s2的id

        // 但是如果你重新给s2赋值一个新的对象，那么s2就不再指向s1了
        s2 = new student(2);  // 这里s2指向了一个新的对象，不再指向s1

        String str = new String("hello");
        // 修改字符串某个位置上的字符是不允许的，因为字符串是不可变的


        // 字符串的修改往往是new一个新的，然后根据原有字符串的信息拼接出来
        String restr = "";
        for (int i = 0; i < str.length(); i++) {
            restr = restr + str.charAt(i) + str.charAt(i);
        }


        // 再试试呢


    }


}
