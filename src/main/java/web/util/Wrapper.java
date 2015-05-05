package web.util;

public class Wrapper {

    private Iterable<?> content = null;

    public Wrapper(Iterable<?> content) {
        this.content = content;
    }

    public Iterable<?> getContent() {
        return content;
    }
}
