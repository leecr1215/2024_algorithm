/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
// fn에서 걸리는 시간이 t초 안 쪽일 때는 ok
// 그 이상이면  time exceeded
// 처음 코드
// var timeLimit = function(fn, t) {
//     const ERROR_MESSAGE = "Time Limit Exceeded";
    
//     return async function(...args) {

//         return new Promise(async(resolve, reject)=>{
//             try{
//                 setTimeout(() => {
//                 reject(ERROR_MESSAGE);
//                 }, t);
            
//                 resolve(await fn(...args));
//             }
//             catch(err){
//                 reject(err);
//             }
               
//         });
//     }
// };

var timeLimit = function(fn, t) {
    const ERROR_MESSAGE = "Time Limit Exceeded";
    
    return async function(...args) {
        const promise1 = fn(...args);
        const promise2 = new Promise((resolve, reject)=>{
            setTimeout(()=>{
                reject(ERROR_MESSAGE);
            }, t);
        });
        return Promise.race([promise1, promise2]);
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */