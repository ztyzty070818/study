package myenum;

public enum Color {
    RED("红色",1),
    GREEN("绿色",2),
    YELLO("黄色",3);

    private String name;
    private int index;

    Color(String s, int i) {
        this.name = s;
        this.index = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
