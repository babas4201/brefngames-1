package Menu.View;

import Launcher.LauncherWindow;
import Player.Player;
import Repository.Player.PlayerRepository;
import Scene.Model.ActionEnum;
import Utils.Image.ImageResizer;
import Utils.UI.CustomButton;
import Utils.UI.CustomPanel.CustomBackgroundPanel;
import Utils.UI.FileGetter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuView extends CustomBackgroundPanel {

    private final JButton trainingButton;
    private final JButton contestButton;
    private final JButton parametersButton;
    private final JButton statisticsButton;
    private final JButton creditButton;
    private final JButton quitButton;

    public MenuView() {
        super();

        this.setPreferredSize(new Dimension(LauncherWindow.JFRAME_WIDTH, LauncherWindow.JFRAME_HEIGHT));
        this.setLayout(new GridBagLayout());

        this.trainingButton = new CustomButton("Training");
        this.contestButton = new CustomButton("Contest");
        this.parametersButton = new CustomButton("Parameters");
        this.statisticsButton = new CustomButton("Statistics");
        this.creditButton = new CustomButton("Credits");
        this.quitButton = new CustomButton("Quit");

        this.initButtonsActionListeners();

        // reusable GridBagConstraint to place every needed components
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.fill = GridBagConstraints.VERTICAL;

        constraint.gridy = 0;
        constraint.gridwidth = 2;
        this.add(new JLabel(new ImageIcon(ImageIcon.class.getResource("/data/Images/logo.png"))), constraint);
        constraint.gridwidth = 1;

        constraint.insets.top = 5;

        constraint.gridx = 0;
        constraint.gridy = 1;
        this.add(this.trainingButton, constraint);

        constraint.gridx = 1;
        constraint.gridy = 1;
        this.add(this.contestButton, constraint);

        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.gridwidth = 2;
        this.add(this.parametersButton, constraint);
        constraint.gridwidth = 1;

        constraint.gridx = 0;
        constraint.gridy = 3;
        constraint.gridwidth = 2;
        List<Player> players = PlayerRepository.getAll();
        if (players.isEmpty()) {
            this.statisticsButton.setEnabled(false);
            ((CustomButton) this.statisticsButton).setBackgroundGrey();
        }
        this.add(this.statisticsButton, constraint);
        constraint.gridwidth = 1;

        constraint.gridx = 0;
        constraint.gridy = 4;
        constraint.gridwidth = 2;
        this.add(this.creditButton, constraint);
        constraint.gridwidth = 1;

        constraint.gridx = 0;
        constraint.gridy = 5;
        constraint.gridwidth = 2;
        this.add(this.quitButton, constraint);
        constraint.gridwidth = 1;
    }

    private void initButtonsActionListeners() {
        this.trainingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView.this.observable.notifyObservers(ActionEnum.TRAINING);
            }
        });

        this.contestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView.this.observable.notifyObservers(ActionEnum.CONTEST);
            }
        });

        this.parametersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView.this.observable.notifyObservers(ActionEnum.PARAMETERS);
            }
        });

        this.statisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView.this.observable.notifyObservers(ActionEnum.STATISTICS);
            }
        });

        this.creditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView.this.observable.notifyObservers(ActionEnum.CREDITS);
            }
        });

        this.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView.this.observable.notifyObservers(ActionEnum.QUIT);
            }
        });
    }
}
