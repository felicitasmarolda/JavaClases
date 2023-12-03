public abstract class Car {
    private final int peopleInCar;

    public Car(int peopleInCar) {
        this.peopleInCar = peopleInCar;
    }
    public abstract int getMoneyToBeEarned();
    public int getPeopleInCar() {
        return peopleInCar;
    }
}
