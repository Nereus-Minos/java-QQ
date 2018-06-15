package QQModel;

import java.util.*;

public class ClientHashMap {

		public static HashMap hm = new HashMap<String, QQCommunicationThread>();	

		public static void addClientThread(String uid, QQCommunicationThread ct)
		//向hm中添加一个客户端通讯线程
		{
			hm.put(uid, ct);
		}
		
		public static QQCommunicationThread getClientThread(String uid)
		{
			return (QQCommunicationThread)hm.get(uid);
		}
		
		//写一个函数，将好友列表放到一个String中
		public static String getFriendslist() {
			//使用迭代器
			Iterator it = hm.keySet().iterator();
			String ret = "";
			while(it.hasNext()) {
				
				ret += it.next().toString() + " ";
				
			}
			
			return ret;
		}
		
		
}
