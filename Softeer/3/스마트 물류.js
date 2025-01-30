const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let lines = [];

rl.on('line', (line) => {
  lines.push(line);
}).on('close', () => {
    let [N, K] = lines[0].split(" ").map(Number);
    let arr = lines[1].split("");

    let visited = Array(N).fill(false);


    let cnt = 0;

    arr.forEach((PH, idx) => {
        if(PH === 'H' && !visited[idx]){
            for(let i = idx-K; i <= idx+K; i++){
                if(i < 0 || i >= N) continue;

                if(arr[i] === 'P' && !visited[i]){
                    cnt++;
                    visited[i] = true;
                    visited[idx] = true;
                    break;
                }


            }
        }
    })

    console.log(cnt);


    process.exit(0);
});