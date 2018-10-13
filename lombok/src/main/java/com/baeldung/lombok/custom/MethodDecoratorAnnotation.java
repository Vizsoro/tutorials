package com.baeldung.lombok.custom;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(SOURCE)
@Target({CONSTRUCTOR, METHOD})
public @interface MethodDecoratorAnnotation {
	/** The name for the thread while the annotated method executes. */
	String value();
}