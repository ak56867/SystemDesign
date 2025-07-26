public interface TvState {
    void clickPowerButton(TvMachine tvMachine) throws Exception;
    void changeVolume(TvMachine tvMachine, int volume) throws Exception;
    void changeChannel(TvMachine tvMachine, int channelNumber) throws Exception;
}
