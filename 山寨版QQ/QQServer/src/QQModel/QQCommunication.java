package QQModel;

import java.net.*;
import java.util.Iterator;

import QQCommon.*;

import java.io.*;

public class QQCommunication {

	ServerSocket ss = null;
	Socket s = null;
	
	public QQCommunication() {

		try {			
			ss = new ServerSocket(9999);
			
			
			while(true) {

			s = ss.accept();

			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());			
			User user = (User)ois.readObject();
			Message ms = new Message();
			if(user.getPassage().equals("123456")) {
				ms.setMessageType(MessageType.message_succeed);
				oos.writeObject(ms);			
				
				//将该接收线程放到HashMap中
				QQCommunicationThread QQCommunicationThread = new QQCommunicationThread(s);
				
				ClientHashMap.addClientThread(user.getName(), QQCommunicationThread);
					
				Thread t = new Thread(QQCommunicationThread);
				t.start();	
				
				
				//给其他在线好友发出更新好友列表	
				String onlinefirend ;
				
				Message ms2 = new Message();   //这是发给客户端的好友列表

				ms2.setMessageType(MessageType.message_return_onlinefriends);
				
				ms2.setFriendslist(ClientHashMap.getFriendslist());			
				
				ObjectOutputStream oos2= null;
				
				//使用迭代器
				Iterator it = ClientHashMap.hm.keySet().iterator();

				while(it.hasNext()) {					
					try {
						onlinefirend = it.next().toString();
						
						oos2=new ObjectOutputStream(ClientHashMap.getClientThread(onlinefirend).s.getOutputStream());
						
						ms2.setUsername(onlinefirend);
						
						oos2.writeObject(ms2);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}else {
				ms.setMessageType(MessageType.message_fail);
				oos.writeObject(ms);
				s.close();
			}	
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null != ss) {
					ss.close();	
				}
				if(null != s) {
					s.close();	
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	
	}

}
