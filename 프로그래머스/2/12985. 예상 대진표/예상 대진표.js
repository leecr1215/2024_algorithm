function solution(n,a,b)
{
    let answer = 0;
    while(true){
        a = Math.round(a / 2); // a가 대결하는 그룹
        b = Math.round(b / 2); // b가 대결하는 그룹
        answer++;
        
        if(a === b) break;
        
    }
    
    return answer;
}