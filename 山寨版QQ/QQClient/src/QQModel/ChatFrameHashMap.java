package QQModel;

import java.util.HashMap;

import QQChat.ChatFrame;

public class ChatFrameHashMap {

	public static HashMap hmChat = new HashMap<String, ChatFrame>();	

	public static void addChatFrame(String id, ChatFrame ct)  //传进来的id为user和friendid的组合
	//向hm中添加一个客户端通讯线程
	{
		hmChat.put(id, ct);
	}
	public static ChatFrame getChatFrame(String id)
	{
		return (ChatFrame)hmChat.get(id);
	}
}
