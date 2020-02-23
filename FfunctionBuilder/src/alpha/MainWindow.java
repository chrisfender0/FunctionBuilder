package alpha;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainWindow extends JFrame{
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

            	MainWindow ex = new MainWindow();
                ex.setVisible(true);
            }
        });
	}
	
	private MainWindow() {
		init();
	}
	
	private void init() {
		Graph graph = new Graph();
		add(graph);
		setTitle("Graph");
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
