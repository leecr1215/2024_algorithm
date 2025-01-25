function solution(wallpaper) {

    let answer = [50,50,0,0];
    
    wallpaper.forEach((row, i) => {
        row.split('').forEach((col, j) => {
            if(col === '#'){
                if(i < answer[0]){
                    answer[0] = i;
                }
                
                if(i+1 > answer[2]){
                    answer[2] = i+1;
                }
                
                if(j < answer[1]){
                    answer[1] = j;
                }
                
                if(j+1 > answer[3]){
                    answer[3] = j+1;
                }
            }
        })
    });
    return answer;
}