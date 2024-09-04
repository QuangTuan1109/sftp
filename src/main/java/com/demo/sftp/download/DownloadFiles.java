package com.demo.sftp.download;

import org.springframework.integration.sftp.session.SftpSession;

import java.io.IOException;

public interface DownloadFiles {

    void saveFiletoDisk(String originalFileName, SftpSession session) throws IOException;
}
