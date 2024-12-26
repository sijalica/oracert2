package part3Interfaces;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Private methods
*/

// Interface to support academic advisors at universities.
interface Advisable {

    // Set up some enums to facilitate code
    enum GradeLevel {
        FRESHMAN("Math", "History"),
        SOPHOMORE("Math", "Political Science"),
        JUNIOR("CompSci", "DiffEq"),
        SENIOR("ElectroMagnetics", "Statistics");
        String[] courses;

        GradeLevel(String... courses) {
            this.courses = courses;
        }
    }

    enum AcademicLevel {
        FAILING, UNSATISFACTORY, SATISFACTORY, OVERACHIEVING
    }

    // This is the method all implementing classes must override
    void advise(GradeLevel gradeLevel, AcademicLevel[] academicLevel);

    // Default method gets schedule by class level
    default String getRequirements(GradeLevel grade,
                                   AcademicLevel[] academicLevel) {

        String reqs = grade.toString();
        for (int i = 0; i < grade.courses.length; i++) {
            // This code block used here as well as in getClass method
            String levelCode = "";
            switch (academicLevel[i]) {
                case FAILING:
                case UNSATISFACTORY:
                    levelCode = "UD";
                    break;
                case OVERACHIEVING:
                    levelCode = "ADV";
            }
            // Build schedule...
            reqs += ": \n\t\t "
                    + grade.courses[i] + " "
                    + (grade.ordinal() + 1) + "000"
                    + levelCode;
        }
        return reqs;
    }

    // Default method to get a single class
    default String getClass(GradeLevel grade, String course, AcademicLevel academicLevel) {

        // This code is repeated again in this method
        String levelCode = "";
        switch (academicLevel) {
            case FAILING:
            case UNSATISFACTORY:
                levelCode = "UD";
                break;
            case OVERACHIEVING:
                levelCode = "ADV";
        }
        return course + " " + (grade.ordinal() + 1) + "000"
                + levelCode;
    }

}