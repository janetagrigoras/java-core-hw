public class AccountServiceImpl implements AccountService{
    Account[] accs;
    AccountServiceImpl(Account[] accs) {
        this.accs = accs;
    }

    public Account findAccountByOwnerId(long id) {
        for (Account acc : accs) {
            if (acc.getOwner().getId() == id) {
                return acc;
            }
        }
        return null;
    }

    public long countAccountsWithBalanceGreaterThan(long value) {
        long count = 0;
        for (Account acc : accs) {
            if (acc.getBalance() > value) {
                count++;
            }
        }
        return count;
    }
}
