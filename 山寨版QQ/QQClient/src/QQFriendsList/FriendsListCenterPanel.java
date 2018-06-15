package QQFriendsList;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

import QQChat.ChatFrame;
import QQModel.ChatFrameHashMap;

public class FriendsListCenterPanel implements MouseListener{
	
	JLabel []firends = null;
	
	JLabel []blacklist = null;
	
	//用于提示谁和谁聊天
	String name = null;
	
	CardLayout cl;
//	//中部，先放一个选项卡窗口,有四个JPanel
	JTabbedPane center_jtp = null;
	JPanel center_jp1 = null, center_jp2 = null, center_jp3 = null, center_jp4 =null;
		//	center_jp1为好友列表，用CardLayout，用四个JPanel放friends和黑名单和两个列表收起来的JPanel
	JPanel center_friends_jp = null, center_blacklist_jp = null, center_fold_jp = null;
			//center_friends_jp中放三个JPanel
	JPanel center_friends_center_jp = null, center_friends_north_jp = null, center_friends_south_jp = null;
				//center_friends_north_jp和center_friends_south_jp各方一个JLabel
	JLabel center_friends_north_jl = null, center_friends_south_jl = null;
				//center_friends_center_jp放n个JLabel,以后要在数据库中获得
	JScrollPane center_friends_js = null;
	JButton center_friends_jb = null;
	Vector<JLabel> center_friends_jls = null;
		
			//center_blacklist_jp中放三个JPanel
	JPanel center_blacklist_center_jp = null, center_blacklist_north_jp = null, center_blacklist_south_jp = null;
				//center_blacklist_north_jp和center_blacklist_center_jp各方一个JLabel
	JLabel center_blacklist_north_jl = null, center_blacklist_center_jl = null;
				//center_blacklist_center_jp放n个JLabel,以后要在数据库中获得
	JScrollPane center_blacklist_js = null;
	JButton center_blacklist_jb = null;
	Vector<JLabel> center_blacklist_jls = null;
	
			//center_fold_jp放两个JLabel
	JLabel center_fold_jp_jl1 = null, center_fold_jp_jl2 = null;
	
	public FriendsListCenterPanel(JPanel jp2, String Name) {
		
		this.name = Name;
		
		center_jtp = new JTabbedPane();
		center_jp1 = new JPanel();
		center_jp2 = new JPanel();
		center_jp3 = new JPanel();
		center_jp4 = new JPanel();
		
		
		//好友列
		center_friends_jp = new JPanel();
		center_friends_jp.setLayout(new BorderLayout());
		
		center_friends_center_jp = new JPanel(new GridLayout(10,1,4,0));
		center_friends_north_jp = new JPanel();
		center_friends_north_jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		center_friends_south_jp = new JPanel();
		center_friends_south_jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		//center_friends_north_jp和center_friends_south_jp各方一个JLabel
		center_friends_north_jl = new JLabel("friends",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		center_friends_south_jl = new JLabel("blacklist",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		
		
		
		/*center_friends_center_jp*/
		firends=new JLabel[10];
		
		for(int i = 0; i <firends.length; i++) {	
			firends[i] = new JLabel(i+1+"",new ImageIcon("Image/friendslist/touxiang.jpg"),JLabel.LEFT);
			firends[i].setPreferredSize(new Dimension(360,71));
			firends[i].setOpaque(true);
			
			firends[i].setEnabled(false);
			
			//监听鼠标
			firends[i].addMouseListener(this);
			center_friends_center_jp.add(firends[i]);
		}
		
		center_friends_js = new JScrollPane(center_friends_center_jp);
		center_friends_js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		center_friends_js.setPreferredSize(new Dimension(360,360));  //必须得加不然滚动条大小就是面板的大小，于是没有滚动效果
		
		center_friends_jp.add(center_friends_js,"Center");
		/*center_friends_center_jp*/
		
		
		
		/*center_friends_north_jp*/
		center_friends_north_jl.addMouseListener(this);
		center_friends_north_jl.setPreferredSize(new Dimension(350,25));
		center_friends_north_jl.setOpaque(true);
		center_friends_north_jp.add(center_friends_north_jl);
		center_friends_north_jp.setPreferredSize(new Dimension(0, 30));
		center_friends_jp.add(center_friends_north_jp,"North");
		/*center_friends_north_jp*/
		
		/*center_friends_south_jp*/	
		center_friends_south_jl.addMouseListener(this);
		center_friends_south_jl.setPreferredSize(new Dimension(350,25));
		center_friends_south_jl.setOpaque(true);
		center_friends_south_jp.add(center_friends_south_jl);
		center_friends_south_jp.setPreferredSize(new Dimension(0, 25));
		center_friends_jp.add(center_friends_south_jp,"South");
		/*center_friends_south_jp*/
		
		
		//黑名单列
		center_blacklist_jp = new JPanel();
		center_blacklist_jp.setLayout(new BorderLayout());
		
		center_blacklist_south_jp = new JPanel(new GridLayout(10,1,4,0));
		center_blacklist_north_jp = new JPanel();
		center_blacklist_north_jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		center_blacklist_center_jp = new JPanel();
		center_blacklist_center_jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		//center_friends_north_jp和center_friends_center_jp各方一个JLabel
		center_blacklist_north_jl = new JLabel("friends",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		center_blacklist_center_jl = new JLabel("blacklist",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		
		/*center_friends_center_jp*/
		blacklist=new JLabel[10];
		for(int i = 0; i <blacklist.length; i++) {	
			blacklist[i] = new JLabel(i+1+"",new ImageIcon("Image/friendslist/blacklist.jpg"),JLabel.LEFT);
			blacklist[i].setPreferredSize(new Dimension(360,71));
			blacklist[i].setOpaque(true);
			//监听鼠标
			blacklist[i].addMouseListener(this);
			center_blacklist_south_jp.add(blacklist[i]);
		}
		center_blacklist_js = new JScrollPane(center_blacklist_south_jp);
		center_blacklist_js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		center_blacklist_js.setPreferredSize(new Dimension(360,360));  //必须得加不然滚动条大小就是面板的大小，于是没有滚动效果
		
		center_blacklist_jp.add(center_blacklist_js,"South");
		/*center_friends_center_jp*/
		
		/*center_friends_north_jp*/
		center_blacklist_north_jl.addMouseListener(this);
		center_blacklist_north_jl.setPreferredSize(new Dimension(350,25));
		center_blacklist_north_jl.setOpaque(true);
		center_blacklist_north_jp.add(center_blacklist_north_jl);
		center_blacklist_north_jp.setPreferredSize(new Dimension(0, 30));
		center_blacklist_jp.add(center_blacklist_north_jp,"North");
		/*center_friends_north_jp*/
		
		/*center_friends_center_jp*/	
		center_blacklist_center_jl.addMouseListener(this);
		center_blacklist_center_jl.setPreferredSize(new Dimension(350,25));
		center_blacklist_center_jl.setOpaque(true);
		center_blacklist_center_jp.add(center_blacklist_center_jl);
		center_blacklist_center_jp.setPreferredSize(new Dimension(0, 25));
		center_blacklist_jp.add(center_blacklist_center_jp,"Center");
		/*center_friends_south_jp*/
		
		
		//折叠列表
		//center_fold_jp1和center_fold_jp2分别放两个JPanel，里面分别放一个JLabel
		center_fold_jp = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		center_fold_jp_jl1 = new JLabel("friends",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		center_fold_jp_jl1.addMouseListener(this);
		center_fold_jp_jl1.setOpaque(true);
		center_fold_jp_jl1.setPreferredSize(new Dimension(350,25));
		center_fold_jp_jl2 = new JLabel("blacklist",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		center_fold_jp_jl2.addMouseListener(this);
		center_fold_jp_jl2.setOpaque(true);
		center_fold_jp_jl2.setPreferredSize(new Dimension(350,25));
		center_fold_jp.add(center_fold_jp_jl1);
		center_fold_jp.add(center_fold_jp_jl2);
	
		
		/*center_jp1设置成卡片布局*/
		cl = new CardLayout();
		center_jp1.setLayout(cl);			
		center_jp1.add(center_friends_jp, "1");
		center_jp1.add(center_blacklist_jp, "2");				
		center_jp1.add(center_fold_jp, "3");
		
		
		center_jtp.setFont(new Font("宋体",Font.BOLD,16));
		center_jtp.add("好友",center_jp1 );
		center_jtp.add("聊天记录",center_jp2 );
		center_jtp.add("群聊",center_jp3 );
		center_jtp.add("空间",center_jp4 );
		
		jp2.add(center_jtp);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==center_friends_south_jl)
		{
			cl.show(center_jp1,"2");
		}else if(arg0.getSource()==center_friends_north_jl)
		{
			cl.show(center_jp1, "3");
		}else if(arg0.getSource()==center_blacklist_north_jl)
		{
			cl.show(center_jp1, "1");
		}else if(arg0.getSource()==center_blacklist_center_jl)
		{
			cl.show(center_jp1, "3");
		}else if(arg0.getSource()==center_fold_jp_jl1)
		{
			cl.show(center_jp1, "1");
		}else if(arg0.getSource()==center_fold_jp_jl2)
		{
			cl.show(center_jp1, "2");
		}
		//双击打开聊天对话框
		else if(arg0.getClickCount()==2)  //表示双击
		{
			//得到该好友的编号
			String friendname=((JLabel)arg0.getSource()).getText();
	
				ChatFrame chat = new ChatFrame(name, friendname);
				
				//将chat加入到HashMap中
				ChatFrameHashMap.addChatFrame(name+friendname, chat);

		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel temporary_jl=(JLabel)arg0.getSource();
		temporary_jl.setBackground(new Color(180,168,181));
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel temporary_jl=(JLabel)arg0.getSource();
		temporary_jl.setBackground(null);
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	//更新好友列表
	public void updateFriendslist(String friends[]) {
		
		for(int i = 0; i < friends.length; i++) {
			
			this.firends[Integer.parseInt(friends[i])-1].setEnabled(true);
		}
	}
	
}
