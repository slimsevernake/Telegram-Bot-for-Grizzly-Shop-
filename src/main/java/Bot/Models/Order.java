package Bot.Models;

import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Order {
    private long chat_id;
    private String customerName;
    private String customerSurname;
    private String customerPhone = "";
    private String deliveryMethod;
    private String address;
    String customerCart;
    String customerCartHTML;

    public Order() {
    }

    public void setChat_id(long chat_id) {
        this.chat_id = chat_id;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public long getChat_id() {
        return chat_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(String customerCart) {
        this.customerCart = customerCart;
    }

    public String getCustomerCartHTML() {
        return customerCartHTML;
    }

    public void setCustomerCartHTML(String customerCartHTML) {
        this.customerCartHTML = customerCartHTML;
    }

    @Override
    public String toString() {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(Calendar.getInstance().getTime());
        return "?????????? (?????????? ???????? " + chat_id + "):" +
                "\n???????? ????????????: " + timeStamp + "\n--------------------------------\n" +
                "\uD83D\uDC64 ????????????????????:" +
                "\n??????: " + customerName +
                "\n??????????????: " + customerSurname +
                "\n?????????? ????????????????: " + customerPhone + "\n--------------------------------\n" +
                "\uD83D\uDCE6 ??????????????????:" +
                "\n???????????? ??????????????????: " + deliveryMethod +
                "\n?????????? ??????????????????: " + address + "\n--------------------------------\n" +
                "\uD83D\uDED2 ???????????????????? ??????????????:\n" + customerCart;
    }

    public MimeMultipart toStringHTML() {
        MimeMultipart multipart = new MimeMultipart();
        MimeBodyPart bodyPart = new MimeBodyPart();
        try {
            bodyPart.addHeader("Content-Type", "text/html; charset=UTF-8");
            String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(Calendar.getInstance().getTime());
            bodyPart.setDataHandler(
                    new DataHandler(
    "<html>" +
            "<body>" +
            "<div style=\"gap: 10px; justify-content: space-evenly; align-items: center; justify-content: center\">" +
                "<div>" +
                    "<h3 style=\"margin-top: 0px;\">\uD83D\uDCCB ??????????</h3>" +
                    "<b>?????????? ????????:</b> " + chat_id + "</br>" +
                    "<b>???????? ????????????:</b> " + timeStamp +
                    "<hr size= 2 px; color=\"#535353\"/>" +
                    "<h3>\uD83D\uDC64 ????????????????????</h3>" +
                    "<b>??????:</b> " + customerName + "</br>" +
                    "<b>??????????????:</b> " + customerSurname + "</br>" +
                    "<b>??????????????:</b> " + customerPhone +
                     "<hr size= 2 px; color=\"#535353\"/>" +
                    "<h3>\uD83D\uDCE6 ??????????????????</h3>" +
                    "<b>???????????? ??????????????????:</b> " + deliveryMethod + "</br>" +
                    "<b>?????????? ??????????????????:</b> " + address +
                "</div>" +
                "<div>" +
                    "<hr size= 2 px; color=\"#535353\"/>" +
                    "<h3>\uD83D\uDED2 ???????????????????? ??????????????</h3>" +
                    customerCartHTML +
                "</div>" +
            "</div>" +
            "</body>" +
            "</html>",
    "text/html; charset=\"utf-8\""
                    )
            );
            multipart.addBodyPart(bodyPart);
            return multipart;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
