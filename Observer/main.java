package Observer;

public class main {
    public static void main(String[] args) {
        WeatherData dataStation = new WeatherData();
        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(dataStation);
        //On change les valeurs de la station, et tous les abonnés sont notifiés
        //Ainsi on peut avec une interface "simple" avoir des valeurs syncronisées entre
        //les différentes classes (affichage et stockage des données)
        dataStation.setMeasurements(80, 65, 30.4f);
        dataStation.setMeasurements(82, 70, 29.2f);
        dataStation.setMeasurements(78, 90, 29.2f);

        //Pour résumer :
        //1) interface pour S'abonner à un objet
        //2) Interface pour se faire update/notifier
        //
        //Déroulement :
        // - on cré l'objet qui détient les données
        // - On crée l'objet qui va se faire notifier, il s'abonne grâce à l'interface
        //       subject
        // lorsque le sujet change, il indique aux observateurs qu'ils doivent se
        // mettre à jour (il leur donne les nouvelles valeurs lors de la notification)
    }

}
