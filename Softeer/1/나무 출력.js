const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: "OHAI> ",
});

rl.on("line", (line) => {}).on("close", () => {
  console.log(`           *********           
      *****         ****       
    **                  **     
   *                      *    
 **                        **  
*                            * 
*                            * 
**                          ** 
 **  *    ****  ****    *  **  
   ** ***** ****** ***** **    
             ****              
             ****              
             ****              
             ****              
            ******             
           ********`);
  process.exit(0);
});
