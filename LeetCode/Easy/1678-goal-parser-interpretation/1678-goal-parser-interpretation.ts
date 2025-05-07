function interpret(command: string): string {
    // 1. () 변환
    command = command.replaceAll('()', 'o');

    // 2. (al) 변환
    command = command.replaceAll('(al)', 'al');

    return command;
};