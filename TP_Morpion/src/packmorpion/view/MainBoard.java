package packmorpion.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import packmorpion.model.ModelMorp;

public class MainBoard extends Observable implements Observer {
	private ModelMorp m;
	// private JLabel secondLabel;
	// private JLabel minuteLabel;
	// private JLabel hourLabel;
	// private NumberFormat nFormat = new DecimalFormat("00");
	// entete
	private JPanel header;
	private JLabel headerNom;
	// plateau de jeu
//	private JPanel board;
	private GameBoard board;
	// historique
	private JPanel histo;

	public MainBoard(ModelMorp m) {
		this.m = m;
		createGUI();
	}

	@Override
	public void update(Observable o, Object o1) {
		// NumberFormat nFormat = new DecimalFormat("00");

		// if (secondLabel != null) {
		// secondLabel.setText(nFormat.format(m.getSecond()));
		// }
		// if (minuteLabel != null) {
		// minuteLabel.setText(nFormat.format(m.getMinute()));
		// }
		// if (hourLabel != null) {
		// hourLabel.setText(nFormat.format(m.getHour()));
		// }
	}

	private void createGUI() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame jFrame = new JFrame();
				jFrame.setPreferredSize(new Dimension(500, 500));
				jFrame.setLocation(400, 200);
				jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

				// ------------------- placement des elements
				// principaux--------------------------
				jFrame.setLayout(new GridBagLayout());
				GridBagConstraints constraints = new GridBagConstraints();

				// entete
				constraints.gridy = 0;
				constraints.gridx = 0;
				constraints.gridwidth = 10;
				constraints.weightx = 10;
				constraints.weighty = 1;
				// constraints.gridheight = 2;
				header = new JPanel();
				header.setBackground(Color.RED);
				headerNom = new JLabel();
				// header.setFont(new Font("Arial", Font.PLAIN, 40));
				// header.setText("Entete");
				header.add(headerNom);
				jFrame.add(header, constraints);

				// plateau de jeu
				constraints.gridy = 1;
				constraints.gridx = 0;
				constraints.gridheight = 4;
				constraints.gridwidth = 7;
				constraints.weightx = 7;
				constraints.weighty = 4;
//				board = new JPanel();
//				board.setBackground(Color.BLUE);
				// creation du plateau
				board = new GameBoard(4, 4, 200, 200);
//				board.add(boardPicture);
				// boardPicture.repaint();
				jFrame.add(board, constraints);
				// jFrame.add(boardPicture, constraints);
				// jFrame.add(boardPicture);

				// historique
				constraints.gridx = 7;
				constraints.gridwidth = 3;
				constraints.weightx = 3;
				constraints.weighty = 4;
				histo = new JPanel();
				histo.setBackground(Color.GREEN);
				jFrame.add(histo, constraints);

				// //Inc Button
				// constraints.gridy = 0;
				// constraints.gridheight = 1;
				//
				// JButton buttonIncSecond = new JButton("+");
				// buttonIncSecond.addActionListener(new ActionListener() {
				// @Override
				// public void actionPerformed(ActionEvent ae) {
				// setChanged();
				// notifyObservers(NotifList.INC_SEC);
				// }
				// });
				// constraints.gridx = 5;
				// jFrame.add(buttonIncSecond, constraints);
				//
				// JButton buttonIncMinute = new JButton("+");
				// buttonIncMinute.addActionListener(new ActionListener() {
				// @Override
				// public void actionPerformed(ActionEvent ae) {
				// setChanged();
				// notifyObservers(NotifList.INC_MIN);
				// }
				// });
				// constraints.gridx = 3;
				// jFrame.add(buttonIncMinute, constraints);
				//
				// JButton buttonIncHour = new JButton("+");
				// buttonIncHour.addActionListener(new ActionListener() {
				// @Override
				// public void actionPerformed(ActionEvent ae) {
				// setChanged();
				// notifyObservers(NotifList.INC_HOUR);
				// }
				// });
				// constraints.gridx = 1;
				// jFrame.add(buttonIncHour, constraints);
				//
				// //Dec Button
				// constraints.gridy = 3;
				//
				// JButton buttonDecSecond = new JButton("-");
				// buttonDecSecond.addActionListener(new ActionListener() {
				// @Override
				// public void actionPerformed(ActionEvent ae) {
				// setChanged();
				// notifyObservers(NotifList.DEC_SEC);
				// }
				// });
				// constraints.gridx = 5;
				// jFrame.add(buttonDecSecond, constraints);
				//
				// JButton buttonDecMinute = new JButton("-");
				// buttonDecMinute.addActionListener(new ActionListener() {
				// @Override
				// public void actionPerformed(ActionEvent ae) {
				// setChanged();
				// notifyObservers(NotifList.DEC_MIN);
				// }
				// });
				// constraints.gridx = 3;
				// jFrame.add(buttonDecMinute, constraints);
				//
				// JButton buttonDecHour = new JButton("-");
				// buttonDecHour.addActionListener(new ActionListener() {
				// @Override
				// public void actionPerformed(ActionEvent ae) {
				// setChanged();
				// notifyObservers(NotifList.DEC_HOUR);
				// }
				// });
				// constraints.gridx = 1;
				// jFrame.add(buttonDecHour, constraints);
				//
				//
				//
				// //synch -raz
				// constraints.gridx = 6;
				// JButton buttonSync = new JButton("synch");
				// buttonSync.addActionListener(new ActionListener() {
				// @Override
				// public void actionPerformed(ActionEvent ae) {
				// setChanged();
				// notifyObservers(NotifList.SYNC);
				// }
				// });
				// constraints.gridy = 1;
				// jFrame.add(buttonSync, constraints);
				//
				// JButton buttonRaz = new JButton("raz");
				// buttonRaz.addActionListener(new ActionListener() {
				// @Override
				// public void actionPerformed(ActionEvent ae) {
				// setChanged();
				// notifyObservers(NotifList.RAZ);
				// }
				// });
				// constraints.gridy = 2;
				// jFrame.add(buttonRaz, constraints);
				//
				// //start - stop
				// constraints.gridx = 0;
				// JButton buttonStart = new JButton("start");
				// buttonStart.addActionListener(new ActionListener() {
				// @Override
				// public void actionPerformed(ActionEvent ae) {
				// setChanged();
				// notifyObservers(NotifList.START);
				// }
				// });
				// constraints.gridy = 1;
				// jFrame.add(buttonStart, constraints);
				//
				// JButton buttonStop = new JButton("stop");
				// buttonStop.addActionListener(new ActionListener() {
				// @Override
				// public void actionPerformed(ActionEvent ae) {
				// setChanged();
				// notifyObservers(NotifList.STOP);
				// }
				// });
				// constraints.gridy = 2;
				// jFrame.add(buttonStop, constraints);

				jFrame.pack();
				jFrame.setVisible(true);
			}
		});

	}

}
