function solution(n, m, section) {
    let answer = 0;
    
    let idx = 0;
    
    while(idx < section.length){
        let end = section[idx] + m - 1;
        answer++;
        idx++;
        
        
        while(idx < section.length){
            if(section[idx] <= end){
                idx++;
            }
            else{
                break;
            }
        }
        
    }
    
    return answer;
}