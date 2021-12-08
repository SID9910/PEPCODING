                    //topic-fsmodule(file system module) inbuilt module

  //node module are used ton perform different tasks are required
  //file system module-
  //1.we will bw readin,writing,updating,deleting files from our script
  

  //reading a file
//  const fs=require('fs')

  //let content=fs.readFileSync('f1.txt')//readfilesync is a method to read a file f1.txt
  //console.log('this is f1 data->'+content)


  //writing a file
  //writwsync method is used to put data(write) a file
  //oif a file doesnt exist it creates a new file and write to it
//fs.writeFileSync('f2.txt','hello from f2') 
//f2 ko likha hamne aapne aap iski txt create ho gai // hamne nhi create kari write ke through create ho gai

//aaagr f1.txt pass karta taab pura data change ho jata f1.txt ka


//append a file(means update karna data ho)
//append file sync adds data to the previously written file
//basically it appends a file with new data passed
//fs.appendFileSync('f2.txt','this is f2 data')//is se f2.txt main ye data or add hoga .change nhi hoga purane vala .add hoga nya vala


//delete a file by passing its path
//unlinksync is used
//fs.unlinkSync('f2.txt')//is se f2.txt delete ho jaegi file
//console.log('file f2.txt removed')



//*directories*\\

//create

//fs.mkdirSync('mydirectory')//mkdirsync is used to create a new directory means folder
//delete
//fs.rmdirSync('mydirectory')//it is used to remove mydirectory or folder



//to check whether a directory exits or not as we can us existsSync method
//fs.mkdirSync('mydirectory')
//let doesexist=fs.existsSync('mydirectory')//ye check karega directory exit karti hai ya nhi
                                          //then aaagr karegi to return true nho karegi false
//console.log(doesexist)


//stats of  a path (what are the contents inside of a folder)

//let statsofpath=fs.lstatSync('my directory')
//console.log(statsofpath)

//console.log('isFile?',statsofpath.isFile())//my directory file nhi hai .directory hai false return hoga
         //isfile is a method whether a passed path is a file or not
 //console.log('isdirectory',statsofpath.isDirectory())//ye true return dega kyuki ye directory he hai 
 //isdirectory is a method whether a passed path is a directory or not


// let folderPath='C:\\dev\\js introduction\\js introduction\\node module\\mydirectory'//is sabke sath single slash aaya tha hamne sab 
                                                                                     //main eek or backward slash add kara hai
 //let foldeRcontent=fs.readdirSync(folderpath) 

 //console.log(foldeRcontent)
 //console.log('directory content '+foldeRcontent)\


 //copy files

 //src folder ,destfolder
//  const fs=require('fs')//ye bhi chaheye hota hai file system ko samajne ke ley
//const path=require('path')//ye chaehye hota hai path ko samajne ke ley
//copy files

// src file , destFolder

//let srcFilePath = 'C:\\dev\\node module\\mydirectory\\f3.txt'  //ye hai source file ki path copy
//let destFolder = 'C:\\dev\\node module\\mydirectory2' //ye hai destinstion of folder means directory 2 main
                                                     // store hogi source file

//let tobecopiedFileName = path.basename(srcFilePath) //is se base name pta chaega jaise hai f3.txt
//console.log(tobecopiedFileName)
// basename method gets the actual name of the file or directory

//let destPath = path.join(destFolder , tobecopiedFileName)//is se ham tobecopiedfilename to desfolder ke sath join karenge
//console.log(destPath)

//fs.copyFileSync(srcFilePath , destPath)//is se source file destination folder main jakar store ho jaegi
//console.log("file Copied")




