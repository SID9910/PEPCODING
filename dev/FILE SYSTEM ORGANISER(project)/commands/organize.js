

const fs = require('fs')//ye file system module hai organise main use hoga 
const path = require('path')//ye path dega eek jagah se dusre jagah jane ke ley
//organise function

function organizeFn(dirpath) {               //directory path
    //1.input of a directory path
    if (dirpath == undefined) {                   //directory path aaagr undefined ho                 
      console.log("please enter a directory path")
    }
    else {
      let doesExist = fs.existsSync(dirpath)  //ye function pehle paada hai aaagr exist karegi to true aaega
      //nhi to false aaega
      // console.log(doesexist) //dekh sakte ho
  
      if (doesExist == true) { //jaise he file exist karegi uper check karne ke baad hoga kya ki eek folder.
        // aandar banana padega
        //2 . create a Organized files Directory
        destPath = path.join(dirpath, 'organized_files'); //ye eek folder aandar join karega test folder ke sath organise ko
        //dirpath ->C:\dev\test folder\organized_files
  
        //aaagr aander destpath (organised folder)exist nhi karega to ye eek create kar dega
        //destpath false hoga mtlb nhi karta pehle se exist so isse false kar .eek aanader create kar denge organised folder.
        //test folder ke ander             
        if (fs.existsSync(destPath) == false) {
          fs.mkdirSync(destPath); // we will only creata a directory(organised folder) in test folder if it does not exist
        } else {
          console.log("The Folder Already Exists"); //true hua to folder pehle se exist karta hai
        }
      } else {
        console.log("Please enter a valid Path");//dest path nhi karega exit to ye aaega
      }
  
    }
    //ye organizehelper hamari files ko arrange karaega
    organizeHelper(dirpath,destPath); //source dena padega and destination(organised file)
  
  }
  
  function organizeHelper(src, dest) {
    let childNames = fs.readdirSync(src);//ye readdirSync source file(dirpath=testfolder)ko read karega ki konsi konsi files hai aander
    //test folder(source) ke ander
    // console.log(childname) //aaagr dekhna hai to uncomment karke dekh lo
  
  
    for (let i = 0; i < childNames.length; i++) { //childNames.length ke files ko traverse karega folder ke ander
  
      let childAddress = path.join(src, childNames[i]);//ye  jakar source file ke ander path ko link karega sab files se  
  
      let isFile = fs.lstatSync(childAddress).isFile();//ye check karega ki folder to nhi hai aaagr file hogi to true pass karega 
      //nhi to false karega aaagr folder hua to
  
      if (isFile == true) {  //file hui to true pass karega
        let fileCategory = getCategory(childNames[i]);
        console.log(childNames[i] + "  belongs to  " + fileCategory);//ye files point karega jis category main vo belong karti hai
        //childname as jpg,docx, belongs to file category  media,archieve,photos aaise
        sendFiles(childAddress, dest, fileCategory);//ye main function kaam karega ki konsi file kha se kha bedghni hai
                                          //like .jpg(childaddress)->  destination(organised files)->filecategory(media/documents,etc)
  
      }
    }
  
    }
    //ye category ko arrange karega
    function getCategory(name) {//idher childname pass hoga jis se pta chalega ki konsi file ko kha arrange karna haoi
      let ext = path.extname(name); //ye file ka extention niklane ke ley use hota hai
      // console.log(ext)
      ext = ext.slice(1); //.txt,.docx,.jpg in sab se dot hata dega
      //console.log(ext)
  
      //for in loop
      //ye types ke ander ke typer per jaega
      for (let type in types) { //ye uper jo type ka object banaya hai usme sab aander jakar sab array ko traverse karega type by type 
        let cTypeArr = types[type]; //ye ctype (category type hai) like mdeis,archieve,documents ye sab Ctype main aaega
        //console.log(cTypeArr) aaagr types dekhna hi
        for (let i = 0; i < cTypeArr.length; i++) {
          if (ext == cTypeArr[i]) { //aagr extension koi category se match karega to type return kardo
            //like .jpg(extension)belongs to documents(type) and return Type
  
            // we matched the extension
            return type; // we returned types of the file 
          }
        }
      }
      return "others";
  
    }
  
  //ye he files ko idher se udher kar kar organised files(destination ) main karega send.
    function sendFiles(srcFilePath, dest, fileCategory) {
      //catpath=category path
      let catPath = path.join(dest, fileCategory);//destination(organised files) ko link kardo filecategory se(media ,documents,archieve) 
  //examples-
      //D:\FJP2 Dev\test folder\organized_files\media
      //D:\FJP2 Dev\test folder\organized_files\documents
      //D:\FJP2 Dev\test folder\organized_files\app
      //D:\FJP2 Dev\test folder\organized_files\archives
  
      //ye check karega ki categorypath false hua to eek directory create kardo
      if (fs.existsSync(catPath) == false) {
        fs.mkdirSync(catPath);
      }
  
      //ye filename ka name bataega jpg,text,etc
      let fileName = path.basename(srcFilePath);
  
      //ye link karega organised folder ko file name se 
      let destFilePath = path.join(catPath, fileName);
  
      //example-
      //D:\FJP2 Dev\test folder\organized_files\media\test.mp4
  
  
      //ye copy karega source file ko destination taak
      //example-jpg,text,exe ,etc to organised files
      fs.copyFileSync(srcFilePath, destFilePath); // copyFileSync is used to copy files from source to dest
      fs.unlinkSync(srcFilePath); // unlinkSync is used to remove files from outside the orgnaised folder 
                                 //jo pehle thi use bahar jo thi
      
    console.log(fileName + " copied to " + fileCategory); //ye console bta dega konsi file kha jaegi idher se udher                           
  
    }
  
  
    module.exports= {
        organizeKey : organizeFn
 }  