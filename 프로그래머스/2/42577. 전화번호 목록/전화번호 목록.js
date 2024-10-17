// 2024.10.17

function solution(phone_book) {
    const sortPhoneBook = phone_book.sort(); // 문자열 순서대로 정렬
    const hasPrefix = sortPhoneBook.some((num, idx, arr)=>arr[idx+1]?.indexOf(num) === 0);
    
    return !hasPrefix;
}