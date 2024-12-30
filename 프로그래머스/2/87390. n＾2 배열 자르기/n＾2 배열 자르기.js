/**
1 2 3 4
2 2 3 4
3 3 3 4
4 4 4 4

n=3
123/223/333

n=4
1234 2234 3334 4444

n=5
12345 22345 33345 44445 55555

**/

function solution(n, left, right) {
    let answer = [];
    
    let x1 = parseInt(left / n) + 1;
    let y1 = (left % n) + 1;
    
    let x2 = parseInt(right / n) + 1;
    let y2 = (right % n) + 1;
    
    
    
    while(true){
        answer.push(Math.max(x1, y1));
        
        if(x1 == x2 && y1 == y2) break;
        
        y1++;
        
        if(y1 > n){
            x1++;
            y1 = 1;
        }
        
    }
    
    return answer;
}