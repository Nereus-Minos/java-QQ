
/*功能：是服务器和某个客户端的通信线程(一直读取客户端发送过来的内容)*/

package QQModel;

import java.net.*;
import java.util.Iterator;

import QQCommon.Message;
import QQCommon.MessageType;

import java.io.*;

public class QQCommunicationThread extends Thread{

	Socket s;
	
	public QQCommunicationThread(Socket s) {
		this.s = s;
	}
	
	public void run() {
		
		while(true) {
			
			try {
					
					ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
					
					Message ms = (Message)ois.readObject();				
					
					if(ms.getMessageType().equals(MessageType.message_ordinary_message)) {  //如果发送过来的是普通信息则直接转发
						
								//转发
						QQCommunicationThread fiendQQCommunicationThread = ClientHashMap.getClientThread(ms.getFriendname());
						
						ObjectOutputStream oos=new ObjectOutputStream(fiendQQCommunicationThread.s.getOutputStream());
						
						oos.writeObject(ms);
						
					}else if(ms.getMessageType().equals(MessageType.message_get_onlinefriends)) {  //如果发过来的是好友列表的请求，则....
						
						Message ms2 = new Message();   //这是发给客户端的好友列表
						
						ms2.setUsername(ms.getUsername());
						
						ms2.setMessageType(MessageType.message_return_onlinefriends);
						
						ms2.setFriendslist(ClientHashMap.getFriendslist());
						
						ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
						
						oos.writeObject(ms2);
					}			
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
