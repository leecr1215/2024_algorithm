function solution(n, words) {
    let result = [0, 0];
    
    // n명의 사람의 턴 수 저장
    const turns = Array(n+1).fill(0);
    
    const set = new Set();
    
    set.add(words[0]);
    turns[1]++;
    
    if(words[0].length <= 1) return [1,1];
    
    for(let i = 1; i < words.length; i++){
        let num = i % n + 1;
        turns[num]++;
        
        if(set.has(words[i]) || words[i].length <= 1 || words[i-1].slice(-1) != words[i][0]){
            result = [num, turns[num]];
            break;
        }
        
        set.add(words[i]);
    }
    

    return result;
}