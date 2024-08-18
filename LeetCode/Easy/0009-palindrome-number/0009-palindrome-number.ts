function isPalindrome(x: number): boolean {
    const str = String(x);
    
    const checkIdx:number = parseInt(str.length / 2 + '');
    
    for(let i = 0; i < checkIdx; i++){
        if(str[i] !== str[str.length-1-i]) return false;
    
    }
    
    return true;
};