package artista_strada_DeSibio;

public class Artist extends Thread {
    @Override
    public void run() 
    {
        while (true) 
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
