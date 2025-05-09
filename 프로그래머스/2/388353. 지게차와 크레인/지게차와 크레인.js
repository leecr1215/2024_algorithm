let OUT = "OUT";

function solution(storage, requests) {
    let n = storage.length;
    let m = storage[0].length;
    
    let containers = Array.from({length : n+2}, () => new Array(m+2).fill(OUT));
    
    for(let i = 0; i < n; i++){
        const temp = storage[i].split("");
        for(let j = 0; j < m; j++){
            containers[i+1][j+1] = temp[j];
        }
    }
    
    requests.forEach((request) => {
        if(request.length == 1){
            // 지게차 이용
            useForkLift(containers, request, n, m);
        }else{
            // 크레인 이용
            useCrane(containers, request[0], n, m);
        }
    
    })
    
   
    // 살아있는 알파벳 개수 세기
    let answer = 0;
    
    for(let i = 1; i <= n; i++){
        for(let j = 1; j <= m; j++){
            if(containers[i][j] != OUT) answer++;
        }
    }
    
    return answer;
}

// 지게차 이용한 출고 요청
function useForkLift(containers, target, n, m){
    const requestCoordinate = []; // 꺼낼 컨테이너 목록의 좌표를 저장
    
    for(let i = 1; i <= n; i++){
        for(let j = 1; j <= m; j++){
            if(containers[i][j] === target){
                // 한 면 이상 외부와 연결됐는지 확인
                let canOut = checkCanOut(i, j, containers, n, m);
                
                if(canOut){
                    requestCoordinate.push([i,j]);
                }
            }
        }
    }

    // 꺼낼 컨테이너 한 번에 꺼내기
    requestCoordinate.forEach((coordinate) => {
        let [x, y] = coordinate;
        
        containers[x][y] = OUT;
    })
    
}

function checkCanOut(x, y, containers, n, m){
    let dx = [-1, 1, 0, 0];
    let dy = [0, 0, -1, 1];
    
    let visited = Array.from({length : n+2}, () => new Array(m+2).fill(false));
    let queue = [[x,y]];
    visited[x][y] = true;
    
    while(queue.length != 0){
        let [x, y] = queue.shift();
        
        for(let d = 0; d < 4; d++){
            let nx = x + dx[d];
            let ny = y + dy[d];
            
            if(nx == 0 || nx == n+1 || ny == 0 || ny == m+1){
                // 밖에 도착!
                return true;
            }
            
            if(nx >= 0 && nx <= n+1 && ny >= 0 && ny <= m+1 && containers[nx][ny] === OUT && !visited[nx][ny]){
                queue.push([nx, ny]);
                visited[nx][ny] = true;
            }
        }
    }
    
    return false;
    
}

// 크레인을 이용한 출고 요청
function useCrane(containers, target, n, m){
     for(let i = 1; i <= n; i++){
        for(let j = 1; j <= m; j++){
            if(containers[i][j] == target){
                containers[i][j] = OUT;
            }
        }
     }
}