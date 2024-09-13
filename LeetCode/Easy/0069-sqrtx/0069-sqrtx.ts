function mySqrt(x: number): number {
    let left = 0;
    let right = x;
    
    while(left <= right){
        let mid = Math.floor((left + right) / 2);
        let square = mid * mid;
        
        if(square === x){
            return mid;
        }else if(square < x){
            left = mid + 1;
        }else{
            right = mid - 1;
        }
    }
    
    return right;
    
    
};