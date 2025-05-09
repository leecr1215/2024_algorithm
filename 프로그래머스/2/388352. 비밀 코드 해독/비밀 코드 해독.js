let answer = 0;
function solution(n, q, ans) {
    
    let arr = Array.from({length : n}, (_, idx) => idx+1);
    
    // 만약 ans에서 0인 값이 있다면? 
    // 해당 q 배열에 있는 숫자들은 조합에 포함 X
    ans.forEach((cnt, idx) => {
        if(cnt === 0){
            
            q[idx].forEach((num) => {
                if(arr.includes(num)){
                    arr.splice(arr.indexOf(num), 1);
                }
            })
        }
    })
    
    // arr로 5개 뽑기!
    let picked = new Array(5).fill(-1);
    combination(0, 0, arr, picked, arr.length, q, ans);
    
    return answer;
}

function combination(start, cnt, arr, picked, n, q, ans){
    if(cnt == 5){
        // 조합 완!
        let result = q.every((question, idx)=>{
            let sameCnt = 0;
            question.forEach((num) => {
                if(picked.includes(num)){
                    sameCnt++;
                }
            })
            
            return sameCnt == ans[idx] ? true : false;
        })
        
        if(result) answer++;
        
        return;
    }
    
    for(let i = start; i < n; i++){
        picked[cnt] = arr[i];
        combination(i + 1, cnt + 1, arr, picked, n, q, ans);
    }
}