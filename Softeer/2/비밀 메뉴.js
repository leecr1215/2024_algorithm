const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let lines = [];
rl.on("line", (line) => {
  lines.push(line);
}).on("close", () => {
  const [M, N, K] = lines[0].split(" ").map(Number);
  const secret = lines[1].split(" ").join("");
  const buttons = lines[2].split(" ").join("");

  if (buttons.indexOf(secret) !== -1) {
    console.log("secret");
  } else {
    console.log("normal");
  }

  process.exit(0);
});
