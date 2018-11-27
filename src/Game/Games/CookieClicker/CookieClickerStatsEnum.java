package Game.Games.CookieClicker;

public enum CookieClickerStatsEnum {
    /*
     * COOKIE CLICKER
     */
    COOKIE_CLICKER_NB_GAMES("COOKIE_CLICKER_NB_GAMES"),
    COOKIE_CLICKER_NB_CLICS("COOKIE_CLICKER_NB_CLICS"),
    COOKIE_CLICKER_BEST_PLAYER("COOKIE_CLICKER_BEST_PLAYER"),
    COOKIE_CLICKER_NB_PERFECT("COOKIE_CLICKER_NB_PERFECT"),
    COOKIE_CLICKER_TOTAL_REQUIRED_CLIC("COOKIE_CLICKER_TOTAL_REQUIRED_CLIC"),
    COOKIE_CLICKER_AVERAGE_REQUIRED_CLIC("COOKIE_CLICKER_AVERAGE_REQUIRED_CLIC"),
    COOKIE_CLICKER_TOTAL_FAULT("COOKIE_CLICKER_TOTAL_FAULT"),
    COOKIE_CLICKER_AVERAGE_FAULT("COOKIE_CLICKER_AVERAGE_FAULT"),
    COOKIE_CLICKER_TOTAL_TIME("COOKIE_CLICKER_TOTAL_TIME")
    ;

    private String name = "";

    CookieClickerStatsEnum(String s)
    {
        this.name = s;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
