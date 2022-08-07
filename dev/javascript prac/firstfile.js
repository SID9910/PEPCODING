let minimist = require("minimist");
let fs = require("fs");
let jsdom = require("jsdom");
//will load the html and prepare the dom for programmers just like a browser would have
let args =minimist(process.argv);
fs.readFile(args.source,"utf-8",function(err, html){
    let dom = new jsdom.JSDOM(html);
    let document = dom.window.document;

    let descs = document.querySelectorAll("div.match-info > div.description");
    //we will get all the div's with class desc whose parent is a div with class match-info
    for(let i=0;i<descs.length;i++){
console.log(descs[i].textContent);
    }

})
