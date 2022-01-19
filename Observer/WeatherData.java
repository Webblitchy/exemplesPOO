package Observer;

import Observer.Interface.Observer;
import Observer.Interface.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    float temperature;
    float humidity;
    float pressure;
    private ArrayList<Observer> observers;
    WeatherData(){
        observers = new ArrayList<>();
        temperature = 0;
        humidity = 0;
        pressure = 0;

    }

    public void measurementsChanged(){
       notifyObservers();
    }
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        //très important lorsque les données changent on appelle la méthode notifyObservers
        //a travers measurementsChanged
        measurementsChanged();
    }
    private float getTemperature(){
        return temperature;
    }
    private float getHumidity(){
        return humidity;
    }
    private float getPressure(){
        return pressure;
    }

    @Override
    public void registerObserver(Observer o) {
        //la liste des personnes à signaler
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        //on peut enlever une personne qui ne souhaite plus recevoir de notification
        int i = observers.indexOf(o);
        if(i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        //on envoie les données aux personnes qui sont enregistrées
        for(int i = 0; i <  observers.size(); ++ i){
            observers.get(i).update(getTemperature(), getHumidity(), getPressure());
        }
    }
}
