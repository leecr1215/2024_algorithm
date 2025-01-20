function solution(numbers) {
    let answer = [];
    
    numbers.forEach((num) => {
        answer.push(f(num));
    })
    
    return answer;
}


function f(number){
    let binaryNum = number.toString(2);
    let len = binaryNum.length;
    let changeIdx = binaryNum.lastIndexOf('0');
    
    
    if(changeIdx == -1){
        // 모두 1로 차있는 상황
        binaryNum = '10'+binaryNum.slice(1);
    }else{
        // changeIdx 부분을 1로 변경
        binaryNum = binaryNum.slice(0, changeIdx) + 1 + binaryNum.slice(changeIdx+1);
    }
    
    if(changeIdx != len-1 && changeIdx != -1) {
        binaryNum = binaryNum.slice(0, changeIdx+1) + 0 + binaryNum.slice(changeIdx+2);
    }

    
    return parseInt(binaryNum, 2);
}