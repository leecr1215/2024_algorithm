function solution(clothes) {
    const map = new Map();
    
    clothes.forEach((row)=>{
        const [name, type] = row;
        
        if(map.has(type)){
            map.set(type, [...map.get(type), name]);
        }else{
            map.set(type, [name]);
        }
        
    });
    
    let result = 1;
    
    for(let type of map.keys()){
        result = result * (map.get(type).length + 1);
    }
    
    return result - 1;
}