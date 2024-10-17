// 24.10.17
let visited;
function solution(n, computers) {
    let answer = 0;
    
    visited = Array(n).fill(false);
    
    for(let i = 0; i < n; i++){
        if(!visited[i]){
            bfs(i, computers);
            answer++;
        }
    }
    
    
    return answer;
}

function bfs(idx, computers) {
        visited[idx] = true;
        let queue = [];
        queue.push(idx);    
    
        while(queue.length != 0) {
            const computer = queue.shift();
            
            computers[computer]?.forEach((c, i) => {
                if(computer !== i && !visited[i] && c === 1){
                    queue.push(i);
                    visited[i] = true;
                }
            })
        }
    }