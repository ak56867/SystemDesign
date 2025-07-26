public class TvMachine {
    TvState tvState;

    public TvMachine() {
        tvState = new OffState();
    }

    public TvState getTvState() {
        return tvState;
    }

    public void setTvState(TvState tvState) {
        this.tvState = tvState;
    }
}
