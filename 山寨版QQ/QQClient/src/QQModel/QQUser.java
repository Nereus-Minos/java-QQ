package QQModel;

//验证是否为User，返回true或false
public class QQUser {
	
	//写一个验证函数
	public boolean isQQUser(Object o) {

		return new QQCommunication().sentLogInInformation(o) ;
	}
}
