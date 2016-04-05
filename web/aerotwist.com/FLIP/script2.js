function main() {
  var el = document.getElementById("box");
  el.classList.add("box--animate");
  el.addEventListener("click", function() {
    el.classList.add("box--under-2");
  });
}

document.addEventListener("DOMContentLoaded", function () {
  main();
});
