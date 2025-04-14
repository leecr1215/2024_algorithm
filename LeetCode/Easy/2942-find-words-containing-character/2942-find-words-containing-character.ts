function findWordsContaining(words: string[], x: string): number[] {
    let answer = [];

    words.forEach((word, idx) => {
        if(word.includes(x)){
            answer.push(idx);
        }
    })

    return answer;
};