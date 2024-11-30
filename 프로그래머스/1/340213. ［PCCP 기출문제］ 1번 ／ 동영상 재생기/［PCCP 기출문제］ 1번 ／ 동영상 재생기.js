function solution(video_len, pos, op_start, op_end, commands) {
    const videoTime = Number(video_len.slice(0, 2)) * 60 + Number(video_len.slice(-2));
    let curTime = Number(pos.slice(0, 2)) * 60 + Number(pos.slice(-2));
    const opStart = Number(op_start.slice(0, 2)) * 60 + Number(op_start.slice(-2));
    const opEnd = Number(op_end.slice(0, 2)) * 60 + Number(op_end.slice(-2));
    
    curTime = op(curTime, opStart, opEnd);
    
    commands.forEach((command) => {
        if(command === "prev"){
            curTime = prev(curTime);
        }else if(command == "next"){
            curTime = next(curTime, videoTime);
        }
        
        curTime = op(curTime, opStart, opEnd);
        
    })
    
    
    return intToTime(curTime);
}

function intToTime(curTime){
    let m = String(parseInt(curTime / 60));
    let s = String(curTime % 60);
    
    return m.padStart(2, '0') + ':' + s.padStart(2, '0');
}

/**
@param
**/
function prev(pos){
    let result = pos - 10;
    
    if(result < 0){
        result = 0;
    }
    
    return result;
}

function next(pos, videoTime){
    let result = pos + 10;
    
    if(result > videoTime){
        result = videoTime;
    }
    
    return result;
}

function op(pos, opStart, opEnd){
    if(pos >= opStart && pos <= opEnd){
        return opEnd;
    }
    
    return pos;
}