package AmountWithdrawal;

import AtmService.Atm;

public class WithdrawalProcessor {
    WithdrawalProcessor nextWithdrawalProcessor;

    public WithdrawalProcessor(WithdrawalProcessor nextWithdrawalProcessor) {
        this.nextWithdrawalProcessor = nextWithdrawalProcessor;
    }

    public void withdraw(Atm atm, int amount) {
        if(nextWithdrawalProcessor != null) {
            nextWithdrawalProcessor.withdraw(atm, amount);
        }
    }
}
