const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: "OHAI> ",
});

const lines = [];

rl.on("line", (line) => {
  lines.push(line);
}).on("close", () => {
  let result = 0;

  lines.forEach((line) => {
    const [time1, time2] = line.split(" ");

    let [hour1, minute1] = time1.split(":").map(Number);
    minute1 += hour1 * 60;

    let [hour2, minute2] = time2.split(":").map(Number);
    minute2 += hour2 * 60;

    result += minute2 - minute1;
  });

  console.log(result);

  process.exit(0);
});
