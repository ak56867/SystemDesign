public class OnState implements TvState{
    @Override
    public void clickPowerButton(TvMachine tvMachine) throws Exception {
        System.out.println("Power button clicked, turning Off tv...");
        tvMachine.setTvState(new OffState());
    }

    @Override
    public void changeVolume(TvMachine tvMachine, int volume) throws Exception {
        System.out.println("Volume changed to " + volume);
    }

    @Override
    public void changeChannel(TvMachine tvMachine, int channelNumber) throws Exception {
        System.out.println("Channel changed to " + channelNumber);
    }
}
