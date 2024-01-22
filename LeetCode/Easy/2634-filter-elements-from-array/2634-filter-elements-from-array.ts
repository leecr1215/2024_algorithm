type Fn = (n: number, i: number) => any

function filter(arr: number[], fn: Fn): number[] {
    let newArr = [];
    
    arr.forEach((number, idx)=>{
        if(fn(number, idx)){
            newArr.push(number);
        }
    });
    
    return newArr;
};