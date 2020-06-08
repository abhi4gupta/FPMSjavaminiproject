package sample;

import javafx.collections.FXCollections;

import java.util.Date;

public class Payment {
    String category;
    String topic;
    String tag;
    String fileName;
   // String comments;
    String PaymentNumber;
    String entryDate;
    String docs;
   String username;

    public Payment(String username,String category, String topic, String tag, String fileName, String entryDate,String docs) {
       this.username=username;
        this.category = category;
        this.topic = topic;
        this.tag = tag;
        this.fileName = fileName;

        this.entryDate = entryDate;
        this.docs=docs;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory() {
        return category;
    }

    public String getTopic() {
        return topic;
    }

    public String getTag() {
        return tag;
    }

    public String getFileName() {
        return fileName;
    }


    public String getEntryDate() {
        return entryDate;
    }

    public String getPaymentNumber() {
        return PaymentNumber;
    }

    public void setPaymentNumber(String PaymentNumber) {
        PaymentNumber = PaymentNumber;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }
}
