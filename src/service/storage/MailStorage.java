package service.storage;

import service.model.Mail;
import service.util.SerializeUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailStorage {
  private   List<Mail> mails = new ArrayList<>();
    public void add(Mail mail){
        mails.add(mail);
        try {
            SerializeUtil.serializeMail(mails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Mail> getReceivedMails(String email){
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getToEmail().equals(email)){
                result.add(mail);
            }
        }
        return result;
    }
    public List<Mail> getSentMails(String email){
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getFromEmail().equals(email)){
                result.add(mail);
            }
        }
        return result;
    }
    public void refreshMails() {
        File file = new File(SerializeUtil.MAIL_FILE_PATH);
        if (file.exists()) {
            try {
                mails = SerializeUtil.deserializeMails();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Can't create file for mails");
            }
        }
    }
}
