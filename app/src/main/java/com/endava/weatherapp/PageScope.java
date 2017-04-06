package com.endava.weatherapp;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Mihai.Traistaru on 03/30/2017.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PageScope {
}
