package com.optivem.kata.banking.core.usecases.depositfunds;

import com.optivem.kata.banking.core.domain.accounts.*;
import com.optivem.kata.banking.core.domain.exceptions.ValidationMessages;
import com.optivem.kata.banking.core.usecases.UseCase;

import static com.optivem.kata.banking.core.domain.common.Guard.guard;

public class DepositFundsUseCase implements UseCase<DepositFundsRequest, DepositFundsResponse> {

    private final BankAccountRepository repository;

    public DepositFundsUseCase(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public DepositFundsResponse handle(DepositFundsRequest request) {
        var accountNumber = getAccountNumber(request);
        var amount = getTransactionAmount(request);

        var bankAccount = findBankAccount(accountNumber);
        bankAccount.deposit(amount);
        repository.update(bankAccount);

        return getResponse(bankAccount);
    }

    private AccountNumber getAccountNumber(DepositFundsRequest request) {
        return new AccountNumber(request.getAccountNumber());
    }

    private TransactionAmount getTransactionAmount(DepositFundsRequest request) {
        return new TransactionAmount(new Money(request.getAmount()));
    }

    private BankAccount findBankAccount(AccountNumber accountNumber) {
        var optionalBankAccount = repository.find(accountNumber);
        guard(optionalBankAccount).againstEmpty(ValidationMessages.ACCOUNT_NUMBER_NOT_EXIST);
        return optionalBankAccount.get();
    }

    private DepositFundsResponse getResponse(BankAccount bankAccount) {
        var response = new DepositFundsResponse();
        response.setBalance(bankAccount.getBalance().value().value());
        return response;
    }
}
