package com.example.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.example.easyexcel.listener.StudentListener;
import com.example.easyexcel.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class EasyexcelApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void  Test(){
        File file = new File("C:\\Users\\刘卓鹏\\Desktop\\test\\学生信息表.xlsx");
        ExcelReaderBuilder readWorkBook = EasyExcel.read(file, Student.class, new StudentListener());
        ExcelReaderSheetBuilder sheet = readWorkBook.sheet(0);
        sheet.doRead();
    }

    @Test
    void TestWrite(){
        ExcelWriterBuilder writeWorkBook = EasyExcel.write("C:\\Users\\刘卓鹏\\Desktop\\test\\写学生信息表.xlsx", Student.class);
        ExcelWriterSheetBuilder sheet = writeWorkBook.sheet(0);
        sheet.doWrite(students());

    }

    List<Student> students(){
        List<Student> students = new ArrayList<>();
        for (int i =0;i<10;i++){
            Student student = new Student();
            student.setAge(20);
            student.setBirthday(new Date());
            student.setName("liu卓"+i);
            students.add(student);
        }
        return students;
    }

}
