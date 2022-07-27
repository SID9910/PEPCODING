let mimimist =require("minimist");
let argv =mimimist(process.argv);
let fs = require("fs");
let sread =fs.readFileSync(argv.source ,"utf-8");
let dread =sread.toUpperCase();
// console.log(dread);
let mwrite =fs.writeFileSync(argv.dest ,dread ,"utf-8");
console.log(mwrite);