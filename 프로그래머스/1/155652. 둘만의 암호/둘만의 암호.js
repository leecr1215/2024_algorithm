function solution(s, skip, index) {
    
    
    let ZCODE = 'z'.charCodeAt();
    let ACODE = 'a'.charCodeAt();
    
    return s.split("").map((alpha)=>{
        let charCode = alpha.charCodeAt();
        let cnt = index;
        
        while(cnt > 0){
            charCode++;
            
            if(charCode > ZCODE){
                charCode = ACODE;
            }
            
            if(!skip.includes(String.fromCharCode(charCode))){
                cnt--;
            }
        }
        
        return String.fromCharCode(charCode);
    }).join("");
    
}