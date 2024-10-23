const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: "OHAI> ",
});

let lines = [];

rl.on("line", (line) => {
  lines.push(line);
}).on("close", () => {
  const N = Number(lines[0]);
  const treeMax = lines[1]
    .split(" ")
    .map(Number)
    .sort((a, b) => b - a);
  const treeMin = lines[1]
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);
  console.log(Math.max(treeMax[0] * treeMax[1], treeMin[0] * treeMin[1]));

  process.exit(0);
});
