
public class Main {
    public static void main(String[] args) {
        TvMachine tvMachine = new TvMachine();

        try {
            System.out.println("Clicking on Power button..");
            TvState tvState = tvMachine.getTvState();
            tvState.clickPowerButton(tvMachine);

            System.out.println("Changing Channel...");
            tvState = tvMachine.getTvState();
            tvState.changeChannel(tvMachine, 203);

            System.out.println("Clicking on Power button..");
            tvState = tvMachine.getTvState();
            tvState.clickPowerButton(tvMachine);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}