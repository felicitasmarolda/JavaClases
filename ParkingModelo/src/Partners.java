public class Partners extends Car{

    public Partners(int peopleInCar) {
        super(peopleInCar);
    }

    @Override
    public int getMoneyToBeEarned() {
        return 100;
    }
}
