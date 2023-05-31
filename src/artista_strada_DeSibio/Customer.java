package artista_strada_DeSibio;

public class Customer extends Thread 
{
    private int customerId;
    private int waitingTime;

    public Customer(int customerId, int waitingTime) 
    {
        this.customerId = customerId;
        this.waitingTime = waitingTime;
    }

    @Override
    public void run() 
    {
        System.out.println("Il cliente " + customerId + " arriva.");

        if (Simulation.getAvailableSeats().tryAcquire()) 
        {
            // Cliente ha ottenuto una sedia
            System.out.println("Il cliente " + customerId + " si siede.");

            try {
                Thread.sleep(waitingTime); //tempo di attesa del cliente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Il cliente " + customerId + " si alza dopo " + waitingTime + " ms.");

            Simulation.getAvailableSeats().release();
        } else 
        {
            System.out.println("Cliente " + customerId + " rinuncia a farsi fare il ritratto.");
        }
    }
}
