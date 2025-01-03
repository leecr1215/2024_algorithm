function solution(topping) {
    let map1 = new Map();
    let map2 = new Map();
    
    let cnt = 0;
    
    // map1에 모든 토핑을 저장
    for(let i = 0; i < topping.length; i++){
        map1.set(topping[i], map1.get(topping[i]) ? map1.get(topping[i]) + 1 : 1);
    }
    
    // map2에 하나씩 넣어가면서 토핑의 종류 개수 비교
    for(let i = 0; i < topping.length; i++){
        map2.set(topping[i], map2.get(topping[i]) ? map2.get(topping[i]) + 1 : 1);
        
        if(map1.get(topping[i]) > 0){
            map1.set(topping[i], map1.get(topping[i]) - 1);
            
            if(map1.get(topping[i]) === 0) map1.delete(topping[i]);
        }
        
        if(map1.size === map2.size) cnt++;
        
    }
    
    return cnt;
}