function solution(files) {
    
    files.sort((a, b) => {
        let match_A = a.match(/\d{1,5}/);
        let match_B = b.match(/\d{1,5}/);
        
        
        let HEAD_A = a.slice(0, match_A.index).toUpperCase();
        let HEAD_B = b.slice(0, match_B.index).toUpperCase();
        
        let NUMBER_A = match_A[0];
        let NUMBER_B = match_B[0];
        
        if(HEAD_A === HEAD_B){
            return Number(NUMBER_A) - Number(NUMBER_B);
        }
                      
        return HEAD_A.localeCompare(HEAD_B);
    });
    
    return files;
}