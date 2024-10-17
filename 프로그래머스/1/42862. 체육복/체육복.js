function solution(n, lost, reserve) {
   // 여벌 체육복을 가져온 학생이 도난당했을 때 reserve와 lost에서 제거
    let deleteStudent = [];
    lost.forEach((lostNum) => {
        const idx = reserve.indexOf(lostNum);
        if(idx !== -1){
            deleteStudent.push(lostNum);
        }
    })
    
    deleteStudent.forEach((d) => {
        reserve.splice(reserve.indexOf(d), 1);
        lost.splice(lost.indexOf(d), 1);
    })
    
    reserve.sort((a, b) => a-b);
    
    reserve.forEach((student) => {
        if(lost.indexOf(student-1) !== -1){
            lost.splice(lost.indexOf(student-1), 1);
        }
        else if(lost.indexOf(student+1) !== -1){
            lost.splice(lost.indexOf(student+1), 1);
        }
    })
    
    return n - lost.length;
}