/**
몫 3 나머지 4 -> (총 4개의 줄, 제일 윗 줄은 오른쪽 4개 채워진 상태) =

8의 경우, 8 / 6 -> 몫 1 나머지 2 (둘쨋줄의 오른쪽에서 2칸) => 둘째줄

13 / 3 은 몫4 나머지 1
6 / 3은 몫 2 나머지 0

**/
function solution(n, w, num) {
    
    if(n <= w) return 1;
    
    let answer = 0;
    
    const x1 = Math.ceil(n / w);
    let y1 = 0;
    
    if(x1 % 2 == 0){
        y1 = n % w == 0 ? 1 : w + 1 - (n % w);
    }else{
        y1 = n % w == 0 ? w : n % w;
    }
    
    
    const x2 = Math.ceil(num / w);
    let y2 = 0;
    
    if(x2 % 2 == 0){
        y2 = num % w == 0 ? 1 : w + 1 - (num % w);
    }else{
        y2 = num % w == 0 ? w : num % w;
    }
    
    
    answer = x1-x2;
    
    if(x1 % 2 == 0 && y2>=y1 || x1 % 2 != 0 && y2<=y1){
        answer++;
    }
    
    console.log(`(${x1}, ${y1}), (${x2}, ${y2})`);
    
    return answer;
}

function isSameDirection(quotient1, quotient2){
    return (quotient1 % 2 == 0 && quotient2 % 2 == 0) || (quotient1 % 2 != 0 && quotient2 % 2 != 0);
}