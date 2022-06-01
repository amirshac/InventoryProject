package inventory.TcpServer;

public class ServerRunner {
	
	public static void main(String[] args) {
		InventoryServer server = new InventoryServer();
		server.startServer();
	}
}
