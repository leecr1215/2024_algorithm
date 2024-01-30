// " " : 공백
// "#" : 벽
// 둘 다 공백이면 전체 지도에서도 공백
// 하나라도 벽이 있으면 전체 지도에서도 벽
function solution(n, arr1, arr2) {
    const map = [];
    arr1.forEach((num1, idx)=>{   
        map.push((num1 | arr2[idx]).toString(2).padStart(n, '0').replaceAll('1', '#').replaceAll('0', ' '));  
    });
    return map;
}
