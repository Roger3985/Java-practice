package com.example.basic.lesson18.example.annotation;

import org.hibernate.annotations.Filter;

@Filter(name = "/admin")
@Filter(name = "/manager")
public interface SecurityFilter {}
