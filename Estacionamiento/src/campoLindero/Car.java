package garageEventos1.campoLindero;

import java.util.ArrayList;

public abstract class Car {
    protected Car car;

    public abstract int peopleInCar();
    public abstract Integer price();

    public boolean holds( Car earlyCar ) {
        return car == earlyCar;
    }
}