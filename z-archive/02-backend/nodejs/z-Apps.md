# Apps
## QR Code generator
inquirer for user input. Answer stored in answers objects under `name`
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

## HTML to PDF
```js
// http req using express
const generateCertificate = (req, res) => {
  const { studentName, studentUrn, studentRole } = req.body;

  var pdf = require("pdf-creator-node");
  var fs = require("fs");

  // path to html template
  const html = fs.readFileSync("./src/temp.html", "utf8");

  // PDF Options
  const options = {
    format: "A4",
    orientation: "landscape",
    border: "10mm"
  };

  const date = new Date().toJSON().slice(0,10);
  // assigning variables to be passed
  var document = {
    html: html,
    data: {
      studentName, studentUrn, studentRole, date
    },
    path: `./pdf_output/${studentUrn}.pdf`,
    type: "",
  };

  pdf
    .create(document, options)
    .then((res) => {
      console.log(res);
    })
    .catch((error) => {
      console.error(error);
    });

  res.status(200).send({message: `PDF for ${studentName} generated`, status:"true"});
  
}
```