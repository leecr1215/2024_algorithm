/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    
    const isEqual = (val, target) => {
        return val === target;
    }
    
    const ERROR_MESSAGE = {
        TO_BE: "Not Equal",
        NOT_TO_BE: "Equal",
    }

    return {
        toBe: function (target){
            if(isEqual(val, target)) return true;
            throw new Error(ERROR_MESSAGE.TO_BE);
        },
        notToBe: function (target){
            if(!isEqual(val, target)) return true;
            throw new Error(ERROR_MESSAGE.NOT_TO_BE);
        },
    }
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */