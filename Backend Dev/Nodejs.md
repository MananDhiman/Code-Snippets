## NPM
Instead of common es modules that are accomplished using `const fs = require(“fs”)`, it is preferred to use ecmascript modules.

To use, make changes to package.json: add type=”module”
```js
import sH from "superheroes";
console.log(sH.random());
```


## File handling
fs.open() method takes a "flag" as the second argument, if the flag is "w" for "writing", the specified file is opened for writing. 

If the file does not exist, an empty file is created.

Delete -> fs.unlink()

delete a file with the File System module,  use the fs.unlink() method.
fs.rename()
const fs = require("fs")
```js
// write to file
fs.writeFile("message.txt", "Hello from Node JS", (err) => {
    if (err) throw err;
    console.log("File saved");
});

// append to file
fs.appendFile("message.txt", "Helllo again", (err) => {
    if (err) throw err;
    console.log("Appended");
});

// read from file. Use utf8 encoding otherwise raw buffer printed
fs.readFile("message.txt", "utf8", (err, data) => {
    if (err) throw err;
    console.log("Data -> "+data);
});

// delete file
fs.unlink("example_file.txt", (err) => {
  if (err) console.log(err);
  else {
    console.log("\nDeleted file: example_file.txt");
  }
});

// Rename the file
fs.rename('original.txt', 'changed.txt', () => {
  console.log("\nFile Renamed!\n");
});
```




## QR Code generator
```js
import qr_image from "qr-image";
import inquirer from "inquirer";
import fs from "fs";


inquirer
  .prompt([
    /* Pass your questions in here */
    { message: "Enter URL or any text: ", name: "inputText" },
  ])
  .then((answers) => {
    // Use user feedback for... whatever!!
    const inputText = answers.inputText;
    console.log(inputText);

    //   defaults to png
    let qr_svg = qr_image.image(inputText, { type: 'png'});
    qr_svg.pipe(fs.createWriteStream(`${inputText}.png`));
  })
  .catch((error) => {
    if (error.isTtyError) {
      // Prompt couldn't be rendered in the current environment
    } else {
      // Something else went wrong
    }
  });
```
