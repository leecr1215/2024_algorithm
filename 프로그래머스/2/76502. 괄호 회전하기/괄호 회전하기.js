function solution(s) {
    let cnt = 0;
    
    for(let x = 0; x < s.length; x++){
        // x칸 만큼 왼쪽으로 회전
        let newS = rotate(s, x);
        
        if(isRight(newS)){
            cnt++;
        }
    }
    
    return cnt;
}

function isRight(s){
    let check = true;
    let stack = [];
    
    for(let i = 0; i < s.length; i++){
        if(s[i] === '[' || s[i] === '(' || s[i] === '{'){
            // 열린 괄호
            stack.push(s[i]);
        }else{
            // 닫힌 괄호
            
            if(stack.length == 0 || getCloseBracket(stack[stack.length - 1]) !== s[i]){
                // 올바르지 않은 괄호
                check = false;
                break;
            }else {
                // 올바른 괄호
                stack.pop();
            }
        }
    }
    
    if(stack.length !== 0){
        check = false;
    }
    
    return check;
}

function getCloseBracket(bracket){
    if(bracket === '('){
        return ')';
    }else if(bracket === '['){
        return ']';
    }else{
        return '}';
    }
}

function rotate(s, x){
    return s.slice(x) + s.slice(0, x);
}