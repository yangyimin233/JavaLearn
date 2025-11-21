package JSE;

public class testStrBuilder {


    // 这里来学习一下这个strbuilder
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        String str = "aaaaa";

        builder.append(str);
        System.out.println(builder.length());

        changestr(str);
        // 不会修改str本身，传进去的是一个副本
        System.out.println(str);

        // bulider是会改变的
        changestrBuilder(builder);
        System.out.println(builder.toString());




    }


    public static void changestr(String str) {
        str += str;
    }

    public static void changestrBuilder(StringBuilder builder) {
        builder.append(builder.toString());
    }




}
