package part12Annotations.annotations;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Container for a Repeatable annotation
*/

// Containing Annotation Type has value which is array of
// annotation which will be repeated
public @interface MyRepeatableAnnotations {
    MyRepeatableAnnotation[] value();
}