package packets;
import game.Client;
import game.GameServer;





public class Packet03AddEntity extends Packet {

    private int id;
    private int x, y;
    private String type;
    private String otherData;
    


    public Packet03AddEntity(byte[] data) {
        super(03);
        String[] dataArray = readData(data).split(",");
        this.id = Integer.parseInt(dataArray[0]);
        this.type = dataArray[1];
        this.x = Integer.parseInt(dataArray[2]);
        this.y = Integer.parseInt(dataArray[3]);
        try{
        	this.otherData = dataArray[4];
        }catch(ArrayIndexOutOfBoundsException e){
          	this.otherData = "";
        }
        System.out.println(this.type+" : "+this.otherData);
 
 
    }

    public Packet03AddEntity(int id, String type,int x, int y,String otherData) {
        super(03);
        this.id = id;
        this.x = x;
        this.y = y;
        this.type = type;
        this.otherData = otherData;
       
    }


    @Override
    public void writeData(GameServer server) {
        server.sendDataToAllClients(getData());
    }
    public void writeDataToOneClient(GameServer server, Client player) {
        server.sendDataToClient(getData(),player);
    }

    @Override
    public byte[] getData() {
        return ("03" + this.id + "," + this.type + "," + this.x + "," + this.y + "," + this.otherData).getBytes();

    }

    public int getId() {
        return this.id;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

	public String getType() {
		
		return this.type;
	}

	public String getOtherData() {
		return this.otherData;
	}

}
