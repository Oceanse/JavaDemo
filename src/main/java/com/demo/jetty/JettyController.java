package com.demo.jetty;


import com.google.gson.JsonObject;
import com.demo.jetty.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * jetty+reeteasy提供restful服务
 *
 * @Produces：返回的类型 返回给client字符串类型
 * @Produces(MediaType.TEXT_PLAIN): 返回给client为json类型（application/json）
 * @Produces(MediaType.APPLICATION_JSON): 通常适用于返回值是json类型的String或者Object对象（User）
 *
 *
 * @Consumes与@Produces相反，用来指定可以接受client发送过来的MIME类型，同样可以用于class或者method，
 * 也可以指定多个MIME类型，一般用于@PUT，@POST
 * @Consumes(MediaType.TEXT_PLAIN):接受client参数为字符串类型 .    
 *
 *@Consumes(MediaType.APPLICATION_JSON): 接受clent参数为json类型 .   
 *
 *
 */

@Path("/jtcontroller")
public class JettyController {

    @GET
    @Path("/hello")
    @Consumes(MediaType.TEXT_PLAIN)
    public String getInfo() {
        return "hello jetty";
    }


    @POST
    @Path("/subpath2")
    @Consumes(MediaType.TEXT_PLAIN)
    public String getInfo2() {
        return "hello jetty";
    }


    /**
     * 下面案例中@Produces是MediaType.APPLICATION_JSON，而方法的返回值是JsonObject，
     * 会报Caused by: java.lang.UnsupportedOperationException: JsonObject
     * 怀疑是客户端不能把JsonObject转成json类型
     * @return
     */
   /*
   @POST
    @Path("/subpath3")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)//返回给client为json类型
    public JsonObject getInfo3() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name","ocean");
        jsonObject.addProperty("age","30");
        return jsonObject;
    }
    */


    /**
     * 客户端可以把String转换成json类型
     */
    @POST
    @Path("/subpath3")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)//返回给client为json类型
    public String getInfo3() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "ocean");
        jsonObject.addProperty("age", "30");
        return jsonObject.toString();
    }


    @POST
    @Path("/subpath3_2")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)//返回给client为json类型
    public String getInfo3_2() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "ocean");
        jsonObject.addProperty("age", "30");
        return jsonObject.toString();
    }


    @POST
    @Path("/subpath4")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)//返回给client为json类型
    public User getInfo4() {
        JsonObject jsonObject = new JsonObject();
        User user = new User("ocean", 30);
        return user;
    }

    @POST
    @Path("/subpath4_2")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)//返回给client字符串类型
    public User getInfo4_2() {
        User user = new User("ocean", 30);
        return user;
    }


    /**
     *@headerparam　　标注提取HTTP标头（ HTTP header）并将它绑定到一个方法的参数。
     * @param name
     * @param age
     * @return
     */
    @POST
    @Path("/subpath5/")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)//返回给client为json类型

    //从header获取name和age  这里的HeaderParam是javax.ws.rs.HeaderParam
    public User getInfo5(@HeaderParam("name") String name, @HeaderParam("age") int age) {
        User user = new User(name, age);
        return user;
    }


    /**
     * 这里的PathParam是javax.ws.rs.PathParam ,标注绑定一个路径段资源的方法参数的值,从url中的{}取值，类似于spring中的@PathVariable
     * @param name
     * @param age
     * @return
     */
    @POST
    @Path("/subpath6/{name}/{age}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)//返回给client为json类型

    //从header获取name和age
    public User getInfo6(@PathParam("name") String name, @PathParam("age") int age) {
        User user = new User(name, age);
        return user;
    }


    /**
     * @QueryParam从http://localhost:8080/base/rest/v1/jtcontroller/subpath7?name=pan&age=29
     * @param name
     * @param age
     * @return
     */
    @POST
    @Path("/subpath7")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)//返回给client为json类型

    //从header获取name和age
    public User getInfo7(@QueryParam("name") String name, @QueryParam("age") int age) {
        User user = new User(name, age);
        return user;
    }

}


