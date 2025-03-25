function differenceOfSums(n: number, m: number): number {
    let arr = Array.from(Array(n), (_, idx) => idx+1);

    let num1 = arr.filter((num)=>num%m!=0).reduce((acc, cur) => acc+cur, 0);
    let num2 = arr.filter((num)=>num%m==0).reduce((acc, cur) => acc+cur, 0);

    return num1 - num2;
};