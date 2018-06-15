package QQModel;

import java.net.*;

import QQCommon.*;
import QQFriendsList.FriendsList;

import java.io.*;

//连接服务器
public class QQCommunication {
	private boolean flag = false;
	public Socket s = null;
	
	public boolean sentLogInInformation(Object o) {
		
		try {
				s = new Socket("127.0.0.1", 9999);
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(o);
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message ms = (Message)ois.readObject();
				if(ms.getMessageType().equals(MessageType.message_succeed)) {
					flag = true;
					User user = (User)o;
						
					//将好友列表放到HashMap中
					
					FriendsList FriendsList = new FriendsList(user.getName());
					
					QQFriendsListMap.addFriendsList(user.getName(), FriendsList);
					
					//将该接收线程放到HashMap中
									
					QQCommunicationThread QQCommunicationThread = new QQCommunicationThread(s);
					ServerHashMap.addClientThread(user.getName(), QQCommunicationThread);				
					Thread t = new Thread(QQCommunicationThread);
					t.start();
					
				}else {
					
				}		
	
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

		}
		
		return flag;
	
	}
}
