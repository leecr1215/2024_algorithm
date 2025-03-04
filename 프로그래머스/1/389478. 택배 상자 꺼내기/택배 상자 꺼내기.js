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
    

    return answer;
}
