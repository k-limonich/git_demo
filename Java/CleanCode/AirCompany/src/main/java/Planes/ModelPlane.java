package Planes;

import java.util.Objects;

public class ModelPlane extends Plane {
    private String material;

    public ModelPlane(String model, int maxSpeed, int maxFlightDistance,
                      int maxLoadCapacity, String material) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.material = material;
    }

    public String getMaterial() { return material; }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", material=" + material +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ModelPlane modelPlane = (ModelPlane) o;
        return Objects.equals(material, modelPlane.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), material);
    }
}
