📚 University Exam Scheduling System
A complete exam scheduling application for university examination weeks. The system optimally assigns exams to halls and time slots while respecting multiple constraints (capacity, student clashes, preferred slots). It features a Java Swing GUI, a backtracking scheduler, data persistence, and HTML export.

✨ Features
5 days × 5 periods grid (8:00 – 12:00, Mon‑Fri).

Automatic scheduling using backtracking with heuristics.

Constraints:

Hall capacity (exam must fit in the assigned hall).

Student clash (no student appears in two overlapping exams).

Optional preferred time slots (force an exam to a specific day/period).

No overlapping exams in the same hall.

Full GUI:

Manage halls, exams, and constraints via tabs.

One‑click scheduler with progress indicator.

Colour‑coded schedule table (JTable) with tooltips.

HTML export – beautiful responsive HTML file with legend and hover details.

Data persistence – all data is saved to text files (halls.txt, exams.txt, schedule.txt).

Custom exception UnschedulableException when no feasible schedule exists.

🛠️ Technologies
Category	Technology
Language	Java 8+
GUI Framework	Swing (Nimbus Look & Feel)
Persistence	Plain text files (CSV format)
Build	No build tool – pure javac
Design principles: OOP, no Java Collections (except for GUI models), backtracking with constraints.
