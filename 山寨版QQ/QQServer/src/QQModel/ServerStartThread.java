package QQModel;

public class ServerStartThread implements Runnable{

	QQCommunication communication = null;
	
	public ServerStartThread() {

		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

				communication = new QQCommunication();

	}
}
