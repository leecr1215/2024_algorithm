function solution(data, col, row_begin, row_end) {
    
    // 1. 데이터 정렬
    data.sort((a, b)=>{
        if(a[col-1]==b[col-1]){
            return b[0]-a[0];
        }
        return a[col-1]-b[col-1];
    })
    
    
    let answer = data[row_begin-1].reduce((acc, cur) => acc + (cur % row_begin), 0);
    
    for(let i = row_begin+1; i <= row_end; i++){
        let si = data[i-1].reduce((acc, cur) => acc + (cur % i), 0);
        
        answer = answer ^ si;
    }
    
    
    return answer;
}