package com.wildcatrobotics.dashboard;

import java.awt.Color;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.wildcatrobotics.dashboard.objects.UIBar;
import com.wildcatrobotics.dashboard.objects.UIGraph;
import com.wildcatrobotics.dashboard.objects.UISpeedometer;
import com.wildcatrobotics.dashboard.sockettest.Ping;

public class Dashboard {

	JFrame f = new JFrame("Dashboard");
	JPanel p = new JPanel();
	JPanel cameraT = new JPanel();
	
	private static final String ip = "localhost";
	private static final String port = "7777";
	
	public static double data = 0;
	public static void main(String args[]){
		new Dashboard().start();
	}
	
	public void start(){
		f.setSize(1024, 700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.add(p);
		p.setLayout(null);
		{
			p.add(cameraT);
			cameraT.setBackground(Color.white);
			cameraT.setBounds(25, 25,350, 300);
		}
		
		UIBar bar = new UIBar(725, 60 ,25, 150);
		UIBar bar2 = new UIBar(755, 60 ,25, 150);

		UISpeedometer sp = new UISpeedometer(400, 50, 150);
		UIGraph gp = new UIGraph(100,400,300,150);
		p.add(bar);
		p.add(bar2);
		p.add(sp);
		p.add(gp);
		sp.setValue(25);
		//bar.setValue(25);
		bar2.setValue(50);
		p.repaint();
		f.setVisible(true);

		/*bar.setMin(-1);
		bar.setMax(1);*/
		Hashtable<String, Object> ht = new Hashtable<String, Object>();
		
		ht.put("MAIN", 4);
		ht.put("NOOB", "SDFSDF");
		
		System.out.println(ht.toString());
		
		Random rand = new Random();
		int a = 0;
		
		new Ping().start();
		
		
		while(true){
			try{Thread.sleep(10);}catch(Exception e){}
			bar.setValue(((data + 1)/2)*100);
			//bar.setValue(data);
		}
		
	}

	
	
	
}
