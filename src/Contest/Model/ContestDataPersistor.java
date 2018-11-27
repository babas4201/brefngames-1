package Contest.Model;

import Game.Games.ConnectFour.ConnectFourStatsEnum;
import Game.Games.CookieClicker.CookieClickerStatsEnum;
import Game.Games.Runner.RunnerStatsEnum;
import Game.Games.TicTacToe.TicTacToeStatsEnum;
import Repository.Game.RunnerRepository;
import Repository.Game.TicTacToeRepository;

import java.util.Map;

public class ContestDataPersistor {

    public static void updateTicTacToe(Map<TicTacToeStatsEnum, String> gameMap) {
        Map<TicTacToeStatsEnum, String> dataEntries = TicTacToeRepository.getAll();
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_GAMES);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_CIRCLE);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_CROSS);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_ALL_SIGNS);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_DRAW);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_NB_PERFECT);
        updateIntValueTicTacToe(dataEntries, gameMap, TicTacToeStatsEnum.TIC_TAC_TOE_TOTAL_TIME);
        // Average time took per sign
        dataEntries.put(
                TicTacToeStatsEnum.TIC_TAC_TOE_AVERAGE_TIME,
                String.valueOf(
                        Integer.parseInt(dataEntries.get(TicTacToeStatsEnum.TIC_TAC_TOE_TOTAL_TIME))
                                / Integer.parseInt(dataEntries.get(TicTacToeStatsEnum.TIC_TAC_TOE_NB_ALL_SIGNS))
                )
        );
        //TODO Add best player in playerStatsRepository
        TicTacToeRepository.saveAll(dataEntries);
    }

    private static void updateIntValueTicTacToe(Map<TicTacToeStatsEnum, String> dataEntries, Map<TicTacToeStatsEnum, String> gamesEntries, TicTacToeStatsEnum stats) {
        dataEntries.put(
                stats,
                String.valueOf(
                        Integer.parseInt(gamesEntries.get(stats))
                                + Integer.parseInt(dataEntries.get(stats))
                )
        );
    }

    public static void updateRunner(Map<RunnerStatsEnum, String> gameMap) {
        Map<RunnerStatsEnum, String> dataEntries = RunnerRepository.getAll();
        updateIntValueRunner(dataEntries, gameMap, RunnerStatsEnum.RUNNER_NB_GAMES);
        updateIntValueRunner(dataEntries, gameMap, RunnerStatsEnum.RUNNER_NB_CLICS);
        updateIntValueRunner(dataEntries, gameMap, RunnerStatsEnum.RUNNER_TOTAL_TIME);
        // Average time of each race
        dataEntries.put(
                RunnerStatsEnum.RUNNER_AVERAGE_TIME,
                String.valueOf(
                        Integer.parseInt(dataEntries.get(RunnerStatsEnum.RUNNER_TOTAL_TIME))
                                / Integer.parseInt(dataEntries.get(RunnerStatsEnum.RUNNER_NB_GAMES))
                )
        );

        // Average clicks per second
        dataEntries.put(
                RunnerStatsEnum.RUNNER_AVERAGE_SPEED,
                String.valueOf(
                        Integer.parseInt(dataEntries.get(RunnerStatsEnum.RUNNER_NB_CLICS))
                                / Integer.parseInt(dataEntries.get(RunnerStatsEnum.RUNNER_TOTAL_TIME))
                )
        );
        //TODO Add best player in playerStatsRepository
        RunnerRepository.saveAll(dataEntries);
    }

    private static void updateIntValueRunner(Map<RunnerStatsEnum, String> dataEntries, Map<RunnerStatsEnum, String> gamesEntries, RunnerStatsEnum stats) {
        dataEntries.put(
                stats,
                String.valueOf(
                        Integer.parseInt(gamesEntries.get(stats))
                                + Integer.parseInt(dataEntries.get(stats))
                )
        );
    }


    public static void updateCookieCliker(Map<CookieClickerStatsEnum, String> gameMap) {
        // TODO update repo
    }

    public static void updateConnectFour(Map<ConnectFourStatsEnum, String> gameMap) {
        // TODO update repo
    }
}
