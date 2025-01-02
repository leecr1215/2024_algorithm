function solution(cacheSize, cities) {
    let cache = [];
    
    let time = 0;
    
    if(cacheSize === 0) return cities.length * 5;
    
    cities.forEach((city) => {
        let CITY = city.toUpperCase();
        
        let idx = cache.indexOf(CITY);
        
        if(idx >= 0){ // 현재 캐시에 있음
            time += 1;
            
            cache.splice(idx, 1);
            cache.push(CITY);
             
        }else{  // 현재 캐시에 없음
            time += 5;
            
            if(cache.length >= cacheSize){
               // 기존에 있던 가장 오래된 city 빼기
                cache.shift();
            }
            
            cache.push(CITY);
        }

    });
    
    return time;
}