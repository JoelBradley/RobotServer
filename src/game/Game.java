package game;
public class Game  implements Runnable {


	public static int MAX_PLAYERS;
	
    private Thread thread;
    public GameServer socketServer;

    public synchronized void start() {
    	socketServer = new GameServer(MAX_PLAYERS);
        socketServer.start();
        System.out.println("Ready");
           
    }

    public synchronized void stop() {
       
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
       

        
    }

  

  public static void main(String[] args){
	  if(args.length<1){
		  System.out.println("Run with PLAYERS argument");
		  System.exit(1);
	  }
	  try { 
		  MAX_PLAYERS = Integer.parseInt(args[0]);
	   } catch(NumberFormatException e) { 
		   System.out.println("Players argument is not integer!");
		   System.exit(1);
	   }
	 
	  new Game().start();
  }

   
}
