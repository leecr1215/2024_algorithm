function solution(participant, completion) {
    
    let participantObj = {};
    let completionObj = {};
    
    participant.forEach((name) => {
       participantObj[name] = participantObj[name] ? participantObj[name]+1 : 1;
    })
    
    completion.forEach((name) => {
       completionObj[name] = completionObj[name] ? completionObj[name]+1 : 1;
    })
    
    
    for(let name in participantObj){
        if(participantObj[name] !== completionObj[name]){
            return name;
        }
    }
    
}