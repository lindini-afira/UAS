package GUI_JDBC;

import javax.swing.JFrame;

import com.sun.jdi.event.EventQueue;

public class Run extends JFrame{
	public static void main(String[] args) {
		EventQueue(new Runnable() {
			public void run() {
				try {
					new Perpustakaan().frmPerpustakaan.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void EventQueue(Runnable runnable) {
		// TODO Auto-generated method stub
		
	}

}
