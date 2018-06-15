package QQFriendsList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendsListNorthPanel {
	//上部：分上下两个JPanel大类
	JPanel north_north_jp = null, north_south_jp = null;
		//north_south_jp中放一个文本框
	JLabel north_south_jt = null;
		//north_north_jp又分为左中右三个JPanel
	JPanel north_west_jp = null, north_center_jp = null, north_east_jp = null;
	   // north_west_jp和north_east_jp用JLabel放图片
	JLabel north_west_jl = null, north_east_jl = null;
		//north_center_jp放三个JPanel
	JPanel north_center_north_jp = null, north_center_center_jp = null, north_center_south_jp = null;
		//north_center_north_jp放一个标签，两个JLabel
	JLabel north_center_north_jl = null;
	JLabel north_center_north_jl1 = null, north_center_north_jl2 =null;
		//north_center_center_jp放一个文本框
	JLabel north_center_center_jl = null;
		//north_center_south_jp放5个JLabel
	JLabel north_center_south_jl1 = null, north_center_south_jl2 = null, north_center_south_jl3 = null, 
			north_center_south_jl4 = null, north_center_south_jl5 = null;
	
	
	public FriendsListNorthPanel(JPanel jp1) {
			north_north_jp = new JPanel();
			north_north_jp.setBackground( new Color(5,150,200));
			north_south_jp = new JPanel();
			//north_south_jp中放一个文本框
			north_south_jt = new JLabel("搜索");
			north_south_jt.setFont(new Font("宋体",Font.PLAIN,16));
			north_south_jt.setForeground(Color.white);
			north_south_jt.setBackground(new Color(5,170,230));
			north_south_jt.setPreferredSize(new Dimension(365, 40));
			north_south_jp.add(north_south_jt,"Center");
			north_south_jp.setBackground( new Color(5,170,230));
			north_south_jp.setPreferredSize(new Dimension(365, 40));
			jp1.add(north_south_jp, BorderLayout.SOUTH);
			//north_north_jp又分为左中右三个JPanel
			north_west_jp = new JPanel();
			north_center_jp = new JPanel();
			north_east_jp = new JPanel();
			north_west_jl = new JLabel(new ImageIcon("Image/friendslist/west.jpg"));
			north_east_jl = new JLabel(new ImageIcon("Image/friendslist/east.jpg"));
			north_west_jp.add(north_west_jl);
			north_east_jp.add(north_east_jl);
			north_west_jp.setBackground( new Color(5,84,100));
			north_east_jp.setBackground( new Color(5,84,100));
				//north_center_jp放三个JPanel
			north_center_north_jp = new JPanel();
			north_center_center_jp = new JPanel();
			north_center_south_jp = new JPanel();
					//north_center_north_jp放一个标签，两个按钮
			north_center_north_jl = new JLabel("铿锵慎行");
			north_center_north_jl.setPreferredSize(new Dimension(95, 22));
			north_center_north_jl.setBackground( new Color(5,150,200));
			north_center_north_jl.setFont(new Font("宋体",Font.BOLD,22));
			north_center_north_jl.setForeground(Color.white);	
			north_center_north_jl1 = new JLabel("1");
			north_center_north_jl1.setBackground( new Color(5,150,200));
			north_center_north_jl2 = new JLabel("LV50");
			north_center_north_jl2.setForeground(Color.yellow);	
			north_center_north_jl2.setBackground( new Color(5,150,200));	
			north_center_north_jp.setLayout(new FlowLayout(FlowLayout.LEFT));
			north_center_north_jp.add(north_center_north_jl);
			north_center_north_jp.add(north_center_north_jl1);
			north_center_north_jp.add(north_center_north_jl2);
			north_center_north_jp.setBackground( new Color(5,150,200));
					//north_center_center_jp放一个文本框
			north_center_center_jl = new JLabel("君子以自强不息");
			north_center_center_jl.setPreferredSize(new Dimension(160, 16));
			north_center_center_jl.setFont(new Font("宋体",Font.PLAIN,16));
			north_center_center_jl.setForeground(Color.white);	
			north_center_center_jl.setBackground( new Color(5,150,200));
			north_center_center_jp.add(north_center_center_jl);
			north_center_center_jp.setBackground( new Color(5,150,200));
					//north_center_south_jp放5个JLabel
			north_center_south_jl1 = new JLabel("11");
			north_center_south_jl2  = new JLabel("22");
			north_center_south_jl3  = new JLabel("33");
			north_center_south_jl4  = new JLabel("44");
			north_center_south_jl5  = new JLabel("55");
			north_center_south_jp.setLayout(new FlowLayout(FlowLayout.LEFT));
			north_center_south_jp.add(north_center_south_jl1);
			north_center_south_jp.add(north_center_south_jl2);
			north_center_south_jp.add(north_center_south_jl3);
			north_center_south_jp.add(north_center_south_jl4);
			north_center_south_jp.add(north_center_south_jl5);
			north_center_south_jp.setBackground( new Color(5,150,200));
			
			north_center_jp.setLayout(new BorderLayout());
			north_center_jp.add(north_center_north_jp, "North");
			north_center_jp.add(north_center_center_jp, "Center");
			north_center_jp.add(north_center_south_jp, "South");
			
			north_west_jp.setPreferredSize(new Dimension(84, 85));
			north_center_jp.setPreferredSize(new Dimension(170, 87));
			north_center_jp.setBackground( new Color(5,180,200));
			north_east_jp.setPreferredSize(new Dimension(79, 87));
			
			north_north_jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
			north_north_jp.setPreferredSize(new Dimension(365, 110));
			north_north_jp.add(north_west_jp);
			north_north_jp.add(north_center_jp);
			north_north_jp.add(north_east_jp);			
			jp1.add(north_north_jp, BorderLayout.NORTH);
		}

}
