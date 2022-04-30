package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {

		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();

		acc.deposit(amount);

		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {

		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;

		acc.deposit(amount);

		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {

		double expectedValue = 0.0;
		double initialBalance = 100.0;
		Account acc = AccountFactory.createAccount(initialBalance);

		double result = acc.fullWithdraw();

		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}

	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {

		double initialBalance = 800.0;
		double valueToWithdraw = 500.0;
		double expectedValue = 300.0;
		Account acc = AccountFactory.createAccount(initialBalance);

		acc.withdraw(valueToWithdraw);

		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void withDrawShouldThrowExceptionInsufficientBalance() {

		double initialBalance = 800.0;
		double valueToWithdraw = 850.0;

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(initialBalance);
			acc.withdraw(valueToWithdraw);
		});
	}

}
