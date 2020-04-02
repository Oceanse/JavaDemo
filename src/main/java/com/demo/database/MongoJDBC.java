package com.demo.database;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


/**
 * 将mongoDB JDBC驱动加入到项目之后，就可以对mongoDB进行操作了。
 * <dependency>
 *       <groupId>org.mongodb</groupId>
 *       <artifactId>mongo-java-driver</artifactId>
 *     </dependency>
 *
 */
public class MongoJDBC {
    public static void main(String[] args) {

        // 不通过认证连接mongoDB服务
        MongoClient mongoClient =new MongoClient("localhost",27017);

        // 连接到数据库,若指定的数据库不存在，mongoDB将会在你第一次插入文档时创建数据库。
        MongoDatabase mydatabase = mongoClient.getDatabase("mydatabase");
        System.out.println("Connect to com.demo.database successfully");

        //连接到pets表
        MongoCollection<Document> info = mydatabase.getCollection("familyInfo");


        //插入单个文档
        Document document =new Document("name","haiyang")
                .append("age",28)
                .append("sex","man");
        info.insertOne(document);

        //插入多个文档
        Document document2 =new Document("name","mama")
                .append("age",53)
                .append("sex","woman");

        Document document3 =new Document("name","baba")
                .append("age",63)
                .append("sex","man");
        List<Document> documents=new ArrayList<>();
            documents.add(document2);
        documents.add(document3);

        info.insertMany(documents);

        //检索所有文档
        FindIterable<Document> findIterable = info.find();
        MongoCursor<Document> iterator = findIterable.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //修改文档
        info.updateOne(Filters.eq("name", "haiyang"),new Document("$set",new Document("name","ocean")));


        //删除所有符合条件的文档
        //info.deleteMany(Filters.eq("name","haiyang"));

        //删除符合条件的第一个文档
        //info.deleteOne(Filters.eq("name","haiyang"));


    }
}
