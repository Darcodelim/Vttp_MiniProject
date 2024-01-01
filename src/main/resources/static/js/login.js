var counter = 0; //instantiate a counter
var maxImage = 4; //the total number of images that are available
var fadeinandout = 2000;
setInterval(function() {
    
    document.querySelector('img').style['backgroundImage'] = "url('Login_Images/" + (counter + 1) + ".jpg')"; //put in body tag in html as specified "body"
    document.querySelector('img').style['backgroundSize'] = "cover";
    document.querySelector('img').className = "underlay-photo"
    // document.body.animate([
    //    { opacity: 0, offset:0 },
    //    {opacity:0, offset:1},
    //    {opacity:1,offset:0.5}]
    // ,{duration: fadeinandout}
    // );


    if (counter + 1 == maxImage) {
        counter = 0; //reset to start
    } else {
        ++counter; //iterate to next image
    }
},20050 );