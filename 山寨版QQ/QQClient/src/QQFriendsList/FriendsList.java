package QQFriendsList;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class FriendsList extends JFrame{

	//整个JFrame分为上中下
	JPanel jp1 = null, jp2 = null, jp3 =null;

	//上部
	FriendsListNorthPanel NorthPanel = null;
	
	//中部
	FriendsListCenterPanel CenterPanel = null;
	
	//下部
	FriendsListSouthPanel SouthPanel = null;

	

	public FriendsList(String Name) {

		//上部
		jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		NorthPanel = new FriendsListNorthPanel(jp1);
		this.add(jp1, "North");		
		
		//中部
		jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		CenterPanel = new FriendsListCenterPanel(jp2, Name); 
		this.add(jp2, "Center");			
		
		//下部
		jp3 = new JPanel();
		SouthPanel = new FriendsListSouthPanel(jp3);		
		this.add(jp3,"South");
		
		this.setTitle(Name);
		this.setSize(380, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//更新好友列表
	public void updateFriendslist(String friends[]) {
		
		CenterPanel.updateFriendslist(friends);
	}

}
