package planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;

public class ExperimentalPlane extends Plane {

    private ClassificationLevel classificationLevel;
    private ExperimentalTypes experimentalTypes;


    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes experimentalTypes, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.classificationLevel = classificationLevel;
        this.experimentalTypes = experimentalTypes;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }


    @Override
    public boolean equals(Object plane) {
        return super.equals(plane);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }
}
