package oy.interact.tira.grade_1.task_1;

public class SimpleColor implements Comparable<SimpleColor> {

    public enum Colors {
        // NB: Colors declared in temperature order!
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        PURPLE;

        @Override
        public String toString() {
            switch (this) {
                case RED:
                    return "Red";
                case ORANGE:
                    return "Orange";
                case YELLOW:
                    return "Yellow";
                case GREEN:
                    return "Green";
                case BLUE:
                    return "Blue";
                case PURPLE:
                    return "Purple";
                default:
                    return "Undefined";
            }
        }
    }

    private Colors color = Colors.RED;

    public SimpleColor(Colors color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color.toString();
    }

    @Override
    public int compareTo(SimpleColor o) {
        // Color order comes from declaration order in enum, this is standard in Java.
        return this.color.compareTo(o.color);
    }
}
