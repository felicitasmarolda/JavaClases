package campoLindero;

import java.util.ArrayList;

public class Guest extends Car{
    public int peopleInCar;

    public Guest(int peopleInCar){
        this.peopleInCar = peopleInCar;
    }

    public int peopleInCar() {
        return peopleInCar;
    }

    public Integer price() {
        return 150;
    }
}
