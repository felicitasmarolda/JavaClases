package garageEventos1.campoLindero;

public abstract class ParkedCar {
    protected Car car;

    public ParkedCar( Car car ) {
        this.car = car;
    }

    public abstract int fee();

    public int peopleInCar() {
        return car.peopleInCar();
    }

    public boolean holds( Car earlyCar ) {
        return car == earlyCar;
    }
}