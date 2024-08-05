/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        const arr = Array(functions.length);
        
        let solveCnt = 0;
        
        functions.forEach((promise, idx)=>{
            promise()
            .then((value) => {
                arr[idx] = value;
                solveCnt++;

                if(solveCnt === functions.length){
                    resolve(arr);
                }
            })
            .catch((err) => {
                reject(err);
            });
        });
        
        
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */