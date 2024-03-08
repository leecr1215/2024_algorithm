/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function*(arr) {
    const flatArr = arr.flat(Infinity);
    
    console.log(flatArr);
    
    for(let element of flatArr){
        yield element;
    }
    
    // flatArr.forEach((element)=>{
    //     yield element;
    // });
};

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */