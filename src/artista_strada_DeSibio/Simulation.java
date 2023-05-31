package artista_strada_DeSibio;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Simulation 
{
    private static final int seats = 4; 				//sedie disponibili
    private static final int maxWaitTime = 10000; 		//tempo massimo di attesa di un cliente in millisecondi

    private static Semaphore availableSeats; 			//semaforo per tenere traccia delle sedie disponibili

    public static void main(String[] args) {
        setAvailableSeats(new Semaphore(seats));

        Artist artist = new Artist();
        artist.start();

        Random random = new Random();

        //genera nuovi clienti ad intervalli casuali
        for (int i = 1; i <= 20; i++) 
        {
            Customer customer = new Customer(i, random.nextInt(maxWaitTime));
            customer.start();
            
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

	public static Semaphore getAvailableSeats() {
		return availableSeats;
	}

	public static void setAvailableSeats(Semaphore availableSeats) {
		Simulation.availableSeats = availableSeats;
	}
}


