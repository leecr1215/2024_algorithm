function solution(new_id) {
    // 1단계
    new_id = new_id.toLowerCase();

    // 2단계
    new_id = new_id.replaceAll(/[^a-z0-9_.-]/g, '');
    
    // 3단계
    new_id = new_id.replaceAll(/\.{2,}/g, '.');
    
    // 4단계
    new_id = new_id.replaceAll(/^\.|\.$/g, '');
    
    // 5단계
    if(new_id.length === 0){
        new_id += 'a';
    }
    
    // 6단계
    if(new_id.length >= 16){
        new_id = new_id.slice(0,15);
        new_id = new_id.replaceAll(/\.$/g, '');
    }
    
    // 7단계
    if(new_id.length <= 2){
        const lastWord = new_id[new_id.length-1];
        new_id += lastWord.repeat(3 - new_id.length);
    }
    
    return new_id;
}