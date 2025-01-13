// unshift & shift : O(n)
// pop & push : O(1)
function solution(order) {
    let cnt = 0;
    let beltBox = 1;
    
    let subBelt = [];
    
    for(const targetBox of order){
        while(beltBox <= targetBox){
            subBelt.push(beltBox++);
        }
        
        // subBelt의 가장 뒤에 targetBox가 있어야 트럭에 넣는거 가능
        if(subBelt.at(-1) !== targetBox) break;
        
        subBelt.pop();
        cnt++;
        
    }
    
    
    return cnt;
}