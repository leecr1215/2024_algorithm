/**
* today : String
* terms : String[]
* privacies : String[]
*
**/
function solution(today, terms, privacies) {
    const result = [];
    const termsObj = {};
    
    const [tYear, tMonth, tDay] = today.split('.').map(Number);
    
    // terms 배열을 객체로 변경
    terms.forEach((term)=>{
        const [type, validate] = term.split(' ');
        termsObj[type] = Number(validate);
    });
    
    privacies.forEach((privacy, idx)=>{
        const [term, type] = privacy.split(' ');
        let [year, month, day] = term.split('.').map(Number);
        
        month += termsObj[type];
        
        if(month > 12) {
            month -= 12;
            year++;
        }
        
        if(new Date(tYear, tMonth, tDay) >= new Date(year, month, day)){
            result.push(idx+1);
        }
        
    });
    
    
          
    return result;
}