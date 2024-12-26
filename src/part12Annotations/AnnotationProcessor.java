package part12Annotations;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Annotation Processor to Examine Annotations
*/

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

// Specify which Annotations this processor processes
@SupportedAnnotationTypes(
        {
                "annotations.*"
        })
@SupportedSourceVersion(SourceVersion.RELEASE_11)

// Annotation processors extend AbstractProcessor
public class AnnotationProcessor extends AbstractProcessor {

    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(
                    annotation)) {
                System.out.println(
                        element.getKind() + " " +
                                element.getEnclosingElement() + "." +
                                element + " is annotated with " +
                                annotation);
            }
        }
        // return true if this is the only processor permitted to
        // process the annotations listed in SupportedAnnotationTypes
        return true;
    }
}