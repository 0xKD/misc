/*
This looks like more work, given the alternative in script2.js.
But it would work in browsers that do not support transform, (~10% as of 5.4.2016)
Then again, one could use feature-detection instead.
*/

function animate(el, classA, classB) {
  var first = el.getBoundingClientRect();
  el.classList.add(classA);
  var last = el.getBoundingClientRect();

  var invert = first.top - last.top;
  el.style.transform = 'translateY(' + invert + 'px)';

  requestAnimationFrame(function() {
    el.classList.add(classB);
    el.style.transform = "";
  });

  el.addEventListener("transitioned", function() {
    console.log("[+] Animation done!");
  })
}

function main() {
  var el = document.getElementById("box");
  el.addEventListener("click", function() {
    animate(el, "box--under", "box--animate");
  });
}

document.addEventListener("DOMContentLoaded", function () {
  main();
});
