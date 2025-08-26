[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/sO9umX0G)
# Aula 2.1 — Atividade:  Single Responsibility Principle (SRP)

No código atual, a classe ReceiptService viola o Princípio da Responsabilidade Única (SRP) porque acumula múltiplas funções:

- Calcula o subtotal do pedido

- Aplica a taxa de imposto (fixa em 10%)

- Formata o recibo em texto

Além disso, a taxa de imposto está hardcoded (10%) em vez de ser configurável.

Por isso, os testes configuram System.setProperty("tax.rate", "0.08") (8%) e esperam que o recibo reflita essa taxa.
Na implementação inicial, o serviço ignora essa configuração e os testes falham.

## Seu desafio

Refatore o código de forma que cada classe tenha uma única responsabilidade:

- TaxCalculator → responsável por calcular o imposto a partir de uma taxa configurável

- ReceiptFormatter → responsável apenas por montar o texto do recibo

- ReceiptService → orquestra: calcula subtotal, aplica imposto usando o TaxCalculator e gera o recibo usando o ReceiptFormatter

## Regras

A taxa de imposto não deve ser fixada em 10%.

Ela deve ser configurável, por exemplo lendo System.getProperty("tax.rate").

A ReceiptService não deve saber como calcular imposto nem como formatar texto.


## Como rodar
```bash
mvn -q test
```