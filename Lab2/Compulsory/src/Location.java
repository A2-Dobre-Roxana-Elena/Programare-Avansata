public class Location {
    private String name;
    private double X,Y;

    private LocationType type;
    public Location() { }
    public Location(String name) {
        this.name = name;
    }

    public Location(String name, double x, double y) {
        this.name=name;
        this.X=x;
        this.Y=y;
    }

    public Location(String name, double x, double y, LocationType type)
    {
        this.name=name;
        this.X=x;
        this.Y=y;
        this.type=type;
    }


    public String getName() {
        return name;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public LocationType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", X=" + X +
                ", Y=" + Y +
                ", type=" + type +
                '}';
    }
}