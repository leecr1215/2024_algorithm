
// 누적합으로 하면?
// [7,9,1,1,4,7,9,1,1,4]
// [7,16,17,18,22,29,38,39,40,44]


// [0, 7, 16, 17, 18, 22, 29, 38, 39, 40, 44]
// [0, 7, 16, 17, 18, 22]
// [0, 4, 5, 6, 15, 22]
function solution(elements) {
    let DOUBLE_LEN = elements.length * 2;
    
    let doubleElements = [...elements, ...elements];
    let sum = Array(DOUBLE_LEN + 1).fill(0);
    
    for(let i = 1; i <= DOUBLE_LEN; i++){
        sum[i] = sum[i-1] + doubleElements[i-1];
    }
    
    let set = new Set();
    
    for(let i = 1; i <= elements.length; i++){
        // 길이가 i인 연속 부분 수열의 합을 구해서 set에 저장
        for(let j = i; j <= DOUBLE_LEN; j++){
            let temp = sum[j] - sum[j-i];
            
            set.add(temp);
        }
    }
    
    
    return set.size;
}