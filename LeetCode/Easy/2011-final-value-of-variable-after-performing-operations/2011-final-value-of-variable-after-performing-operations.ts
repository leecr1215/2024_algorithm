function finalValueAfterOperations(operations: string[]): number {
    return operations.reduce((acc, operation) => operation.includes('+') ? acc + 1 : acc - 1, 0);
};