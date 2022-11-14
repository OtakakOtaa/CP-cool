package org.example.Server.PersistentProvider.SQL;

public class StudentDBQuery {
    public static final String INSERT = "INSERT into student(fname, lname, address, mobile_no, email_id, city, designation, dob,doj, salary) " + "values(?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE = "update student set fname=?,lname=?,address=?,mobile_no=?,email_id=?,city=?, " + "designation=?,dob=?,doj=?,salary=? " + "where id=? ";
    public static final String DELETE = "delete from student where id=?";
    public static final String FIND_BY_ID = "select * from student where id=?";
    public static final String FETCH_BY_EMAIL_ID = "select * from student where email_id=?";
    public static final String FETCH_BY_MOBILE_NO = "select * from student where mobile_no=?";
    public static final String SEARCH_BY_NAME = "select * from student where fname=? like lname =?";
    public static final String FETCH_BY_CITY = "select * from student where city=?";
    public static final String FETCH_BY_SALARY_RANGE = "select * from student where salary between ? and ?";
    public static final String FETCH_BY_DOB = "select * from student where dob=?";
    public static final String FETCH_BY_DOJ_RANGE = "select * from student where doj between ? and ?";
    public static final String FETCH_ALL_AND_ORDER_BY_ID_DESC = "select * from student order by id desc";


}
