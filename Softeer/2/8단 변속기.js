const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: "OHAI> ",
});

let nums;
rl.on("line", (line) => {
  nums = line.split(" ").map(Number);
}).on("close", () => {
  let isAscending = true;

  for (let i = 0; i < 7; i++) {
    if (nums[i + 1] !== nums[i] + 1) {
      isAscending = false;
      break;
    }
  }

  if (isAscending) {
    console.log("ascending");
  } else {
    let isDescending = true;

    for (let i = 0; i < 7; i++) {
      if (nums[i + 1] !== nums[i] - 1) {
        isDescending = false;
        break;
      }
    }

    if (isDescending) {
      console.log("descending");
    } else {
      console.log("mixed");
    }
  }

  process.exit(0);
});
