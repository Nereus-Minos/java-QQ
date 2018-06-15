package QQCommon;

public interface MessageType {
	
	String message_succeed = "1";  //表明登录成功
	String message_fail = "2";     //表明登录失败
	String message_ordinary_message = "3";  //表明为普通信息包
	String message_get_onlinefriends = "4";  //请求好友在线列表
	String message_return_onlinefriends = "5"; //返回好友在线列表
	String message_get_updateonlinefriends = "6";  //请求更新好友在线列表
	String message_return_updateonlinefriends = "7"; //返回更新好友在线列表
	
}
