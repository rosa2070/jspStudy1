package com.exam.gugudan;

import java.awt.EventQueue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx01 frame = new JFrameEx01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
