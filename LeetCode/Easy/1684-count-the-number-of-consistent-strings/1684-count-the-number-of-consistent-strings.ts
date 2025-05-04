function countConsistentStrings(allowed: string, words: string[]): number {
    let result = 0;

    words.forEach(word => {
            if(word.split('').every(alpha => allowed.includes(alpha))){
                result++;
            }
    })
    return result;
};