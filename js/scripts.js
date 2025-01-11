document.getElementById("employeeForm").addEventListener("submit", (e) => {
    e.preventDefault();
    const id = document.getElementById("id").value;
    const name = document.getElementById("name").value;
    const department = document.getElementById("department").value;

    alert(`Employee Added: ID=${id}, Name=${name}, Department=${department}`);
});

document.getElementById("resourceForm").addEventListener("submit", (e) => {
    e.preventDefault();
    const id = document.getElementById("id").value;
    const name = document.getElementById("name").value;
    const available = document.getElementById("available").checked;

    alert(`Resource Added: ID=${id}, Name=${name}, Available=${available}`);
});
