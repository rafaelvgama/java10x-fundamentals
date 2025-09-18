> en 🇺🇸

# Challenge 5

## Description
Manage bank accounts in the Bank of Konoha using **interfaces and abstract classes**:
- Interface `Account` with methods `checkBalance()` and `deposit(double)`.
- Abstract class `BankAccount` that implements `Account`.
- Classes `CheckingAccount` and `SavingsAccount` extending `BankAccount`.

## Extra Tips
- `CheckingAccount`: regular deposit.
- `SavingsAccount`: deposit with a 1% fee.
- Add `balance` attribute and implement `checkBalance()`.

## Bonus
Implement an **enum AccountType** (CHECKING, SAVINGS) and overload methods in `KonohaBank` to handle transfers between accounts.

---
> pt-br 🇧🇷

# Desafio 5

## Descrição
Gerencie contas bancárias do Banco de Konoha com **interfaces e classes abstratas**:
- Interface `Conta` com métodos `consultarSaldo()` e `depositar(double)`.
- Classe abstrata `ContaBancaria` que implementa `Conta`.
- Classes `ContaCorrente` e `ContaPoupanca` que herdam de `ContaBancaria`.

## Dicas extras
- `ContaCorrente`: depósito normal.
- `ContaPoupanca`: depósito com taxa de 1%.
- Adicione atributo `saldo` e implemente o método `consultarSaldo()`.

## Bonus
Implemente um **enum TipoConta** (CORRENTE, POUPANCA) e sobrecarregue métodos no `BancoKonoha` para transferências entre contas.
