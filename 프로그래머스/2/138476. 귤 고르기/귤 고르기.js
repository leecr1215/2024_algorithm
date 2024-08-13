function solution(k, tangerine) {
   // 각 귤의 크기별 개수 저장하기
    let tangerinCnt = new Map();
    
    tangerine.forEach((t) => {
        tangerinCnt.set(t, tangerinCnt.get(t) ? tangerinCnt.get(t) + 1 : 1);
    });
    
    // 크기 별 귤 개수 오름차순 정렬
    const sortArr = [...tangerinCnt].sort((a, b) => b[1]-a[1]);
    
    tangerinCnt = new Map(sortArr);
    
    let typeCnt = 0; // 귤 종류의 개수
    let sum = 0; // 한 상자에 담은 귤의 개수
    
    for(let [type, cnt] of tangerinCnt){
        // 상자에 담기
        sum += cnt;
        typeCnt++;
        
        
        if(sum >= k) break;
    }
    
    
   return typeCnt;
    
    
}