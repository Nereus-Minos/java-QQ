
/*功能：是服务器和客户端的通信线程(一直读服务器发送过来的内容)*/

package QQModel;

import java.net.*;

import QQChat.ChatFrame;
import QQCommon.Message;
import QQCommon.MessageType;

import java.io.*;

public class QQCommunicationThread extends Thread{

	public Socket s;
	
	public QQCommunicationThread(Socket s) {
		this.s = s;
	}
	
	public void run() {
		
		while(true) {
			
			try {
					
				//接收
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				
				Message ms = (Message)ois.readObject();				//接收过来的user和friend使反的
				
				if(ms.getMessageType().equals(MessageType.message_ordinary_message)) {
					
								//显示
					ChatFrame chat = ChatFrameHashMap.getChatFrame(ms.getFriendname()+ms.getUsername());
					
					chat.showMessage(ms);
					
				}else if(ms.getMessageType().equals(MessageType.message_return_onlinefriends)) {
					
					String friendslist = ms.getFriendslist();
					String friends[] = friendslist.split(" ");

					
					//在此更新好友在线列表
					QQFriendsListMap.getFriendsList(ms.getUsername()).updateFriendslist(friends);
					
				}	
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
