function lengthOfLastWord(s: string): number {
    return s.trim().split(/\s+/g).slice(-1).join('').length;
};