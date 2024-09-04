package com.demo.sftp.download.imp;

import com.demo.sftp.config.SftpConfig;
import com.demo.sftp.download.DownloadFiles;
import org.apache.commons.io.FileUtils;
import org.springframework.integration.sftp.filters.SftpSimplePatternFileListFilter;
import org.springframework.integration.sftp.session.SftpSession;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.log4j.Logger;

@Service
public class DownloadFileImp implements DownloadFiles {

    private static Logger logger = Logger.getLogger(SftpConfig.class.getName());

    @Override
    public void saveFiletoDisk(String originalFileName, SftpSession session) throws IOException {
        String fileLocation = "/C:/Users/ADMIN/Documents/" + originalFileName;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        session.read(fileLocation, outputStream);
        String data = outputStream.toString();
        File download = new File(String.format("src/main/resources/downloaded/%s", originalFileName));
        FileUtils.write(download, data, StandardCharsets.UTF_8);
    }
}
