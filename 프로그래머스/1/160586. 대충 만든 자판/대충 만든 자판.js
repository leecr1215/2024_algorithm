function solution(keymap, targets) {
    let answer = [];
    
    // 알파벳 : 해당 인덱스
    let obj = {};
    
    keymap.forEach((key, index)=>{
        key.split('').forEach((alpha, idx) => {
            if(obj[alpha]===undefined || obj[alpha] > idx+1) {
                obj[alpha] = idx+1;
            }
        })
        
    })
    
    
    targets.forEach((target) => {
        // target에 대해 cnt
        let cnt = 0;
        let isHave = true;
        
        target.split('').every((alpha)=>{
            if(obj[alpha] === undefined){
                isHave = false;
                return false;
            }

            else{
                cnt += obj[alpha];
                return true;
            }
        });
        
        if(!isHave) {
            cnt = -1;
        }

        answer.push(cnt);
        
    });

    
    
    
    return answer;
}