function convertDateToBinary(date: string): string {
    return date.split("-").map((decimal) => Number(decimal).toString(2)).join("-");
};