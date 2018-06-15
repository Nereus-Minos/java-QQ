package QQLogIn;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.*;

import QQCommon.Message;
import QQCommon.MessageType;
import QQCommon.User;
import QQFriendsList.FriendsList;
import QQModel.QQFriendsListMap;
import QQModel.QQUser;
import QQModel.ServerHashMap;

public class LogIn extends JFrame implements ActionListener{
	//用边界布局,用个面板
	JPanel jp1 = null, jp2 = null, jp3 = null; 
	//上部和左部分别放一个图片,分别用按钮来承接
	JLabel image_jl1 = null, image_jl2 = null;
	ImageIcon image1 =null, image2 = null;
	//下部放一个按钮
	JButton jb1 = null;
	//右部放两个标签
	JLabel jl1 = null, jl2 = null;
	//中部放两个面板，一个面板放两个文本框，一个面板放两个选择框
	JPanel jp5 = null, jp4 =null;
	JTextField jt1 = null, jt2 = null;
	JCheckBox jc1 = null, jc2 = null;
	
	public static void main(String[] arg0) {
		LogIn login = new LogIn();
	}
	
	public LogIn() {
		
		//上部
		image_jl1 = new JLabel();  
		image_jl1 = new JLabel( new ImageIcon("Image/login/1.jpg"));
		this.add(image_jl1, "North");
		image_jl1.setPreferredSize(new Dimension(0, 184));
		//左部
		image_jl2 = new JLabel();  		
		image_jl2 = new JLabel( new ImageIcon("Image/login/2.gif"));
		image_jl2.setBackground(Color.white);
		this.add(image_jl2, "West");
		image_jl2.setPreferredSize(new Dimension(112, 0));
		
		//下部
		jp1 = new JPanel();
		jb1 = new JButton("安全登录");
		jb1.addActionListener(this);
		jb1.setActionCommand("安全登录");
		jb1.setBackground( new Color(5,150,200));
		jb1.setForeground(Color.white);
		jb1.setPreferredSize(new Dimension(290, 40));
		jp1.add(jb1);
		jp1.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));   //设置边缘预留
		this.add(jp1,"South");
		jp1.setPreferredSize(new Dimension(0, 50));
		
		//东部
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(3,1));
		jl1 = new JLabel("注册账号");
		jl1.setFont(new Font("宋体",Font.PLAIN,14));
		jl1.setForeground( new Color(5,170,230));
		jl2 = new JLabel("找回密码");
		jl2.setFont(new Font("宋体",Font.PLAIN,14));
		jl2.setForeground( new Color(5,170,230));
		jp2.add(jl1, "West");
		jp2.add(jl2, "West");
		jp2.setBorder(BorderFactory.createEmptyBorder(18,10,10,10));   //设置边缘预留
		jp2.setPreferredSize(new Dimension(112, 0));   //设置面板所在块的大小
		this.add(jp2, "East");
		
		//中部
		jp4 = new JPanel();
		jp5 = new JPanel();
		jt1 = new JTextField();
		jt2 = new JTextField();
		jc1 = new JCheckBox("记住密码");
		jc1.setFont(new Font("宋体",Font.PLAIN,15));		
		jc2 = new JCheckBox("自动登录");
		jc2.setFont(new Font("宋体",Font.PLAIN,15));
		jp4.setLayout(new GridLayout(1,2,115,0));
		jp4.add(jc1);
		jp4.add(jc2);
		jp5.setLayout(new GridLayout(3,1,0,0));
		jp5.add(jt1);
		jp5.add(jt2);
		jp5.add(jp4);
		jp5.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
		this.add(jp5);
		
		this.setSize(550, 420);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("安全登录")) {
			User user = new User();
			user.setName(jt1.getText().trim());
			user.setPassage(jt2.getText().trim());
			
			QQUser isUser = new QQUser();
			boolean flag = isUser.isQQUser(user);	
			if(true == flag) {	//登录成功
//不能在这儿加好友列表到HashMap中，因为晚了				
				
				//向服务器发送获取好友列表的请求
				try {
					
					ObjectOutputStream oos=new ObjectOutputStream(ServerHashMap.getClientThread(user.getName()).s.getOutputStream());
				
					Message ms = new Message();
					ms.setMessageType(MessageType.message_get_onlinefriends);
					
					ms.setUsername(user.getName());
					
					oos.writeObject(ms);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
			}
		}
	}
}
