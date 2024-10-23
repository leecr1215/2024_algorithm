const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: "OHAI> ",
});

let lines = [];

const lights = {
  "*": [0, 0, 0, 0, 0, 0, 0], // 빈칸
  0: [1, 1, 1, 0, 1, 1, 1],
  1: [0, 0, 1, 0, 0, 0, 1],
  2: [0, 1, 1, 1, 1, 1, 0],
  3: [0, 1, 1, 1, 0, 1, 1],
  4: [1, 0, 1, 1, 0, 0, 1],
  5: [1, 1, 0, 1, 0, 1, 1],
  6: [1, 1, 0, 1, 1, 1, 1],
  7: [1, 1, 1, 0, 0, 0, 1],
  8: [1, 1, 1, 1, 1, 1, 1],
  9: [1, 1, 1, 1, 0, 1, 1],
};

rl.on("line", (line) => {
  lines.push(line);
}).on("close", () => {
  const T = lines[0];

  lines.slice(1).forEach((line) => {
    const [A, B] = line.split(" ");

    const arrA = A.padStart(5, "*").split("");
    const arrB = B.padStart(5, "*").split("");

    let result = 0;

    arrA.forEach((a, idx) => {
      result += lightChange(a, arrB[idx]);
    });

    console.log(result);
  });

  function lightChange(a, b) {
    if (a === b) {
      return 0;
    }

    let cnt = 0;

    for (let i = 0; i < lights[a].length; i++) {
      if (lights[a][i] != lights[b][i]) {
        cnt++;
      }
    }

    return cnt;
  }

  process.exit(0);
});
