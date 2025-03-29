function numJewelsInStones(jewels: string, stones: string): number {
        let stonesCnt = {};
        
        stones.split("").forEach((stone) => {
            if(stonesCnt[stone]){
                stonesCnt[stone] += 1;
            }else{
                stonesCnt[stone] = 1;
            }
        });

        let answer = 0;

        jewels.split("").forEach((jewel) => {
            answer += stonesCnt[jewel] ?? 0;
        })

        return answer;
};