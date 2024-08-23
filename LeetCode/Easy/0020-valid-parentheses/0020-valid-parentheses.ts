function isValid(s: string): boolean {
    const stack:Array<string> = [];
    
    const matchBrackets:{[key:string]:string} = {
        ')' : '(',
        ']' : '[',
        '}' : '{'   
    };
    
    
    for(const bracket of s){
        if(bracket in matchBrackets){ // 닫힌 괄호
            if(stack.length === 0) return false;
            if(stack.pop() !== matchBrackets[bracket]) return false;
        }
        else{ // 열린 괄호
            stack.push(bracket);
        }
    }
    
    // 열린 괄호만 남아있을 수도 있음
    return stack.length === 0;
    
    
};

