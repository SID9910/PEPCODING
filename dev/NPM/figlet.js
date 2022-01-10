var figlet = require('figlet');

figlet('Hello World!!', function(err, data) {
    if (err) {
        console.log('Something went wrong...');
        console.dir(err);
        return;
    }
    console.log(data)
});

//how to install a package
//go to the folder you want to install the package in the terminal
//and type ->npm install<packagename>
//go to google and search npm figlet and copy path
//then terminal main  likho npm install figlet
//package install ho jaega 
