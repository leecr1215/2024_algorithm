/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    let n_2 = 0;
    let n_1 = 1;
    
    for(let i = 0; i <= 50; i++){
        if(i === 0) yield n_2;
        if(i === 1) yield n_1;
        
        let n = n_2 + n_1;
        
        n_2 = n_1;
        n_1 = n;
        
        yield n;
            
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */