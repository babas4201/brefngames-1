package Game.Games.Runner.RunnerController;

import Game.Controller.AbstractGameController;
import Game.Games.Runner.RunnerModel.RunnerModel;
import Game.Games.Runner.RunnerView.RunnerView;
import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Scene.Model.ActionEnum;

import java.util.Observable;

public class RunnerController extends AbstractGameController {
    public RunnerController(AbstractGameModel model, AbstractGameView view, boolean isTraining) {
        super(model, view, isTraining);

        // setup position in the view
        ((RunnerView) this.view).setStepsAmount(((RunnerModel) this.model).getStepsAmount());
        ((RunnerView) this.view).updateFirstPlayerPosition(((RunnerModel) this.model).getRemainingSteps(PlayerEnum.FIRST_PLAYER));
        ((RunnerView) this.view).updateSecondPlayerPosition(((RunnerModel) this.model).getRemainingSteps(PlayerEnum.SECOND_PLAYER));
    }

    @Override
    public void update(Observable o, Object action) {
        // update model
        switch ((ActionEnum) action) {
            case KEY_PRESS_A:
                ((RunnerModel) this.model).keyPressed(ControlEnum.LEFT, PlayerEnum.FIRST_PLAYER);
                break;
            case KEY_PRESS_Z:
                ((RunnerModel) this.model).keyPressed(ControlEnum.RIGHT, PlayerEnum.FIRST_PLAYER);
                break;
            case KEY_PRESS_R:
                ((RunnerModel) this.model).keyPressed(ControlEnum.LEFT, PlayerEnum.SECOND_PLAYER);
                break;
            case KEY_PRESS_T:
                ((RunnerModel) this.model).keyPressed(ControlEnum.RIGHT, PlayerEnum.SECOND_PLAYER);
                break;
            default:
                throw new RuntimeException("Unable to find : " + action);
        }

        // update view
        switch ((ActionEnum) action) {
            case KEY_PRESS_A:
            case KEY_PRESS_Z:
                ((RunnerView) this.view).updateFirstPlayerPosition(((RunnerModel) this.model).getRemainingSteps(PlayerEnum.FIRST_PLAYER));
                ((RunnerView) this.view).updateFirstPlayerNextKey(((RunnerModel) this.model).isNextKeyLeft(PlayerEnum.FIRST_PLAYER));
                break;
            case KEY_PRESS_R:
            case KEY_PRESS_T:
                ((RunnerView) this.view).updateSecondPlayerPosition(((RunnerModel) this.model).getRemainingSteps(PlayerEnum.SECOND_PLAYER));
                ((RunnerView) this.view).updateSecondPlayerNextKey(((RunnerModel) this.model).isNextKeyLeft(PlayerEnum.SECOND_PLAYER));
                break;
            default:
                throw new RuntimeException("Unable to find : " + action);
        }

        // check winner
        if (((RunnerModel) this.model).isGameFinished()) {
            // save stats
            if (!this.isTraining) {
                ((RunnerModel) this.model).saveStatistics();
            }

            // change scene
            this.setChanged();
            this.notifyObservers(
                    ((RunnerModel) this.model).isFirstPlayerWinner() ? ActionEnum.FIRST_PLAYER_WON : ActionEnum.SECOND_PLAYER_WON
            );
        }
    }
}
