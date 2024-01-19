/**
 * @param {Function[]} functions
 * @return {Function}
 */

Array.prototype.myReverse = function(){
    return this.map((item,idx) => this[this.length-1-idx]);
}

var compose = function(functions) {
    
    return function(x) {
        let value = x;
        
        functions.myReverse().forEach((fn)=>{
            value = fn(value);
        });
        
        return value;
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */