package Game.Games.TicTacToe;

import Game.GameScene;
import Game.Games.TicTacToe.TicTacToeController.TicTacToeController;
import Map.Model.History;
import Player.Player;
import Game.Games.TicTacToe.TicTacToeModel.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;

public class TicTacToeScene extends GameScene {
    private final static int DEFAULT_SIZE = 3;

    public TicTacToeScene(Player[] listPlayers, boolean isTraining, History history) {
        this.model = new TicTacToeModel(listPlayers, DEFAULT_SIZE);
        this.view = new TicTacToeView(DEFAULT_SIZE, listPlayers, history);
        this.controller = new TicTacToeController((TicTacToeModel) this.model, (TicTacToeView) this.view, DEFAULT_SIZE, isTraining, history);
        this.controller.addObserver(this);
    }
}
