
const fs = require('fs')//ye file system module hai organise main use hoga 
const path = require('path')//ye path dega eek jagah se dusre jagah jane ke ley
//tree function

function treeFn(dirpath) {  //directory path aaega(test folder)
    if (dirpath == undefined) {     //check karega ki directory path sahi hai ya nhi
      console.log("Please enter a valid Path");
    } else {
      let doesExist = fs.existsSync(dirpath); //ye check karega ye dirpath exist karta hai ya nhi return true and false
      if (doesExist==true) {   
        treeHelper(dirpath, " "); //ye function tree ki form main organize karne main help karega
      }                          //directory path aaega isme and indent(spaces) aaegi
    }
  }
  
  //ye hai tree function jo main kaam karega
  function treeHelper(targetPath, indent) { //ye target path directory path he hai //anf indent spaces ke ley
    let isFile = fs.lstatSync(targetPath).isFile(); //ye check karega ye target path file hai ya nhi
  
    if (isFile == true) {   //aaagr file hai to aaise  aarange karenge ya chalega
      let fileName = path.basename(targetPath); //basename lenge pehle
      console.log(indent + "├──" + fileName);
    }
     else { //aaagr folder hua to aaise arrange karenge ya chalega
      let dirName = path.basename(targetPath); //directory ka base name
      console.log(indent + "└──" + dirName);
  //ye childen directory(folder) ke ander ki files ko read karega
      let children = fs.readdirSync(targetPath);//files ko read karega
  
      for (let i = 0; i < children.length; i++) { //aaagr chalega files per
        let childPath = path.join(targetPath, children[i]);//ye path join karega folder ko files se 
        treeHelper(childPath, indent + "\t");//recussion karenge taaaki aaagr folder ke ander bhi folder ho to 
                                             //to usper bhi tree chale
      }
    }
  }
  

module.exports={
    treeKey : treeFn
}