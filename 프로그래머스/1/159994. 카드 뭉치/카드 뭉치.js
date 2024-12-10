function solution(cards1, cards2, goal) {
    let i = 0;
    let j = 0;
    
    let result = "Yes";
    
    goal.forEach((word) => {
        if(i < cards1.length && cards1[i] === word){
            i++;
        }else if(j < cards2.length && cards2[j] === word){
            j++;
        }else{
            result = "No";
        }
    })
    
    

    return result;
}