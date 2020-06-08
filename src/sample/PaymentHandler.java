package sample;

import com.sun.source.tree.Tree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class PaymentHandler {
ArrayList<Payment> Payments=new ArrayList<>();



    public ArrayList<Payment> getPayments() {
        return Payments;
    }


    public void addPayment(String username,String filename,String category,String topic,String tag,String text){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
     Payment tempdoc=new Payment(username,category,topic,tag,filename,dtf.format(localDate),text);
            Payments.add(tempdoc);
    }
   /*//* public String getProperties(String fileName){
     //this will return properties of the Payment
        Iterator it=Payments.iterator();
        String s="";
        Payment temp;
       // ArrayList<String> templist=new ArrayList<>();
        while(it.hasNext()){
            temp=(Payment)it.next();
            if(fileName.equals(temp.getFileName())){
               // ret
                s+="File Name-> ";
                s+=temp.getFileName() ;
                s+="";
                s+="Payment number-> ";
                s+=temp.getPaymentNumber() ;
                s+="  ";
                s+="Entry Date-> ";
                s+=temp.getEntryDate().toString() ;
                s+="\n";
                s+="Category-> ";
                s+=temp.getCategory() ;
                s+="\n";
                s+="Topic-> ";
                s+=temp.getTopic() ;
                s+="\n";
                s+="Tag-> ";
                s+=temp.getTag() ;
                s+="\n";


            }

        }
        return s;

    }
   /* public  Payment getPaymentViaFileName(String fileName){
        //this will give the contents of Payment of given fileName (return false if file not found)
         return new Payment("jkhdjs","kjghfds","jsdjfv","dhjgf","jhvfbhd"," ");
    }*//*
    public ArrayList<String> getPaymentViaCategory(String category){
        //this will give the arraylist of Payment of same category
        Iterator it=Payments.iterator();
        Payment temp;
        ArrayList<String> templist=new ArrayList<>();
        while(it.hasNext()){
            temp=(Payment) it.next();
            if(category.equals(temp.getCategory())){
                templist.add(temp.getFileName());
            }

        }
        return templist;
    }
    public  ArrayList<String> getPaymentViaTag(String tag){
        //this will give the arraylist of Payment of same tag
        Iterator it=Payments.iterator();
        Payment temp;
        ArrayList<String> templist=new ArrayList<>();
        while(it.hasNext()){
            temp=(Payment)it.next();
            if(tag.equals(temp.getTag())){
                templist.add(temp.getFileName());
            }

        }
        return templist;
    }
    public  ArrayList<String> getPaymentViaTopic(String topic) {
        //this will give the arraylist of Payment of same tag
        Iterator it=Payments.iterator();
        Payment temp;
        ArrayList<String> templist=new ArrayList<>();
        while(it.hasNext()){
            temp=(Payment)it.next();
            if(topic.equals(temp.getTopic())){
                templist.add(temp.getFileName());
            }

        }
        return templist;
    }

    public boolean deletePayment(String fileName){
        //delete  a Payment of given fileName (return true on success)
     return true;
    }
    */
    public Payment getPayment(String user,String fileName) {

        for(int i=0;i<Payments.size();i++)
        {
            if(Payments.get(i).getUsername().compareTo(user)==0&&Payments.get(i).getFileName().compareTo(fileName)==0)
                return Payments.get(i);
        }
        return Payments.get(0);
    }

        public ArrayList<String> userfilenames(String user)
        {    ArrayList<String > hh=new ArrayList<>();
           for(int i=0;i<Payments.size();i++)
           {
                if(Payments.get(i).getUsername().compareTo(user)==0)
                    hh.add(Payments.get(i).getFileName());
           }
      return hh;

        }
        public void deletedoc(String user,String filename)
        {
            for(int i=0;i<Payments.size();i++)
            {
                if(Payments.get(i).getUsername().compareTo(user)==0&&Payments.get(i).getFileName().compareTo(filename)==0)
                    Payments.remove(Payments.get(i));
            }
        }
        public ArrayList<Payment> searchviaTag(String tg)
        {            ArrayList<Payment> jj=new ArrayList<>();
            for(int i=0;i<Payments.size();i++)
            {
                if(Payments.get(i).getTag().compareTo(tg)==0)
                    jj.add(Payments.get(i));
            }
            return jj;
        }
    public ArrayList<Payment> searchviaCategry(String catg)
    {            ArrayList<Payment> jj=new ArrayList<>();
        for(int i=0;i<Payments.size();i++)
        {
            if(Payments.get(i).getCategory().compareTo(catg)==0)
                jj.add(Payments.get(i));
        }
        return jj;
    }
    public ArrayList<Payment> searchviaTopic(String topic)
    {            ArrayList<Payment> jj=new ArrayList<>();
        for(int i=0;i<Payments.size();i++)
        {
            if(Payments.get(i).getTopic().compareTo(topic)==0)
                jj.add(Payments.get(i));
        }
        return jj;
    }
    public String searchanything(String filen)
    {            String jj="";
          int f=0;
        for(int i=0;i<Payments.size();i++)
        {
            if(Payments.get(i).getTag().compareTo(filen)==0) {
                f=1;
                jj+=Payments.get(i).fileName+"\n"; }
        }
        if(f==1)
        return jj;
        for(int i=0;i<Payments.size();i++)
        {
            if(Payments.get(i).getCategory().compareTo(filen)==0) {
                f=1;
                jj+=Payments.get(i).fileName+"\n"; }
        }
        if(f==1)
            return jj;
        for(int i=0;i<Payments.size();i++)
        {
            if(Payments.get(i).getTopic().compareTo(filen)==0) {
                f=1;
                jj+=Payments.get(i).fileName+"\n"; }
        }
        if(f==1)
            return jj;
        return jj;
    }

      /*  public void userdeldoc(String user,String filename) {
            ArrayList<Payment> jj = userdoc.get(user);
            for (int i = 0; i < jj.size(); i++) {
                if (jj.get(i).getFileName().compareTo(filename) == 0)
                    jj.remove(jj.get(i));
            }
        }
        // return new Payment("hvb","lkhjv","lkj","","");
        //modify  Payment of given fileName(return false if file not found)
*/
    }



