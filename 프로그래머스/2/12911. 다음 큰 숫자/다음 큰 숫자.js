function solution(n) {
    let answer = 0;
    
    const binaryN = n.toString(2);
    const cnt1 = binaryN.split('1').length - 1;
    
    
    while(true){
        n++;
        if(n.toString(2).split('1').length - 1 === cnt1){
            answer = n;
            break;
        }
    }
    
    return answer;
}