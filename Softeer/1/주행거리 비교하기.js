const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: "OHAI> ",
});

let A;
let B;

rl.on("line", (line) => {
  [A, B] = line.split(" ").map(Number);
}).on("close", () => {
  if (A === B) {
    console.log("same");
  } else if (A > B) {
    console.log("A");
  } else {
    console.log("B");
  }
  process.exit(0);
});
