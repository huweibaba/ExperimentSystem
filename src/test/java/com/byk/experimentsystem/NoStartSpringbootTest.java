package com.byk.experimentsystem;

import org.junit.Test;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class NoStartSpringbootTest {
    @Test
    public void f() throws Exception {
   File file=new File("/home/huwei/c/file.txt");
        FileOutputStream outputStream=new FileOutputStream(file);
        outputStream.write("nihao".getBytes());
        outputStream.close();

    }
}
@Configuration
class A
{
    public String s1="hello";
    public String s2="world";
    public String s3="nihao";
}

