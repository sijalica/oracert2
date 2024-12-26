package part12Annotations.annotations;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Repeatable Annotation
*/

import java.lang.annotation.Repeatable;

// Repeatable Annotation Type requires containing annotation
@Repeatable(MyRepeatableAnnotations.class)
public @interface MyRepeatableAnnotation {
    int value() default 0;
}