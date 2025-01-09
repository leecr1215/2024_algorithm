class Node {
    constructor(num, cnt){
        this.num = num;
        this.cnt = cnt; // 연산의 횟수
    }
}

function solution(x, y, n) {

    
    let result = bfs(x, y, n);
    
    return result;
}

function bfs(x, y, n){
    let queue = [new Node(y, 0)];
    let visited = {};
    visited[y] = true;
    
    while(queue.length){
        let node = queue.shift();
        
        if(node.num === x) return node.cnt;
        
        let nextNum1 = node.num - n;
        let nextNum2 = node.num / 2;
        let nextNum3 = node.num / 3;
        
        if(nextNum1 >= x && !visited[nextNum1]){
            queue.push(new Node(nextNum1, node.cnt + 1));
            visited[nextNum1] = true;
        }        
        
        if(node.num % 2 === 0 && nextNum2 >= x && !visited[nextNum2]){       
            queue.push(new Node(nextNum2, node.cnt + 1));
            visited[nextNum2] = true;
        }
       
        if(node.num % 3 === 0 && nextNum3 >= x &&  !visited[nextNum3]){
            queue.push(new Node(nextNum3, node.cnt + 1));
            visited[nextNum3] = true;
        }
    }
    
    return -1;
    
}