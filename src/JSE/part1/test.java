package JSE.part1;

public class test {
}


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