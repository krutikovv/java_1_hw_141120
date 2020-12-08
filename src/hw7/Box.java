package hw7;

public class Box {
    private String color;
    private int size;

    public Box(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Box box = (Box) o;

        if (size != box.size) return false;
        return color != null ? color.equalsIgnoreCase(box.color) : box.color == null;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.toLowerCase().hashCode() : 0;
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return "Box{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
