/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    let n_2 = 0;
    let n_1 = 1;
    
    for(let i = 0; i <= 50; i++){
        yield n_2;
        
        [n_2, n_1] = [n_1, n_2 + n_1];
            
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */