function minBitFlips(start: number, goal: number): number {
    return (start ^ goal).toString(2).split('').reduce((acc, cur) => cur == '1' ? acc+1 : acc, 0);
};

