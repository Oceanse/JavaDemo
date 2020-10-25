package com.demo.javaIO.resource_operation;

import org.testng.annotations.Test;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.IOException;

public class Pack {
    /**
     * 测试压缩
     * @return
     * @throws IOException
     */
    @Test
    public void testPack() throws IOException {
        String logReportDir = "C:\\Users\\epanhai\\git\\myproject\\JavaDemo\\testResource";
        File zippedFile = new File(logReportDir + ".zip");
        ZipUtil.pack(new File(logReportDir), zippedFile);//pack(File rootDir, File zip)
        System.out.println(zippedFile.getAbsolutePath());
        System.out.println(zippedFile.exists());
    }




}
