public class Road {
    private String name;
    private RoadType type;

    public Road() { }
    public Road(String name, RoadType type, Location a, Location b) {
        this.name = name;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public RoadType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Room)) {
            return false;
        }
        Road other = (Road) obj;
        return name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
