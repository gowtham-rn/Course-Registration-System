function showCourses(){
    fetch("http://localhost:8080/courses") //API End point
    .then((response) => response.json())
    .then((courses) => {
        const dataTable = document.getElementById("coursetable")
        dataTable.innerHTML = "";

        courses.forEach(course => {
            var row = `<tr>
            <td>${getValue(course, ["course_id", "id"])}</td>
            <td>${getValue(course, ["course_name", "name"])}</td>
            <td>${getValue(course, ["trainer"])}</td>
            <td>${getValue(course, ["duration", "duration"])}</td>
            </tr>`

            dataTable.innerHTML+=row;
        });
    });
}

function getValue(item, keys){
    for (const key of keys) {
        if (item[key] !== undefined && item[key] !== null) {
            return item[key];
        }
    }

    return "";
}

function showEnrolledStudents(){
    fetch("http://localhost:8080/courses/enrolled") //API End point
    .then((response) => response.json()) //Http response into json object
    .then((students) => {
        const dataTable = document.getElementById("enrolledtable")

        students.forEach(student => {
            var row = `<tr>
            <td>${student.name}</td>
            <td>${student.emailId}</td>
            <td>${student.courseName}</td>
            </tr>`

            dataTable.innerHTML+=row;
        });
    });
}
