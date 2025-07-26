public class OffState implements TvState{
    @Override
    public void clickPowerButton(TvMachine tvMachine) {
        System.out.println("Power button clicked, turning on tv...");
        tvMachine.setTvState(new OnState());
    }

    @Override
    public void changeVolume(TvMachine tvMachine, int volume) throws Exception{
        throw new Exception("Tv is Switched Off");
    }

    @Override
    public void changeChannel(TvMachine tvMachine, int channelNumber) throws Exception{
        throw new Exception("Tv is Switched Off");
    }
}
