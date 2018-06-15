package QQChat;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.*;

import QQCommon.*;
import QQModel.*;

public class ChatFrame extends JFrame implements ActionListener, MouseListener{
	
	private String username = null, friendname = null;
	
	//采用三个JPanel
	JPanel jp1 = null, jp2 = null, jp3 = null;
	//jp1放7个JLabel
	JLabel jp1_jl1 = null, jp1_jl2 = null, jp1_jl3 = null, jp1_jl4 = null, jp1_jl5 = null, jp1_jl6 = null, jp1_jl7 = null;
	//jp2放一个滚动条，滚动条里面放一个文本域
	JScrollPane jp2_js = null;
	JTextArea jp2_jt = null;
	//jp3放三个JPanel
	JPanel jp3_jp1 = null, jp3_jp2 = null, jp3_jp3 = null;
		//jp3_jp1放8个JLabel
	JLabel jp3_jp1_jl1 = null, jp3_jp1_jl2 = null, jp3_jp1_jl3 = null, jp3_jp1_jl4 = null, jp3_jp1_jl5 = null, jp3_jp1_jl6 = null, jp3_jp1_jl7 = null, jp3_jp1_jl8 = null;
		//jp3_jp2放一个滚动条，滚动条里面放一个文本域
	JScrollPane jp3_jp2_js = null;
	JTextArea jp3_jp2_jt = null;
		//jp3_jp3放两个按钮
	JButton jp3_jp3_jb1 = null, jp3_jp3_jb2 = null;
	
	
	public ChatFrame(String name, String friendname) {
		
		this.setUsername(name);
		this.setFriendname(friendname);
		
		//整个JFrame才有边界布局
		
		//jp1采用流布局
		jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1_jl1 = new JLabel("11");
		jp1_jl2 = new JLabel("12");
		jp1_jl3 = new JLabel("13");
		jp1_jl4 = new JLabel("14");
		jp1_jl5 = new JLabel("15");
		jp1_jl6 = new JLabel("16");
		jp1_jl7 = new JLabel("17");
		jp1.add(jp1_jl1);
		jp1.add(jp1_jl2);
		jp1.add(jp1_jl3);
		jp1.add(jp1_jl4);
		jp1.add(jp1_jl5);
		jp1.add(jp1_jl6);
		jp1.add(jp1_jl7);
		this.add(jp1,"North");
		
		//jp2
		jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		jp2_jt = new JTextArea();
		jp2_jt.setBackground(null);
		jp2_js = new JScrollPane(jp2_jt);
		jp2.add(jp2_js);
		this.add(jp2,"Center");
		
		//jp3才有边界布局
		jp3 = new JPanel();
		jp3.setLayout(new BorderLayout());
		jp3.setPreferredSize(new Dimension(0,150));
		jp3_jp1 = new JPanel();
		jp3_jp2 = new JPanel();
		jp3_jp3 = new JPanel();
			//jp3_jp1采用流布局
		jp3_jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp3_jp1_jl1 = new JLabel("21");
		jp3_jp1_jl2 = new JLabel("22");
		jp3_jp1_jl3 = new JLabel("23");
		jp3_jp1_jl4 = new JLabel("24");
		jp3_jp1_jl5 = new JLabel("25");
		jp3_jp1_jl6 = new JLabel("26");
		jp3_jp1_jl7 = new JLabel("27");
		jp3_jp1_jl8 = new JLabel("28");
		jp3_jp1.add(jp3_jp1_jl1);
		jp3_jp1.add(jp3_jp1_jl2);
		jp3_jp1.add(jp3_jp1_jl3);
		jp3_jp1.add(jp3_jp1_jl4);
		jp3_jp1.add(jp3_jp1_jl5);
		jp3_jp1.add(jp3_jp1_jl6);
		jp3_jp1.add(jp3_jp1_jl7);
		jp3.add(jp3_jp1,"North");
			//jp3_jp2
		jp3_jp2.setLayout(new BorderLayout());
		jp3_jp2_jt = new JTextArea();
		
		jp3_jp2_jt.addMouseListener(this);
		
		jp3_jp2_jt.setBackground(null);
		jp3_jp2_js = new JScrollPane(jp3_jp2_jt);
		jp3_jp2.add(jp3_jp2_js);
		jp3.add(jp3_jp2,"Center");
			//jp3_jp3采用流布局
		jp3_jp3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp3_jp3_jb1 = new JButton("关闭");
		jp3_jp3_jb2 = new JButton("发送");
		jp3_jp3_jb2.addActionListener(this);
		jp3_jp3_jb2.setActionCommand("发送");
		jp3_jp3.add(jp3_jp3_jb1);
		jp3_jp3.add(jp3_jp3_jb2);
		jp3.add(jp3_jp3, "South");
		
		this.add(jp3, "South");
		
		this.setTitle( name + "与" + friendname );
		this.setSize(500, 500);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("发送")) {
			
			Message ms = new Message();
			ms.setUsername(this.getUsername());
			ms.setFriendname(this.getFriendname());
			ms.setMessage(jp3_jp2_jt.getText());
			ms.setTime(new Date());
			ms.setMessageType(MessageType.message_ordinary_message);
			
			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(ServerHashMap.getClientThread(this.getUsername()).s.getOutputStream());
				oos.writeObject(ms);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	}

	public void showMessage(Object o) {
		Message ms = (Message)o;
		this.jp2_jt.append(ms.getTime()+"    "+ms.getFriendname()+" : \n"+ms.getMessage()+"\r\n");
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFriendname() {
		return friendname;
	}


	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jp3_jp2_jt)
		{
			jp3_jp2_jt.setBackground(Color.WHITE);
		}
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
