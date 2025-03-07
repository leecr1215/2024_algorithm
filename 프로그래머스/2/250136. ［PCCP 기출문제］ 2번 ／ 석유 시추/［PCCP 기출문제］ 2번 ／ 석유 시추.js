// 각 석유 덩어리마다 최소 열 번호, 최대 열 번호, 석유량을 저장
let visited;
function solution(land) {
    let N = land.length;
    let M = land[0].length;
    
    let answer = 0;
    
    visited = Array.from(Array(N), () => Array(M).fill(false));
    
    let oils = [];
    
    for(let i = 0; i < N; i++){
        for(let j = 0; j < M; j++){
            if(!visited[i][j] && land[i][j] == 1){                
                let [minCol, maxCol, amount] = bfs(land, i, j);
                
                oils.push({
                    minCol, maxCol, amount
                });
                
            }
        }
    }

    
    for(let col = 0; col < M; col++){
        let temp = 0;
        
        oils.forEach(oil => {
            if(oil.minCol <= col && oil.maxCol >= col){
                temp += oil.amount;
            }
        })
        
        if(temp > answer){
            answer = temp;
        }
    }
    
    return answer;
}

function bfs(land, r, c){
    let N = visited.length;
    let M = visited[0].length;

    
    let queue = [];
    
    queue.push([r, c]);  
    visited[r][c] = true;
    
    let minCol = c;
    let maxCol = c;
    let amount = 1;
    
    let dx = [-1, 1, 0, 0];
    let dy = [0, 0, -1, 1];
    
    while(queue.length > 0){
        let [x, y] = queue.shift();
        
        for(let i = 0; i < 4; i++){
            let nx = x + dx[i];
            let ny = y + dy[i];
            
            
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && land[nx][ny] == 1){
                
                queue.push([nx, ny]);
                visited[nx][ny] = true;
                
                amount++;
                if(maxCol < ny){
                    maxCol = ny;
                }
                
                if(minCol > ny){
                    minCol = ny;
                }
            }
        }
        
    }
    
    return [minCol, maxCol, amount];
}