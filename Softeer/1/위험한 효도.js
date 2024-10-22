const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: "OHAI> ",
});

let value;

rl.on("line", (line) => {
  value = line.split(" ").map(Number);
}).on("close", () => {
  let [a, b, d] = value;

  let result = 0;

  result += run(a, b, d);

  result += run(b, a, d);

  console.log(result);

  process.exit(0);
});

function run(a, b, d) {
  let result = 0;
  const runCnt = parseInt(d / a);
  const restD = d % a;

  if (runCnt === 0) {
    // 남은 거리가 a보다 적음
    result += d;
  } else if (restD === 0) {
    // 바로 터치 가능
    result += runCnt * a + (runCnt - 1) * b;
  } else {
    result += runCnt * a + runCnt * b;
    d -= runCnt * a;

    // 남은 거리 계산
    result += d;
  }

  return result;
}
