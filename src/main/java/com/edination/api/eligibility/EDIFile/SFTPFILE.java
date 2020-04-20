package com.edination.api.eligibility.EDIFile;

import com.jcraft.jsch.*;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class SFTPFILE {

    private static String SFTPHOST;

    private static int SFTPPORT;

    private static String SFTPUSER;

    private static String SFTPPASS;

    private static String CCDAFILEPATH;

    private static ChannelSftp channelSftp = null;

    private static Session session = null;

    private static Channel channel = null;
    JSch jsch = null;

    private static final Logger LOG = LoggerFactory.getLogger(SFTPFILE.class);

    public void propertValue()
    {
        InputStream inputStream = this.getClass().getResourceAsStream("/sftp.properties");
        Properties prop = new Properties();
        try {
            prop.load(inputStream);

            SFTPUSER = prop.getProperty("sftp.host.user");
            SFTPHOST = prop.getProperty("sftp.host.ip");
            SFTPPORT = Integer.valueOf(prop.getProperty("sftp.host.port"));
            SFTPPASS = prop.getProperty("sftp.host.password");
            CCDAFILEPATH = prop.getProperty("sftp.ccda.file.path");
            LOG.info("SFTPHOST=" + SFTPHOST + ", SFTPPORT=" + SFTPPORT + ", CCDAFILEPATH=" + CCDAFILEPATH);
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
    }

    public void uploadFile(File fw, String fileName) {
        //jsch = new JSch();
        //String path = fw.getAbsolutePath();
        InputStream inputStream = this.getClass().getResourceAsStream("/sftp.properties");
        Properties prop = new Properties();

        /*try {
            // load a properties file
            prop.load(inputStream);

            SFTPUSER = prop.getProperty("sftp.host.user");
            SFTPHOST = prop.getProperty("sftp.host.ip");
            SFTPPORT = Integer.valueOf(prop.getProperty("sftp.host.port"));
            SFTPPASS = prop.getProperty("sftp.host.password");
            CCDAFILEPATH = prop.getProperty("sftp.ccda.file.path");
            LOG.info("SFTPHOST=" + SFTPHOST + ", SFTPPORT=" + SFTPPORT + ", CCDAFILEPATH=" + CCDAFILEPATH);

            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            config.put("PreferredAuthentications", "password");
            session.setConfig(config);
            session.connect(); // Create SFTP Session
            channel = session.openChannel("sftp"); // Open SFTP Channel
            channel.connect();
            channelSftp = (ChannelSftp) channel;

            channelSftp.put(path, CCDAFILEPATH + "/" + fileName);
        } catch (IOException ex) {
            LOG.info("file not found" + ex);
        } catch (JSchException ex) {
            LOG.info("Channel connection failed" + ex);
        } catch (SftpException ex) {
            LOG.info("File upload failed on sftp server" + ex);
        } finally {
            if (channelSftp != null)
                channelSftp.disconnect();
            if (channel != null)
                channel.disconnect();
            if (session != null)
                session.disconnect();

        }
*/
        FTPClient ftpClient = new FTPClient();
        try {
            this.propertValue();

            ftpClient.connect(SFTPHOST, SFTPPORT);
            ftpClient.login(SFTPUSER, SFTPPASS);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);


            FileInputStream inputStream1 = new FileInputStream(fw);

            System.out.println("Start uploading second file");
            OutputStream outputStream = ftpClient.storeFileStream(CCDAFILEPATH+fileName);
            byte[] bytesIn = new byte[4096];
            int read = 0;

            while ((read = inputStream1.read(bytesIn)) != -1) {
                outputStream.write(bytesIn, 0, read);
            }
            inputStream1.close();
            outputStream.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void downloadFile(File f,String filename)
    {
        FTPClient ftpClient = new FTPClient();
        try {
            this.propertValue();
            ftpClient.connect(SFTPHOST, SFTPPORT);
            ftpClient.login(SFTPUSER, SFTPPASS);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            String remoteFile2 = "/outgoing/";
            OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(f));
            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2+filename);
            byte[] bytesArray = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(bytesArray)) != -1) {
                outputStream2.write(bytesArray, 0, bytesRead);
            }

            boolean   success = ftpClient.completePendingCommand();
            if (success) {
                System.out.println("File #2 has been downloaded successfully.");
            }
            outputStream2.close();
            inputStream.close();

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void fileUpload(File fw, String fileName) throws Exception
    {
        this.propertValue();
        FTPClient ftp=new FTPClient();
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        ftp.connect(SFTPHOST);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftp.login(SFTPUSER, SFTPPASS);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
        try(InputStream input = new FileInputStream(fw)){
            ftp.storeFile(CCDAFILEPATH + fileName, input);
        }
    }

}