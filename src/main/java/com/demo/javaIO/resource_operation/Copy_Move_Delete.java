package com.demo.javaIO.resource_operation;

import org.apache.commons.io.FileUtils;
import org.springframework.util.FileSystemUtils;
import org.testng.annotations.Test;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Copy_Move_Delete {

    /**
     * cp: stream--->文件
     * @throws IOException
     */
    @Test
    public void fromStreamToPath() throws IOException {
        URI uri = URI.create("http://wwww.baidu.com");
        URL url = uri.toURL();
        InputStream inputStream = url.openStream();
        //复制的过程会产生target对应的文件output.txt,但是不会createdir，所有路径中的dir一定要存在
        //不带StandardCopyOption.REPLACE_EXISTING，若target存在的话拷贝会报FileAlreadyExistsException
        Files.copy(inputStream, Paths.get("testResource\\out.txt"), StandardCopyOption.REPLACE_EXISTING);

        InputStream in = FileUtils.openInputStream(new File("pom.xml"));//获取文件输入流,stream从文件流向程序
        Files.copy(in, Paths.get("test2.txt"), StandardCopyOption.REPLACE_EXISTING  );///获取文件输入和输出的文件流拷贝到执行文件中
    }


    /**
     * cp: String--->文件
     * <artifactId>commons-io</artifactId>
     * @throws IOException
     */
    @Test
    public void fromStringToPath() throws IOException {
        File file=new File("test.txt");
        String contents="good luck";

        System.out.println(Charset.defaultCharset());

        //String写入File对象中,覆盖源文件内容
        FileUtils.writeStringToFile(file,contents, Charset.defaultCharset());//file不存在则创建
    }


    /**
     * 拷贝文件到目录 Copies a file to a directory
     * @throws IOException
     */
    @Test
    public void formFileToDir() throws IOException {

        System.out.println(FileUtils.getTempDirectory());//获取临时目录
        System.out.println(FileUtils.getUserDirectory());//获取用户主目录
        System.out.println(FileUtils.getFile(FileUtils.getUserDirectory(), "mylog"));//Construct a file from the set of name elements


        FileUtils.touch(new File("newfile.txt"));//创建文件，如果文件存在则更新时间；如果不存在，创建一个空文件

        //boolean isSame=FileUtils.contentEquals(new File("test.txt"),new File("test2.txt"));
        //System.out.println(isSame);

        //第一个参数是文件，第二个是参数目录，第三个参数是否更新时间,newdir不存在则会自动创建
        FileUtils.copyFileToDirectory(new File("newfile.txt"),new File("newdir"),true);

    }




    /**
     * mv: 剪切或者重命名
     * 类似于linux mv： Move or rename a file to a target file.
     * @throws IOException
     */
    @Test
    public void fromPathToPath() throws IOException {

        Path path=Paths.get("C:\\Users\\epanhai\\git\\myproject\\JavaDemo\\testResource\\suite.json");
        Path path2=Paths.get("C:\\Users\\epanhai\\git\\myproject\\JavaDemo\\testResource\\suite2.json");

        //如果设置了REPLACE_EXISTING，则会覆盖已有的文件
        Files.move(path,path2, StandardCopyOption.REPLACE_EXISTING);
    }


    /**
     * org.springframework.util。FileSystemUtils
     * 删除
     */
    @Test
    public void test(){
        Path path= Paths.get("C:\\Users\\epanhai\\Desktop\\aa");

        //会递归删除这个目录下的所有内容，最后把当前目录也删除掉
        FileSystemUtils.deleteRecursively(path.toFile());
    }

}
