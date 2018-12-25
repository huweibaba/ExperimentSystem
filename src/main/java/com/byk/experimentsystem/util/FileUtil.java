package com.byk.experimentsystem.util;

import com.byk.experimentsystem.Exception.MyException;
import com.byk.experimentsystem.entity.File;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class FileUtil {
    @Autowired
    FastFileStorageClient fastFileStorageClient;
    @Autowired
    TrackerClient trackerClient;

    public File fileUpLoad(MultipartFile multipartFile) throws Exception {
        InputStream inputStream = multipartFile.getInputStream();

        StorePath storePath = fastFileStorageClient.uploadFile(inputStream, multipartFile.getSize(), FilenameUtils.getExtension(multipartFile.getOriginalFilename()), null);


        inputStream.close();
        File file=new File();
        file.setFileName(multipartFile.getOriginalFilename());
        file.setFileSize((int)multipartFile.getSize());
        file.setFileType(multipartFile.getContentType());
        file.setFilePath(storePath.getFullPath());
        return file;

    }

    public List<File> fileUpLoad(MultipartFile[] multipartFiles) throws Exception {
        List<File> fileList = new ArrayList<File>();
        for (MultipartFile multipartFile : multipartFiles) {
            File file= fileUpLoad(multipartFile);
            fileList.add(file);
        }
        return fileList;
    }

    public void download(OutputStream out, String fullPath) throws  Exception{
            int index=fullPath.indexOf('/');
            String group=fullPath.substring(0,index);
            String path=fullPath.substring(index+1);
            InputStream inputStream = fastFileStorageClient.downloadFile(group, path, new DownloadInputStream());
            byte buffer[] = new byte[1024];
            int len = 0;
           try{ //循环将输入流中的内容读取到缓冲区当中
            while ((len = inputStream.read(buffer)) > 0) {
                //输出缓冲区的内容到浏览器，实现文件下载
                out.write(buffer, 0, len);
            }
        }
            catch(Exception e)
            {
                  throw new MyException("文件下载异常");
            }
            finally
          {
            inputStream.close();
            out.close();
          }
        }
    public void delete(String fullPath) throws  Exception
    {   int index=fullPath.indexOf('/');
        String group=fullPath.substring(0,index);
        String path=fullPath.substring(index+1);
        fastFileStorageClient.deleteFile(group,path);
    }
    }




class DownloadInputStream implements DownloadCallback<InputStream> {

    @Override
    public InputStream recv(InputStream inputStream) throws IOException {
        return inputStream;
    }
}
