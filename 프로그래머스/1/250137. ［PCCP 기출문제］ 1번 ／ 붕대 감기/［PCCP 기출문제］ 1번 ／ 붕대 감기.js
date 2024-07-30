function solution(bandage, health, attacks) {
    
    // 몬스터의 마지막 공격 시각
    const lastAttackTime = attacks[attacks.length - 1][0];
    
    const attackTimes = attacks.map((attack) => attack[0]); // 공격 시각들
    
    let curHealth = health; // 현재 체력
    let continueSuccess = 0; // 연속 성공 횟수
    
    const monsterAttackTimeIndex = (attackTimes, curTime) => {
        return attackTimes.indexOf(curTime);
    }
    
    for(let i = 0; i <= lastAttackTime; i++){
        const monsterIdx = monsterAttackTimeIndex(attackTimes, i);
        
        // 몬스터의 공격 타이밍인지 확인
        if(monsterIdx != -1){ // 지금 공격 타이밍이라는 소리!
            // 체력 감소
            curHealth -= attacks[monsterIdx][1];
            
            // 연속 성공 초기화
            continueSuccess = 0;
            
            // 만약 체력이 0 이하면 바로 break            
            if(curHealth <= 0){
                break;
            }
            
        }
        else{
            // 공격 타이밍이 아닌 경우
            // 체력 회복
            curHealth += bandage[1];
            
            // 연속 성공 증가
            continueSuccess++;
            
            // 최대 health 만큼 가능
            if(curHealth > health) curHealth = health;
            
        }
        
        // 연속 성공 횟수가 시전 시간이 되면 
        if(continueSuccess === bandage[0]){
            
            // 체력 추가 회복
            curHealth += bandage[2];            
            
            // 최대 health 만큼 가능
            if(curHealth > health) curHealth = health;
            
            // 연속성공 초기화
            continueSuccess = 0;
            
        }
    }
    
    
    return curHealth <= 0 ? -1 : curHealth;
}