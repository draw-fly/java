for (var i = 0; i < 5; i++) {
    setTimeout(function () {
        console.log(i); // 5 5 5 5 5
    }, 300);
}
for (let j = 0; j < 5; j++) {
    setTimeout(function () {
        console.log(j); // 0 1 2 3 4
    }, 300);
}
