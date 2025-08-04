package AmountWithdrawal;

import AtmService.Atm;

public class TwoThousandWithdrawProcessor extends WithdrawalProcessor{
    public TwoThousandWithdrawProcessor(WithdrawalProcessor nextWithdrawalProcessor) {
        super(nextWithdrawalProcessor);
    }

    @Override
    public void withdraw(Atm atm, int amount) {
        int required = amount / 2000;
        int remaining = amount % 2000;

        if(required <= atm.getNoOfTwoThousandNotes()) {

        }
    }
}
