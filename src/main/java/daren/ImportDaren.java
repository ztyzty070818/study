package daren;

import excel.ExcelReader;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ImportDaren {

    private static final String QUERY_ALL = "SELECT id,name FROM sugo_author_crawler_daren" +
            "  WHERE ( channel LIKE '%有好货%' OR channel LIKE '%淘宝头条%' OR channel LIKE '%必买清单%')" +
            "  AND fansCount > 10000 ORDER BY createdAt";

    private static final String QUERY_ONE = "SELECT * FROM sugo_author_crawler_daren WHERE id =";
    private static final String DELETE_ONE = "DELETE FROM sugo_author_crawler_daren WHERE id =";

    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = getCon();
        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(QUERY_ALL);
//
//        Map<String, String> messages = new HashMap<>();
//        while(resultSet.next()) {
//            messages.put(resultSet.getString(1), resultSet.getString(2));
//        }

//        System.out.println(messages);
        String filePath = "/home/qwe/Downloads/有ID账号列表.xlsx";
        String columns[] = {"id","wangwang","name","category","level"};
        List<Map<String,String>> excelRecords = ExcelReader.getExcelRecord(filePath, columns);

        System.out.println(excelRecords.size());

//        removeExist(excelRecords, messages);
//        addRecord(excelRecords, statement);
        updateRecord(excelRecords, statement);

//        resultSet.close();
        statement.close();
        connection.close();
    }

    private static void updateRecord(List<Map<String, String>> excelRecords, Statement statement) throws SQLException {
        for(Map<String, String> record : excelRecords) {
            String id = record.get("id");
            if(StringUtils.isNotBlank(id)) {
//                是否排除存在的记录
                String queryExist = String.format("%s '%s'", QUERY_ONE, record.get("id"));
                ResultSet rs = statement.executeQuery(queryExist);
                if(rs.next()) {
                    String deleteQuery = String.format("%s '%s'", DELETE_ONE , record.get("id"));
                    statement.execute(deleteQuery);
                }

                String query = String.format("INSERT INTO sugo_author_crawler_daren(id, name, contentDomain, ranking, createdAt, updatedAt, fansCount, channel)" +
                                " values('%s', '%s', '%s', '%s', '2017-01-01', '2017-01-01', 500000, '淘宝头条,有好货,必买清单');",
                        id, record.get("name"), record.get("category"), record.get("level"));
                System.out.println(query);
                statement.execute(query);

            }
        }
    }


    private static void addRecord(List<Map<String, String>> excelRecords, Statement statement) throws SQLException {
        for(Map<String, String> record : excelRecords) {
            String id = record.get("id");
            if(StringUtils.isNotBlank(id)) {
//                是否排除存在的记录
                String queryExist = String.format("%s '%s'", QUERY_ONE, record.get("id"));
                ResultSet rs = statement.executeQuery(queryExist);
                if(!rs.next()) {
                    String query = String.format("INSERT INTO sugo_author_crawler_daren(id, name, contentDomain, ranking, createdAt, updatedAt, fansCount, channel)" +
                            " values('00', 'a', 'b', 'v3', '2017-01-01', '2017-01-01', 500000, '淘宝头条,有好货,必买清单');",
                            id, record.get("name"), record.get("category"), record.get("level"));
                    System.out.println(query);
                    statement.execute(query);
                }

            }
        }
    }

    public static void removeExist(List<Map<String,String>> excelRecords, Map<String, String> messages) {
        int recordSize = excelRecords.size();
        for(int i=0; i<recordSize; i++) {
            Map<String,String> mess = excelRecords.get(i);
            String id = mess.get("id");
            if(messages.containsKey(id) || messages.containsValue(mess.get("name"))) {
                excelRecords.remove(mess);
                i--;
                recordSize--;
            }
        }

        System.out.println(excelRecords.size());
        // 73   27  46
    }


    public static Connection getCon() throws SQLException {
        //数据库连接名称
        String username="sugo_headline";
        //数据库连接密码
        String password="123456";
        String driver="com.mysql.jdbc.Driver";
        //其中test为数据库名称
        String url="jdbc:mysql://192.168.0.210:3306/sugo_headline";
        Connection conn=null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

}
