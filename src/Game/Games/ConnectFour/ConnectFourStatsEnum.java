package Game.Games.ConnectFour;

public enum ConnectFourStatsEnum {
    /*
     * CONNECT FOUR
     */
    CONNECT_FOUR_NB_GAMES("CONNECT_FOUR_NB_GAMES"),
    CONNECT_FOUR_NB_DRAW("CONNECT_FOUR_NB_DRAW"),
    CONNECT_FOUR_BEST_PLAYER("CONNECT_FOUR_BEST_PLAYER"),
    CONNECT_FOUR_NB_YELLOW_PAWNS("CONNECT_FOUR_NB_YELLOW_PAWNS"),
    CONNECT_FOUR_NB_RED_PAWNS("CONNECT_FOUR_NB_RED_PAWNS"),
    CONNECT_FOUR_NB_ALL_PAWNS("CONNECT_FOUR_NB_ALL_PAWNS"),
    CONNECT_FOUR_NB_WIN_VERTICAL("CONNECT_FOUR_NB_WIN_VERTICAL"),
    CONNECT_FOUR_NB_WIN_LANDSCAPE("CONNECT_FOUR_NB_WIN_LANDSCAPE"),
    CONNECT_FOUR_NB_WIN_DIAG("CONNECT_FOUR_NB_WIN_DIAG"),
    CONNECT_FOUR_AVERAGE_TIME("CONNECT_FOUR_AVERAGE_TIME"),
    CONNECT_FOUR_TOTAL_TIME("CONNECT_FOUR_TOTAL_TIME")
    ;

    private String name = "";

    ConnectFourStatsEnum(String s)
    {
        this.name = s;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

}
