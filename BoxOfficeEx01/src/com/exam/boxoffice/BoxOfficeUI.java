package com.exam.boxoffice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoxOfficeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	private JButton[] buttons = new JButton[49];
	String[] dayNames = { "일", "월", "화", "수", "목", "금", "토" };
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoxOfficeUI frame = new BoxOfficeUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BoxOfficeUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		contentPane.add(panel1, BorderLayout.NORTH);
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btn = new JButton("달력보이기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 날짜 지우기
				for( int i=7; i<buttons.length ; i++) {
					buttons[i].setText( "" );
				}
				
				// 날짜 채우기
				Calendar cal = Calendar.getInstance();
				int year = 2024;
				int month = 6;
				
				cal.set( year, month-1, 1 );
				int firstDay = cal.get( Calendar.DAY_OF_WEEK );
				firstDay--;
				for( int i=1 ; i<=cal.getActualMaximum( cal.DATE ) ; i++ ) {
					buttons[ 6 + firstDay + i ].setText( String.valueOf( i ) );
				}
			}
		});
		btn.setFont( new Font( "SansSerif", Font.BOLD, 15 ) );
		panel1.add(btn);
		
		JPanel panel2 = new JPanel();
		contentPane.add(panel2, BorderLayout.CENTER);
		panel2.setLayout(new GridLayout(7, 7, 6, 6));
		
		for( int i=0 ; i<buttons.length ; i++ ) {
			buttons[i] = new JButton();
			buttons[i].setFont( new Font( "SansSerif", Font.BOLD, 15 ) );
			panel2.add( buttons[i] );
			
			if( i<7 ) {
				buttons[i].setText( dayNames[i] );
				buttons[i].setEnabled( false );
			}
			if( i%7 == 0 ) {
				buttons[i].setForeground( Color.RED );
			}
			if( i%7 == 6 ) {
				buttons[i].setForeground( Color.BLUE );
			}
		}
	}
}
