
const students = [
    {
        id: 101,
        name: "Aarav Sharma",
        department: "Computer Science",
        java: 88,
        sql: 91,
        web: 85
    },
    {
        id: 102,
        name: "Ananya Rao",
        department: "Information Technology",
        java: 94,
        sql: 87,
        web: 92
    },
    {
        id: 103,
        name: "Rohan Kumar",
        department: "Computer Science",
        java: 76,
        sql: 82,
        web: 79
    },
    {
        id: 104,
        name: "Diya Patel",
        department: "Information Technology",
        java: 90,
        sql: 95,
        web: 89
    }
];

const tableBody = document.getElementById("student-table-body");
const searchInput = document.getElementById("search-input");
const tableFooter = document.getElementById("table-footer");
const studentForm = document.getElementById("student-form");
const formMessage = document.getElementById("form-message");

function escapeHTML(value) {
    return String(value).replace(/[&<>"']/g, character => ({
        "&": "&amp;",
        "<": "&lt;",
        ">": "&gt;",
        '"': "&quot;",
        "'": "&#39;"
    })[character]);
}

function getAverage(student) {
    return Math.round((student.java + student.sql + student.web) / 3);
}

function updateStatistics() {
    document.getElementById("total-students").textContent =
        students.length;

    const overallAverage = students.length
        ? students.reduce((sum, student) =>
            sum + student.java + student.sql + student.web, 0
        ) / (students.length * 3)
        : 0;

    document.getElementById("average-marks").textContent =
        `${Math.round(overallAverage)}%`;
}

function renderStudents(list = students) {
    tableBody.innerHTML = list.map(student => `
        <tr>
            <td class="student-name">${escapeHTML(student.name)}</td>
            <td class="student-id">#${student.id}</td>
            <td>
                <span class="department-badge">
                    ${escapeHTML(student.department)}
                </span>
            </td>
            <td>${student.java}</td>
            <td>${student.sql}</td>
            <td>${student.web}</td>
            <td>
                <span class="average-badge">${getAverage(student)}%</span>
            </td>
        </tr>
    `).join("");

    tableFooter.textContent =
        `Showing ${list.length} of ${students.length} students`;
}

function filterStudents() {
    const query = searchInput.value.trim().toLowerCase();

    const filteredStudents = students.filter(student =>
        String(student.id).includes(query) ||
        student.name.toLowerCase().includes(query) ||
        student.department.toLowerCase().includes(query)
    );

    renderStudents(filteredStudents);
}

searchInput.addEventListener("input", filterStudents);

document.getElementById("show-form-button").addEventListener("click", () => {
    document.getElementById("add-student").scrollIntoView({
        behavior: "smooth"
    });

    document.getElementById("student-name").focus();
});

studentForm.addEventListener("submit", event => {
    event.preventDefault();
    formMessage.textContent = "";

    const student = {
        id: Number(document.getElementById("student-id").value),
        name: document.getElementById("student-name").value.trim(),
        department: document.getElementById("student-department").value.trim(),
        java: Number(document.getElementById("java-marks").value),
        sql: Number(document.getElementById("sql-marks").value),
        web: Number(document.getElementById("web-marks").value)
    };

    if (!student.name || !student.department) {
        formMessage.textContent = "Please enter the name and department.";
        return;
    }

    if (students.some(existing => existing.id === student.id)) {
        formMessage.textContent = "That student ID already exists.";
        formMessage.style.color = "#c0395a";
        return;
    }

    const marks = [student.java, student.sql, student.web];

    if (!Number.isInteger(student.id) || student.id < 1 ||
        marks.some(mark => !Number.isInteger(mark) || mark < 0 || mark > 100)) {
        formMessage.textContent = "Enter a valid ID and marks from 0 to 100.";
        formMessage.style.color = "#c0395a";
        return;
    }

    students.push(student);

    updateStatistics();
    filterStudents();

    formMessage.style.color = "#348765";
    formMessage.textContent =
        "Student added to this preview successfully!";

    studentForm.reset();
});

updateStatistics();
renderStudents();