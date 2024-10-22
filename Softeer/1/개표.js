const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: "OHAI> ",
});

const lines = [];

rl.on("line", (line) => {
  lines.push(Number(line));
}).on("close", () => {
  let result = "";
  const five = "++++ ";
  const one = "|";

  const n = lines[0];

  lines.splice(1).forEach((line, idx) => {
    const quotient = parseInt(line / 5);
    const remainder = line % 5;

    result += five.repeat(quotient);

    result += one.repeat(remainder);

    if (idx !== n - 1) {
      result += "\n";
    }

    if (quotient !== 0 && remainder === 0) {
      result = result.split("").slice(0, -1).join("");
    }
  });
  console.log(result);
  process.exit(0);
});
