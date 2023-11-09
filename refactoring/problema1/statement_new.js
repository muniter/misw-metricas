const plays = require("./data/plays.json");
const invoices = require("./data/invoices.json");

const formatAmount = new Intl.NumberFormat("en-US", {
  style: "currency",
  currency: "USD",
  minimumFractionDigits: 2,
}).format;

function performanceAmounts(performance) {
  let amount = 0;
  let volumeCredits = Math.max(performance.audience - 30, 0);
  switch (performance.play.type) {
    case "tragedy":
      amount = 40000;
      if (performance.audience > 30) {
        amount += 1000 * (performance.audience - 30);
      }
      break;
    case "comedy":
      amount = 30000;
      if (performance.audience > 20) {
        amount += 10000 + 500 * (performance.audience - 20);
      }
      amount += 300 * performance.audience;
      volumeCredits += Math.floor(performance.audience / 5);
      break;
    default:
      throw new Error(`unknown type: ${performance.play.type}`);
  }
  return { amount, volumeCredits };
}

function buildStatementData(invoice, plays) {
  const result = {
    customer: invoice.customer,
    performances: invoice.performances.map((perf) => {
      const play = plays[perf.playID];
      return {
        ...perf,
        play,
      };
    }),
    lineItems: [],
    values: {
      totalAmount: 0,
      totalVolumeCredits: 0,
    },
  };

  for (let perf of result.performances) {
    const { amount, volumeCredits } = performanceAmounts(perf);
    const item = {
      performance: perf,
      amount: amount,
    };
    result.values.totalAmount += amount;
    result.values.totalVolumeCredits += volumeCredits;
    result.lineItems.push(item);
  }

  return result;
}

function renderStatementData(data) {
  let result = [];
  result.push(`Statement for ${data.customer}`);
  for (let { performance, amount } of data.lineItems) {
    result.push(
      `  ${performance.play.name}: ${formatAmount(amount / 100)} (${
        performance.audience
      } seats)`,
    );
  }
  result.push(`Amount owed is ${formatAmount(data.values.totalAmount / 100)}`);
  result.push(`You earned ${data.values.totalVolumeCredits} credits`);

  return result.join("\n");
}

function statement(invoice, plays) {
  return renderStatementData(buildStatementData(invoice, plays));
}
console.log(statement(invoices[0], plays));
