package com.exam.jdbc01;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

public class WeekendCalendar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
    public WeekendCalendar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JCalendar calendar = new JCalendar();
        calendar.setBounds(10, 10, 200, 200);
        contentPane.add(calendar);

        highlightWeekends(calendar);

        calendar.getDayChooser().addPropertyChangeListener("day", evt -> {
            highlightWeekends(calendar);
        });
    }

    private void highlightWeekends(JCalendar calendar) {
        Date selectedDate = calendar.getDate();

        Calendar cal = Calendar.getInstance();
        cal.setTime(selectedDate);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        for (int day = 1; day <= daysInMonth; day++) {
            cal.set(Calendar.DAY_OF_MONTH, day);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

            if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                calendar.getDayChooser().getDayPanel().getComponent(day + startDayOfWeek - 2).setBackground(Color.LIGHT_GRAY);
            } else {
                calendar.getDayChooser().getDayPanel().getComponent(day + startDayOfWeek - 2).setBackground(Color.WHITE);
            }
        }
    }

}
