const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let lines = [];

rl.on("line", (line) => {
  lines.push(line);
}).on("close", () => {
  const [N, K] = lines[0].split(" ").map(Number);
  const scores = lines[1].split(" ").map(Number);

  for (let i = 1; i < N; i++) {
    scores[i] += scores[i - 1];
  }

  for (let i = 0; i < K; i++) {
    const [A, B] = lines[2 + i].split(" ").map((val) => Number(val) - 1);
    const cnt = B - A + 1;
    let sum = 0;
    if (A === 0) {
      sum = scores[B];
    } else {
      sum = scores[B] - scores[A - 1];
    }

    console.log((sum / cnt).toFixed(2));
  }

  process.exit(0);
});
