/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    
    const isEqual = (val, target) => {
        return val === target;
    }
    
    const ERROR_MESSAGE = {
        toBe: "Not Equal",
        notToBe: "Equal",
    }

    return {
        toBe: function (target){
            if(isEqual(val, target)) return true;
            throw new Error(ERROR_MESSAGE.toBe);
        },
        notToBe: function (target){
            if(!isEqual(val, target)) return true;
            throw new Error(ERROR_MESSAGE.notToBe);
        },
    }
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */