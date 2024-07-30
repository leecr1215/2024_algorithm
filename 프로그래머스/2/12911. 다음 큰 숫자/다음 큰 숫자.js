function solution(n) {
    let answer = 0;

    const cnt = n.toString(2).split('1').length - 1;
    
    
    while(true){
        n++;
        if(n.toString(2).split('1').length - 1 === cnt){
            answer = n;
            break;
        }
    }
    
    return answer;
}