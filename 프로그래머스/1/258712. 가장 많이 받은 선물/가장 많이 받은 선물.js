// 1. 선물 주고 받은 기록이 있음.
//  - 다음 달에 선물 적게 받은 사람이 선물 받음.
// 2. 선물 주고 받은 기록 x거나 같음.
//  - 다음 달에 선물 지수 더 큰 사람이 선물 받음.
//  - 선물 지수 : 내가 준 선물 수 - 받은 선물 수
//  - 선물 지수도 같으면 다음 달에 선물 주고 받지 않음.
function solution(friends, gifts) {
    const presentHistory = {}; // key : 준 사람, value : {"받은 사람 이름": 개수}
    const total = {};
    
    friends.forEach((friend) => {
        presentHistory[friend] = {};
        
        friends.forEach((friend2)=>{
            presentHistory[friend][friend2] = 0;
        })
        
        total[friend] = {cnt: 0, nextMonth: 0}; // 선물 지수, 다음 달 받을 선물 개수
    });
    
    gifts.forEach((gift) => {
        const [A, B] = gift.split(' ');
        
        presentHistory[A][B] = presentHistory[A][B] ? presentHistory[A][B] + 1 : 1;
        
        // 선물 지수 계산
        total[A]["cnt"] += 1
        total[B]["cnt"] -= 1;
        
    })
  
    for(const [key, value] of Object.entries(presentHistory)){
        const recipients = Object.keys(value);
        
        
        recipients.forEach((recipient) => {
           
            if(presentHistory[key][recipient] !== -1){
                // 처음 확인하는 선물
            const fromA = presentHistory[key][recipient]; // A가 B에게 준 선물의 개수
            const fromB = presentHistory[recipient][key]??0; // B가 A에게 준 선물의 개수
            
            if(fromA === fromB || (fromA === 0 && fromB === 0)){
                // 둘이 같은 개수를 주고 받거나 주고 받은 기록이 없음
                const cntA = total[key]["cnt"]; //  A의 선물 지수
                const cntB = total[recipient]["cnt"]; // B의 선물 지수
                
                if(cntA > cntB){
                    // 선물 지수가 큰 A가 선물을 받음
                    total[key]["nextMonth"] += 1;
                }else if(cntA < cntB){
                    // 선물 지수가 큰 B가 선물을 받음
                    total[recipient]["nextMonth"] += 1;
                }
            }else if(fromA > fromB){
                // A가 더 많이 줌. A가 다음 달 선물 받음
                total[key]["nextMonth"] += 1;
            }else if(fromA < fromB) {
                // B가 더 많이 줌. B가 다음 달 선물 받음.
                total[recipient]["nextMonth"] += 1;
            }
            // A와 B의 선물 관계를 이미 확인했다고 체크하기
               
                    
            presentHistory[recipient][key] = -1;
            presentHistory[key][recipient] = -1;
                
    
            }
        });
       
    }
    
    let maxNextMonth = 0;
    for(let name in total){
        if(maxNextMonth < total[name]["nextMonth"]){
            maxNextMonth = total[name]["nextMonth"];
        }
    }
    
    
    return maxNextMonth;
}