const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let K, P, N;
rl.on("line", (line) => {
  [K, P, N] = line.split(" ").map(BigInt);
}).on("close", () => {
  let virus = BigInt(K);

  for (let i = 0; i < N; i++) {
    virus = (virus * P) % BigInt(1000_000_007);
  }

  console.log(Number(virus));

  process.exit(0);
});
