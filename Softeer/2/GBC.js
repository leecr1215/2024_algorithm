const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let lines = [];

rl.on("line", (line) => {
  lines.push(line);
}).on("close", () => {
  const [N, M] = lines[0].split(" ").map(Number);

  const real = new Array(101).fill(0);

  let idx = 1;

  for (let i = 1; i <= N; i++) {
    const [len, speed] = lines[i].split(" ").map(Number);

    for (let j = 0; j < len; j++) {
      real[idx++] = speed;
    }
  }

  const test = new Array(101).fill(0);
  idx = 1;
  for (let i = 1; i <= M; i++) {
    const [len, speed] = lines[i + N].split(" ").map(Number);

    for (let j = 0; j < len; j++) {
      test[idx++] = speed;
    }
  }

  let max = 0;
  for (let i = 1; i <= 100; i++) {
    let diff = test[i] - real[i];
    if (diff > 0) {
      if (max < diff) {
        max = diff;
      }
    }
  }

  console.log(max);

  process.exit(0);
});
