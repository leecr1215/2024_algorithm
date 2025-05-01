function maximumWealth(accounts: number[][]): number {
    let result = 0;

    accounts.forEach((account) => {
        let sum = account.reduce((acc, cur) => acc+cur, 0);

        result = Math.max(result, sum);
    });

    return result;
};