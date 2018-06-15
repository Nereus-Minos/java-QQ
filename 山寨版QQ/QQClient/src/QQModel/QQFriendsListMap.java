package QQModel;

import java.util.HashMap;

import QQFriendsList.FriendsList;

public class QQFriendsListMap {

	public static HashMap hmQQFriendsList = new HashMap<String, FriendsList>();	

	public static void addFriendsList(String id, FriendsList ct)  //传进来的id为user和friendid的组合
	//向hm中添加一个客户端通讯线程
	{
		hmQQFriendsList.put(id, ct);
	}
	public static FriendsList getFriendsList(String id)
	{
		return (FriendsList)hmQQFriendsList.get(id);
	}

	
}
