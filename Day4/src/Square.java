public class Square {
    private String value;
    private boolean marked;

    public Square(String value) {
        this.value = value;
        this.marked = false;
    }

    public void setMarked() {
        this.marked = true;
    }

    public boolean isMarked() {
        return this.marked;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "{" + value + ":" + marked + '}';
    }
}
