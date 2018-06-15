package QQModel;

import java.util.*;

public class ServerHashMap {

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
}
