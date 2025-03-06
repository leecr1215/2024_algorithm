function solution(schedules, timelogs, startday) {
    let peopleCnt = schedules.length;
    let answer = schedules.length;
    
    for(let i = 0; i < peopleCnt; i++){
        let hour = parseInt(schedules[i] / 100);
        let minute = schedules[i] % 100 + 10;
        
        if(minute >= 60){
            hour += 1;
            minute -= 60;
        }
        
        
        for(let j = 0; j <= 6; j++){
            if(isWeekend(j + startday)) continue;
            
            let curHour = parseInt(timelogs[i][j] / 100);
            let curMinute = timelogs[i][j] % 100;
            
            
            if(hour < curHour || hour === curHour && minute < curMinute) {
                answer--;
                break;
            }
        }
    }
    
    return answer;
}

function isWeekend(day){
    if(day > 7){
        day -= 7;
    }
    
    return day == 6 || day == 7;
}